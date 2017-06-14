package question2

object ListFlatten {
  def flatten(array: List[Any]): List[Int] = array match {
   case Nil => Nil
   case (head: List[_]) :: tail => flatten(head) ++ flatten(tail)
   case (head : Int) :: tail => head :: flatten(tail)
   case _ => sys.error("Invalid type")
 }
}
