package fpinscala.datastructures


import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class DataStructuresSuite extends FunSuite {

  import fpinscala.datastructures.List._


  test("sum(List(1, 2, 3, 4, 5)) === 15"){

    assert(sum(List(1, 2, 3, 4, 5)) === 15)
  }

  test("product(List(1,2,3,4,5)) === 120)")
  { assert(product(List(1,2,3,4,5)) === 120)}

   test ("foldRight[Int, Int](List(1,2,3,4,5), 0)((x,y) =>  x + y ) === 15"){
     assert(foldRight[Int, Int](List(1,2,3,4,5), 0)((x,y) =>  x + y ) === 15)
   }


  test ("foldRight[Int, Double](List(1,2,3,4,5), 0)((x,y) =>  x + y ) === 15"){
    assert(foldRight[Int, Double](List(1,2,3,4,5), 1.0)((x,y) =>  x * y ) === 120)
  }

}