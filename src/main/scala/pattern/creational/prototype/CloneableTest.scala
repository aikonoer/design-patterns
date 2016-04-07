package pattern.creational.prototype

/**
  * Created by brianmomongan on 4/6/16.
  */
case class CloneableTest(name: String, age: Int) extends Cloneable

object Main extends App {
  val c = CloneableTest("Brian", 12)
  val n = c copy()

  println(c)
  println(n)
}


