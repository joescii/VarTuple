object HeadHunter {
 def get[A](a:Seq[A]):Option[A] = 
    a.headOption
  def get[A,B](a:Seq[A],b:Seq[B]):(Option[A],Option[B]) = 
    (a.headOption, b.headOption)
  def get[A,B,C](a:Seq[A],b:Seq[B],c:Seq[C]):(Option[A],Option[B],Option[C]) = 
    (a.headOption, b.headOption, c.headOption)
}
