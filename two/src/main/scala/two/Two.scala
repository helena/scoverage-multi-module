package two

import one.One

import scala.util.Try

object Two extends App {

  def run(a: Int, b: Int): Try[Int] = {
    val c = new One(a).by(b)
    println(s"Running with a = $a, b = $b yields $c")
    c
  }
}
