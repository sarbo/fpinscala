package fpinscala.datastructures


import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class DataStructuresSuite extends FunSuite {

  import fpinscala.datastructures.List._

  val intList = List(1,2,3,4,5)
  val doubleList = List(1.0,2.0,3.0,4.0,5.0)

  test("sum(List(1, 2, 3, 4, 5)) === 15"){
    assert(sum(intList) === 15)
  }

  test("product(List(1.0,2.0,3.0,4.0,5.0)) === 120)") {
    assert(product(doubleList) === 120)
  }

  test ("foldRight[Int, Int](List(1,2,3,4,5), 0)((x,y) =>  x + y ) === 15"){
     assert(foldRight[Int, Int](intList, 0)((x,y) =>  x + y ) === 15)
   }

  test ("foldRight[Int, Double](List(1,2,3,4,5), 1.0)((x,y) =>  x * y ) === 120"){
    assert(foldRight[Int, Double](intList, 1.0)((x,y) =>  x * y ) === 120)
  }

  test("drop[Int](intList, 3) === List(1,2,3)"){
    assert(drop[Int](intList, 3) === List(4,5))
  }

  test("dropWhile[Int](List(1,2,3,4,5), x => x < 3) === List(3,4,5)"){
    assert(dropWhile[Int](intList, x => x < 3) === List(3,4,5))
  }

  test("dropWhile2(intList) (x => x < 3) === List(3,4,5)"){
    assert(dropWhile2(intList) (x => x < 3) === List(3,4,5))
  }

  test("assert(init[Int](intList) === List(1,2,3,4))"){
    assert(init[Int](intList) === List(1,2,3,4))
  }

  test("map[Int,Int](intList)(x => x*x) === List(1,4,9,16, 25)"){
    assert(map[Int,Int](intList)(x => x*x) === List(1,4,9,16, 25))
  }

}