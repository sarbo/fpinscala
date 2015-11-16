package fpinscala.state

/**
  * Created with IntelliJ IDEA.
  * User: sarbogast
  * Date: 11/16/2015
  * Time: 9:49 AM
  */

import fpinscala.state.RNG.Simple
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class StateSuite extends FunSuite {

  test("RNG.Simple(42)") {

    val rng = RNG.Simple(42)

    val n1 = rng.nextInt
    assert(n1._1  === 16159453)
    println("n1 : " + n1._1)

    val (n2, rng1) = rng.nextInt
    assert(n2  === 16159453)
    println("n2 : " + n2)

    val (n3,rng2) = rng1.nextInt
    assert(n3 === -1281479697)
    assert(rng2.toString === "Simple(197491923327988)")
    println("n3: " + n3 + " rng2: " + rng2)
  }
}
