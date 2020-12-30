package something

package object auto extends AutoDerivation {

}

trait AutoDerivation extends MagnoliaDerivation {
  implicit def caseClass[T]: Derived2[Show[T]] = macro MagnoliaDerivedMacro.derivedGen[T]
}
