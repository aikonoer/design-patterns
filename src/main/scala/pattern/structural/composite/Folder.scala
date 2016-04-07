package pattern.structural.composite

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

/**
  * Created by brianmomongan on 3/30/16.
  */
trait Directory {

  override def toString: String
}

case class File(fileName: String, filePath: String) extends Directory {

  override def toString: String = filePath + "/" + fileName

}

case class Folder(folderName: String, folderPath: String = "") extends Directory {

  val listFolder: ListBuffer[Folder] = ListBuffer()

  val listFiles: ListBuffer[File] = ListBuffer()

  def addFolder(name: String): Folder = {
    val newFolder = Folder(name, folderPath + "/" + folderName)
    listFolder += newFolder
    newFolder
  }

  def addFile(name: String): File = {
    val newFile = File(name, folderPath + "/" + folderName)
    listFiles += newFile
    newFile
  }

  def deleteFolder(name: String): String = {
    listFolder find (_.folderName == name) match {
      case Some(s) =>
        listFolder -= s
        "Success"
      case None    => "Failed"
    }
  }

  def deleteFile(name: String): Unit = {
    listFiles find (_.fileName == name) match {
      case Some(s) => listFiles -= s
    }
  }

  def printFolders: List[String] = {
    if (listFolder.nonEmpty)
      listFolder.toList map (f => this + "/" + f.folderName)
    else Nil
  }

  def printFiles: List[String] = {
    if (listFiles.nonEmpty)
      listFiles.toList map (f => this + "/" + f.fileName)
    else Nil
  }

  def printAll: List[String] = printFolders ++ printFiles

  def allFilesWithPath: List[String] = crawl map (_.toString)

  def allFiles: List[String] = crawl map (_.fileName)

  private def crawl: List[File] = {

    @tailrec
    def go(current: Folder, folders: List[Folder] = List(), files: List[File] = List()): List[File] = {
      val foldersAgg = current.listFolder.toList ++ folders
      val filesAgg = current.listFiles.toList ++ files

      if (foldersAgg.isEmpty) filesAgg
      else go(foldersAgg.head, foldersAgg.tail, filesAgg)
    }
    go(this)
  }

  override def toString: String = folderPath + "/" + folderName
}

object Main extends App {
  val rootFolder = Folder("root")
  val docsFolder = rootFolder addFolder "docs"
  val picturesFolder = docsFolder addFolder "pictures"
  val cebuFile = picturesFolder addFile "opon.jpg"
  val phFile = picturesFolder addFile "bohol.jpg"
  val rootFile = rootFolder addFile "cv.doc"
  val cebuFolder = picturesFolder addFolder "cebuImages"
  val cebuImg = cebuFolder addFile "cebuImg.png"

  docsFolder deleteFolder "pictures"
  rootFolder deleteFile "cv.doc"
  println(picturesFolder)
  println(docsFolder.printFolders)
  docsFolder.allFilesWithPath.map(println)

}








