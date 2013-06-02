import shapeless._
  
object headerOption extends (Seq ~> Option) {
  def apply[T](s : Seq[T]) = s.headOption
}

object HeadHunterOption {
  def get[A](a:Seq[A]):Option[A] = 
    a.headOption
    
  def get[InT <: Product, OutT <: Product, InL <: HList, OutL <: HList](t : InT)
    (implicit hl : HListerAux[InT, InL], 
     mapper : MapperAux[headerOption.type, InL, OutL],
     tupler : TuplerAux[OutL, OutT]) = {
    val h = hl(t)
    val o = h map headerOption
    val r = o.tupled  
    r
  }
}

import TypeOperators._

object header extends (Seq ~> Id) {
  def apply[T](s : Seq[T]) = s.head
}

object HeadHunter {
  def get[A](a:Seq[A]):A = 
    a.head
    
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
