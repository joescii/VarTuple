import shapeless._
  
object header extends (Seq ~> Option) {
  def apply[T](s : Seq[T]) = s.headOption
}

object HeadHunter {
  def get[A](a:Seq[A]):Option[A] = 
    a.headOption
    
  def get[InT <: Product, OutT <: Product, InL <: HList, OutL <: HList](t : InT)
    (implicit hl : HListerAux[InT, InL], 
     mapper : MapperAux[header.type, InL, OutL],
     tupler : TuplerAux[OutL, OutT]) = {
    val h = hl(t)
    val o = h map header
    val r = o.tupled  
    r
  }
}
