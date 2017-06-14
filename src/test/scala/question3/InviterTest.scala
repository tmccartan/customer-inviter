package question3

import java.io.FileNotFoundException

import com.fasterxml.jackson.core.JsonParseException
import org.scalatest._

class InviterTest extends FlatSpec with Matchers{

  it should "parse a correct customer json file" in {
    Inviter.parseCustomers("src/test/scala/question3/sample/singleCustomerFile.json") should be (Seq(
      Customer("52.986375", 12, "Christina McArdle", "-6.043701")
    ))
  }

  it should "throw an exception for invalid json" in {
    intercept[JsonParseException](
      Inviter.parseCustomers("src/test/scala/question3/sample/invalidCustomersFile.json")
    )
  }

  it should "throw an exception for a missing json file" in {
    intercept[FileNotFoundException](
      Inviter.parseCustomers("src/main/scala/question3/sample/doesntExist.json")
    )
  }

  it should "should return customers within 100km " in {

    val testCustomers = Seq(
      Customer("52.986375",1, "Christina McArdle", "-6.043701"),
      Customer("51.92893",2, "Alice Cahill", "-10.27699"),
      Customer("51.8856167",3, "Ian McArdle", "-10.4240951")
    )
    val expectedCustomers = Seq(
      Customer("52.986375",1, "Christina McArdle", "-6.043701")
    )
    Inviter.filterCustomers(testCustomers) should be(expectedCustomers)
  }

  it should "should order customers by user id" in {
    val testCustomers = Seq(
      Customer("54.0894797",7, "Eoin Ahearn", "-6.18671"),
      Customer("52.986375",1, "Christina McArdle", "-6.043701"),
      Customer("52.966",3, "Michael Ahearn", "-6.463")
    )
    val expectedCustomers = Seq(
      Customer("52.986375",1, "Christina McArdle", "-6.043701"),
      Customer("52.966",3, "Michael Ahearn", "-6.463"),
      Customer("54.0894797",7, "Eoin Ahearn", "-6.18671")
    )
    Inviter.filterCustomers(testCustomers) should be(expectedCustomers)
  }

  it should "Handle a large set of customers for filtering " in {
    val testCustomers = Seq(
      Customer("52.986375",1, "Christina McArdle", "-6.043701")
    ) ++ Seq.fill(60000) (
      Customer("51.92893",2, "Alice Cahill", "-10.27699")
    )
    val expectedCustomers = Seq(
      Customer("52.986375",1, "Christina McArdle", "-6.043701")
    )
    Inviter.filterCustomers(testCustomers) should be(expectedCustomers)
  }

}

