package question3

object Application extends App {

  override def main(args:Array[String]): Unit ={

    Inviter.inviteCustomers().toList.sortBy(_.user_id).foreach { customer =>
      println(s"${customer.name}, ${customer.user_id}")
    }
  }

}
