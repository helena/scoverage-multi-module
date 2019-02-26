package one

import org.scalatest.{WordSpec, Matchers}

import scala.util.Success

class TestOne extends WordSpec with Matchers {
  "One" must {
    "pass" in {
      new One(1).by(0) shouldBe Success(0)
    }
    "fail" in {
      new One(0).by(1).isFailure shouldBe true
    }
  }
}