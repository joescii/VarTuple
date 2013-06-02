import shapeless._
  
object header extends (Seq ~> Option) {
  def apply[T](s : Seq[T]) = s.headOption
}

object HeadHunter {
  def get[A](a:Seq[A]):Option[A] = 
    a.headOption
    
  def get[T <: Product, L <: HList](t : T)
    (implicit hl : HListerAux[T, L], 
     mapper : Mapper[header.type, L],
     tupler : Tupler[L]) = {
    val h = hl(t)
    val o = h map header
//    o.tupled
    o
  }
}
