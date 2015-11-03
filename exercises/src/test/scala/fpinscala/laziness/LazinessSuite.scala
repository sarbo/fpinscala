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

  test("Stream(1, 2, 3, 4).foldRight(0) ((b,a) => b+a)"){
    assert(Stream(1, 2, 3, 4).foldRight(0) ((b,a) => b+a) === 10)
  }


  test ("Stream(1,2,3,4).exists(_ == 3"){
      assert(Stream(1, 2, 3, 4).exists( _ == 3) === true)
  }

  test ("Stream(1,2,3,4).exists(_ == 5"){
    assert(Stream(1, 2, 3, 4).exists( _ == 5) === false)
  }

}
