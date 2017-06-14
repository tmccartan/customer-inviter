package question3

import org.scalatest.{Matchers, FlatSpec}

class CustomerTest extends FlatSpec with Matchers{

  it should "Calculate the distance correctly" in {
    Customer("53.3498053", 1, "Tony Stark", "-6.26030969").calculateDistance("57.3498053".toDouble,"-6.26030969".toDouble) should be(444.90537028437853)
  }
}
