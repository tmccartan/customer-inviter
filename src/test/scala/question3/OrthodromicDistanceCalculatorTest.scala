package question3

import org.scalatest._

class OrthodromicDistanceCalculatorTest  extends FlatSpec with OrthodromicDistanceCalculator with Matchers{

  it should "should calculate a distance correctly" in {
    val lat1 = "36.12".toDouble
    val long1 = "-86.67".toDouble
    val lat2 = "33.94".toDouble
    val long2 = "-118.40".toDouble
    calculateDistance(lat1,long1, lat2, long2) should be (2887.2599506071106)
  }

}
