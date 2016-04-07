package pattern.structural.decorator

/**
  * Created by brianmomongan on 4/1/16.
  */
abstract class DecoratorPizza(pizza: Pizza) extends Pizza {}


class Hotdog(pizza: Pizza) extends DecoratorPizza(pizza){
  override def make: String = pizza.make + "adding hotdog"
}

class Veggies(pizza: Pizza) extends DecoratorPizza(pizza) {
  override def make: String = pizza.make + "adding veggies"
}

object Main extends App{
  val pizza = new Veggies(new Hotdog(new Hawaiian)).make
  println(pizza)

  val hawaiian = new Hotdog(new Hawaiian).make
  println(hawaiian)
}
