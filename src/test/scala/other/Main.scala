package other

import something.{BaseType, Derived2, Show, SubType1}

object Main {
  import something.auto._

  def main(args: Array[String]): Unit = {
    //this works
    implicit val  a : Show[SubType1] = implicitly[Derived2[Show[SubType1]]]

    // this doesn't, it complains about forward reference
    implicit val  b : Show[BaseType] = implicitly[Derived2[Show[BaseType]]]
    b.show(SubType1("qwe"))
  }
}
