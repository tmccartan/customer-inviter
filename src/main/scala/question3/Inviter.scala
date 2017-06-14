package question3

import java.io.FileNotFoundException

import com.fasterxml.jackson.core.JsonParseException
import play.api.libs.json.{JsonValidationError, Json}
import scala.io.Source

object Inviter {

  val officeLat = "53.3393".toDouble
  val officeLong = "-6.2576841".toDouble
  val sampleFile = "src/main/scala/question3/sample/customers.json"
  val defaultDistanceCutOffKm = 100
  //Invites a list of customers within 100km
  def inviteCustomers() ={
    filterCustomers(parseCustomers(sampleFile))
  }

  def filterCustomers(customers:Seq[Customer]) = {
    customers.filter( customer =>
      customer.calculateDistance(officeLat, officeLong) < defaultDistanceCutOffKm
    ).sortBy(_.user_id)
  }

  //Parse a json list of customers at a specific file path.
  // will throw an error if there is invalid json or file is missing
  def parseCustomers(filePath : String): Seq[Customer] = {

    implicit val customerReads = Json.reads[Customer]

    try {
      Source.fromFile(filePath).getLines().map {
        jsonLine =>
          Json.parse(jsonLine).as[Customer]
      }.toSeq
    } catch  {
      case e: FileNotFoundException =>
        println(s"File doesn't exit in path $sampleFile")
        throw e
      case e: JsonParseException =>
        println(s"File 'wasnt in a correct format")
        throw e
      // Ignoring other errors
    }
  }
}
