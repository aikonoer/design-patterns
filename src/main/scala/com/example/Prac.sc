import scala.annotation.tailrec

def isSorted[A](as: Array[A], gt: (A, A) => Boolean): Boolean = {

  @tailrec
  def loop(i: Int): Boolean = {
    if (i == as.size - 1) true
    else {
      if (gt(as(i), as(i + 1))) loop(i + 1) else false
    }
  }
  loop(0)
}
val a = Array(1, 2, 3, 4, 4, 5, 1)
isSorted[Int](a, (x, y) => x < y)

def fib(n: Int): Int = {
  @tailrec
  def loop(n: Int, x: Int = 0, y: Int = 1): Int = n match {
    case 0 => x
    case 1 => y
    case _ => loop(n - 1, y, x + y)
  }
  loop(n)
}

fib(8)


def fact(n: Int): Int = {
  @tailrec
  def loop(n: Int, acc: Int = 1): Int = n match {
    case 0 => acc
    case _ => loop(n - 1, n * acc)
  }
  loop(n)
}

fact(4)

def bunnies(n: Int): Int = {
  @tailrec
  def loop(n: Int, acc: Int = 0): Int = n match {
    case 0 => acc
    case _ => loop(n-1, acc+2)
  }

  def isEven(n: Int) : Boolean = if(n%2==0) true else false
  loop(n)
}
bunnies(0).
























