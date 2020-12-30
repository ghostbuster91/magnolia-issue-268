package something

import magnolia.Magnolia
import scala.language.experimental.macros

object MagnoliaDerivedMacro {
  import scala.reflect.macros.whitebox

  def derivedGen[T: c.WeakTypeTag](c: whitebox.Context): c.Expr[Derived2[T]] = {
    import c.universe._
    c.Expr[Derived2[T]](q"something.Derived2(${Magnolia.gen[T](c)(implicitly[c.WeakTypeTag[T]])})")
  }
}
