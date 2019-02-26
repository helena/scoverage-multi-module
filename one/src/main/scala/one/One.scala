package one

import scala.util.Try

final class One(n: Int) {

  def by(i: Int): Try[Int] = Try(i / n)

}