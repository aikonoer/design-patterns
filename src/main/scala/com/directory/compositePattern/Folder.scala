package com.directory.compositePattern

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

  def printFolders: List[String] = {
    if (!listFolder.isEmpty)
      listFolder.toList map (f => this + "/" + f.folderName)
    else Nil
  }

  def printFiles: List[String] = {
    if (!listFiles.isEmpty)
      listFiles.toList map (f => this + "/" + f.fileName)
    else Nil
  }

  def printAll: List[String] = printFolders ++ printFiles

  override def toString: String = folderPath + "/" + folderName
}

object Main extends App {
  val root = Folder("root")
  val docs = root addFolder "docs"
  val pictures = docs addFolder "pictures"
  val cebu = pictures addFile "opon.jpg"
  val ph = pictures addFile "bohol.jpg"
  val rootFile = root addFile "cv"

  pictures.printFiles map println
}

