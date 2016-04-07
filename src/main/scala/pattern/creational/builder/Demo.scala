package pattern.creational.builder

/**
  * Created by brianmomongan on 4/6/16.
  */
case class Demo(name: String = "", age: Int = 0) {
  def name(name: String): Demo = this.copy(name)
  def age(age: Int):Demo = this.copy(this.name, age)
}


object Main extends App {
  val d = Demo().name("Diane").age(20)
  println(d)
}