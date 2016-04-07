package pattern.creational.factory

/**
  * Created by brianmomongan on 4/6/16.
  */
trait Animal {
  def talk
}

class Dog extends Animal {
  override def talk: Unit = println("Dog barking")
}

class Cat extends Animal {
  override def talk: Unit = println("Cat meowing")
}

object AnimalFactory {

  def createAnimal(name: String): Animal = name match {
    case "DOG" => new Dog
    case "CAT" => new Cat
  }
  
}

object Main extends App {

  val animal: Animal = AnimalFactory.createAnimal("DOG")
  animal.talk
}