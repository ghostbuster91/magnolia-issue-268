package something


trait Show[-T] {
  def show(value: T): String = {
    println("qwe")
    "qwe"
  }
}

object Show extends LowPriorityImplicits {
  implicit val stringInstance: Show[String] = new Show[String] {}
}

trait LowPriorityImplicits {
  // Implicit instance of Diff[T] created from implicit Derived[Diff[T]]
  implicit def derivedDiff[T](implicit dd: Derived2[Show[T]]): Show[T] = dd.value

//   Implicit conversion
  implicit def unwrapDerivedDiff[T](dd: Derived2[Show[T]]): Show[T] = dd.value
}
