package fpinscala.state

/**
  * Created with IntelliJ IDEA.
  * User: sarbogast
  * Date: 11/16/2015
  * Time: 9:49 AM
  */

import fpinscala.state.RNG._
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class StateSuite extends FunSuite {

  test("nextInt: (Int, RNG)") {

    val rng = Simple(42)

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


  test("nonNegativeInt(rng: RNG): (Int, RNG)") {

    val rng = Simple(42)

    val (n1, rng1) = nonNegativeInt(rng)
    assert(n1 === 16159453)
    println("n1 : " + n1)

    val (n2, rng2) = nonNegativeInt(rng1)
    assert(n2 === 1281479696)
    println("n2 : " + n2)

    val (n3, rng3) = nonNegativeInt(rng2)
    assert(n3 === 340305901)
    assert(rng2.toString === "Simple(197491923327988)")
    println("n3 : " + n3 + " rng2: " + rng2)
  }

  test("double(rng: RNG): (Double, RNG)") {

    val rng = Simple(42)

    val (d1, rng1) = double(rng)
    assert(0.0 < d1 && d1 < 1.0)
    println("d1: " + d1)

    val (d2, rng2) = double(rng1)
    println("d2: " + d2)
  }


  test("_double(rng: RNG): Rand[Double]") {

    val rng = Simple(42)

    val d1: RNG.Rand[Double] = _double(rng)
    assert(0.0 < d1(rng)._1 && d1(rng)._1 < 1.0)
    println("d1: " + d1(rng))

    val d2: RNG.Rand[Double] = _double(d1.apply(rng)._2)
    println("d2: " + d2(d1(rng)._2))
  }

  test("map2(_.nextInt, double)((_1: Int, _2: Double) => (_1: Int, 2: Double))") {

    val result = map2(_.nextInt, double)((_1: Int, _2: Double) => (_1: Int, 2: Double))
    val rng = Simple(42)
    println("result: " + result(result(rng)._2))

  }

  test(" nonNegativeLessThan(n: Int): Rand[Int]") {

    val r1: RNG.Rand[Int]  = nonNegativeLessThan(42)
    val r2 =  nonNegativeLessThan(6)
    val rng1 = Simple(42)
    val rng2 = Simple(6)
    val (j,rnext) =  r1(rng1)
    println("result r1: " + r1(rng1))
    println("result r1-next: " + r1(rnext))
    println("result r2 : " + r2(rng2))

  }

  test(" _nonNegativeLessThan(n: Int): Rand[Int]") {

    val r1 = _nonNegativeLessThan(6)
    val r2 = _nonNegativeLessThan(6)
    val r3 = _nonNegativeLessThan(6)
    val r4 = _nonNegativeLessThan(6)
    val rng1 = Simple(5)
    val (j,rng2) =  r1(rng1)
    val (k,rng3) =  r2(rng2)
    val (l,rng4) =  r2(rng3)
    println("result _r1 : " + r1(rng1))
    println("result _r2 : " + r2(rng2))
    println("result _r3 : " + r3(rng3))
    println("result _r4 : " + r4(rng4))

    //def rollDie: Rand[Int] = nonNegativeLessThan(6)
    def rollDie: RNG.Rand[Int] = map(nonNegativeLessThan(6))(_ + 1)
    val zero = rollDie(Simple(5))._1
    //val zero = rollDie(1923744)
    println("zero: " + zero)
  }


  test("ints(count: Int)(rng: RNG): (List[Int], RNG)") {

    val r = Simple(100)
    val (listInts, rng) = ints(10)(r)
    println("listInts:" + listInts)
    assert(listInts(0) === 38474890)
    assert(listInts(1) === 419891633)
  }

  test("State"){

    val testState1 = State.unit[RNG, Int](42).run(Simple(42))
    println("testState1: (" + testState1._1 + "," + testState1._2 + ")")

    val testState2 = new State[RNG, Int](RNG => ( 42,Simple(42))).run(Simple(42))
    println("testState2: (" + testState2._1 + "," + testState2._2 + ")")





  }
}
