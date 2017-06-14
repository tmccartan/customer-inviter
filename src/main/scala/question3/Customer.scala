package question3
//needs to match the json, queue the snake case naming
case class Customer(latitude : String, user_id: Int,  name: String, longitude: String) extends OrthodromicDistanceCalculator {

  def calculateDistance(homeLat: Double, homeLong: Double): Double = {
    calculateDistance(latitude.toDouble, longitude.toDouble, homeLat, homeLong)
  }
}

