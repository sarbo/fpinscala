package fpinscala.errorhandling

import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

/**
 * Created by sea on 2/22/15.
 */

@RunWith(classOf[JUnitRunner])
class ErrorHandlingSuite extends FunSuite {

  import fpinscala.errorhandling.Option._

  val doubles = Seq(1.0, 2.0, 3.0, 4.0, 5.0)
  val empty_doubles = Seq()

  test("mean(Seq(1.0, 2.0, 3.0, 4.0,5.0)) === Some(3.0)"){
    assert(mean(Seq(1.0, 2.0, 3.0, 4.0,5.0)) === Some(3.0))
  }

  test("mean(Seq()) === None"){
    assert(mean(Seq()) === None )
  }

  test("mean(doubles).map[Double](x => x * x) === Some(9.0)") {

    val y: Option[Double] = mean(doubles).map[Double](x => x * x)
    assert(y === Some(9.0) )
  }

  test("mean(doubles).getOrElse(None) === 3.0"){
    assert(mean(doubles).getOrElse(None) === 3.0)
  }

  test("mean(Seq()).getOrElse(None) === None"){
    assert(mean(Seq()).getOrElse(None) === None)
  }

  test("mean(doubles).orElse(None) === 3.0"){
    assert(mean(doubles).orElse(None) === Some(3.0))
    assert(mean(Seq()).orElse(None) === None)
  }

  test("variance of Seq(1.0, 2.0, 3.0, 4.0, 5.0)  is 2.0 "){
    assert(variance(doubles).getOrElse(None) === 2.0)
    assert(variance(Seq()) === None)
  }

  test("variance of Seq()  is None"){
    assert(variance(empty_doubles).getOrElse(None) === None)
  }

  test("filter(_ > 3.0) === List(4.0, 5.0)"){
    assert((doubles  filter(_ > 3.0)) === List(4.0, 5.0))
  }
}
