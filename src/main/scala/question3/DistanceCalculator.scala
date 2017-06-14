package question3

//in case we want other calculators
trait DistanceCalculator {

  def calculateDistance(latitude1: Double, longitude1: Double, latitude2: Double, longitude2: Double): Double
}

trait OrthodromicDistanceCalculator extends DistanceCalculator {

  import math._
  val R = 6372.8 //radius of earth in km

  override def calculateDistance(latitude1: Double, longitude1: Double, latitude2: Double, longitude2: Double): Double = {
    haversine(latitude1, longitude1, latitude2, longitude2)
  }

  // sourced from https://rosettacode.org/wiki/Haversine_formula#Scala, called out in readme as well
  private def haversine(lat1: Double, lon1: Double, lat2: Double, lon2: Double) = {
    val dLat=(lat2 - lat1).toRadians
    val dLon=(lon2 - lon1).toRadians

    val a = pow(sin(dLat/2),2) + pow(sin(dLon/2),2) * cos(lat1.toRadians) * cos(lat2.toRadians)
    val c = 2 * asin(sqrt(a))
    R * c
  }
}