package something

import magnolia.{CaseClass, SealedTrait}

trait MagnoliaDerivation {
  type Typeclass[T] = Show[T]
  
  def combine[T](ctx: CaseClass[Show, T]): Show[T] = new Show[T] {
    override def show(value: T): String = ctx.parameters.map { p =>
      s"${p.label}=${p.typeclass.show(p.dereference(value))}"
    }.mkString("{", ",", "}")
  }

  def dispatch[T](ctx: SealedTrait[Show, T]): Show[T] =
    new Show[T] {
     override def show(value: T): String = ctx.dispatch(value) { sub =>
        sub.typeclass.show(sub.cast(value))
      }
    }
//  def fallback[T] : Show[T] = new Show[T] {}
}
