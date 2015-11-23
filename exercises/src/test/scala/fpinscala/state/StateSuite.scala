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

  test("nextInt: (Int, RNG)") {

    val rng = RNG.Simple(42)

    val n1 = rng.nextInt
    assert(n1._1 === 16159453)
    println("n1 : " + n1._1)

    val (n2, rng1) = rng.nextInt
    assert(n2 === 16159453)
    println("n2 : " + n2)

    val (n3, rng2) = rng1.nextInt
    assert(n3 === -1281479697)
    assert(rng2.toString === "Simple(197491923327988)")
    println("n3: " + n3 + " rng2: " + rng2)

    val (n4, rng3) = rng2.nextInt
    assert(n4 === -340305902)
    assert(rng2.toString === "Simple(197491923327988)")
    println("n4: " + n4 + " rng3: " + rng3)
  }


  test("nonNegativeInt(rng: RNG): (Int, RNG)"){

    val rng = RNG.Simple(42)

    val (n1, rng1) = RNG.nonNegativeInt(rng)
    assert(n1 === 16159453)
    println("n1 : " + n1)

    val (n2, rng2) = RNG.nonNegativeInt(rng1)
    assert(n2 === 1281479696)
    println("n2 : " + n2)

    val (n3, rng3) = RNG.nonNegativeInt(rng2)
    assert(n3 === 340305901)
    assert(rng2.toString === "Simple(197491923327988)")
    println("n3 : " + n3 + " rng2: " + rng2)
  }

  test("double(rng: RNG): (Double, RNG)"){

    val rng = RNG.Simple(42)

    val (d1, rng1) = RNG.double(rng)
    assert(0 < d1 && d1 < 1)
    println("d1 : " + d1)

    val (d2, rng2) = RNG.double(rng1)
    println("d2 : " + d2)
  }

}
