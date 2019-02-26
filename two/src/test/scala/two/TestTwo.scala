package two

import org.scalatest.{WordSpec, Matchers}

import scala.util.Success

class TestTwo extends WordSpec with Matchers {
  "Two" must {
    "pass" in {
      two.Two.run(1, 2) shouldBe Success(2)
    }
    "fail" in {
      two.Two.run(0, 1).isFailure shouldBe true
    }
  }
}