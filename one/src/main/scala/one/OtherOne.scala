package one

import scala.util.Try

class OtherOne(n: Int) {

  def by(i: Int): Try[Int] = Try(i * n)

}