package fpinscala.state

/**
  * Created with IntelliJ IDEA.
  * User: sarbogast
  * Date: 11/16/2015
  * Time: 9:49 AM
  */

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class StateSuite extends FunSuite {

  test("try it") {

    val rng = RNG.Simple(42)

    val n1 = rng.nextInt
    println("n1 : " + n1)

    val (n2, rng1) = rng.nextInt
    println("n2 : " + n2)


    println(rng1.nextInt)
  }
}
