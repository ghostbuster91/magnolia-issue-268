package something

sealed trait BaseType {
  def id : String
}

final case class SubType1(id: String) extends BaseType
final case class SubType2(id: String) extends BaseType

case class Derived2[T](value: T)



