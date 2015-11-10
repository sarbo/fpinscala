package fpinscala.laziness

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * Created with IntelliJ IDEA.
  * User: sarbogast
  * Date: 11/3/2015
  * Time: 9:10 AM
  */

@RunWith(classOf[JUnitRunner])
class LazinessSuite extends FunSuite {

  test ("Stream(1,2,3) != Stream(1,2,3)") {
    assert(Stream(1,2,3) == Stream(1,2,3) === false)
  }

  test("Stream(1, 2, 3, 4).foldRight(0) ((x,y) => x + y)"){
    assert(Stream(1, 2, 3, 4).foldRight(0) ((x,y) => x + y) === 10)
  }

  test ("Stream(1,2,3,4).exists(_ == 3"){
    assert(Stream(1, 2, 3, 4).exists( _ == 2) === true)
    assert(Stream(1, 2, 3, 4).exists( _ == 3) === true)
  }

  test ("Stream(1,2,3,4).exists(_ == 5"){
    assert(Stream(1, 2, 3, 4).exists( _ == 5) === false)
  }

  test("Stream(1,2,3,4).toList") {
    assert(Stream(1,2,3,4).toList === List(1,2,3,4))
  }

  test("Stream().toList") {
    assert(Stream().toList === Nil)
  }

  test ("Stream(1,2,3,4).take(2)"){
    assert(Stream(1, 2, 3, 4).take(2).exists( _ == 1) === true)
    assert(Stream(1, 2, 3, 4).take(2).exists( _ == 2) === true)
    assert(Stream(1, 2, 3, 4).take(2).exists( _ == 3) === false)
  }

  test ("Stream(1,2,3,4).drop(2)"){
    assert(Stream(1, 2, 3, 4).drop(1).exists( _ == 1) === false)
    assert(Stream(1, 2, 3, 4).drop(2).exists( _ == 2) === false)
    assert(Stream(1, 2, 3, 4).take(3).exists( _ == 3) === true)
  }


  test ("Stream(1,2,3,4).takeWhile( _ > 2)"){
    //assert(Stream(1,2,3,4).takeWhile(_ > 2).exists(_ == 3) === true)
    //assert(Stream(1,2,3,4).takeWhile(_ > 2).exists(_ == 4) === true)
    //assert(Stream(1,2,3,4).takeWhile(_ > 2).exists(_ == 2) === false)
    //println(Stream(1,2,3,4).takeWhile(_ < 2).toList)
    println(Stream(1,2,3,4).takeWhile(_ > 2).toList)
  }
}
