package question2

import org.scalatest._

class ListFlattenTests extends FlatSpec with Matchers {

  it should "flatten a list of ints" in {
    val testCase = List(1, List(1, 2 ,3), 2)
    val expectResult = List(1, 1, 2 ,3, 2)
    val result = ListFlatten.flatten(testCase)
    result should be(expectResult)
  }
  it should "flatten a list within a list, within a list" in {
    val testCase = List(1, List(List(2, 2), 2 ,3), 2)
    val expectResult = List(1, 2, 2, 2 ,3, 2)
    val result = ListFlatten.flatten(testCase)
    result should be(expectResult)
  }

  it should "should fail to flatten anything that isn't an int" in {
    val testCase = List("1", List("1", "2" ,"3"), "2")
    val exception = intercept[RuntimeException] {
      ListFlatten.flatten(testCase)
    }
    exception.getMessage should be("Invalid type")
  }

  it should "Handle a large set of data" in {
    val testCase = List(1, List.fill(10000)(1), 2, 2)
    val expectResult = List(1) ++  List.fill(10000)(1) ++ List(2, 2)
    val result = ListFlatten.flatten(testCase)
    result should be(expectResult)
  }

}
