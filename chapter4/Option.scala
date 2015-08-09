package chapter4

sealed trait Option[+A]{

	def isEmpty: Boolean

	def get: A

	def map[B](f: A => B):Option[B] ={
		this match {
			case Some(a) => Some(f(a))
			case None => None 
		}	
	}
	def flatMap[B](f: A=> Option[B]): Option[B]={
		if(isEmpty) None
		else f(get)
	}
	def getOrElse[B >: A](default: => B): B ={
		if(isEmpty) default
		else get

	}
	def orElse[B >: A](ob: => Option[B]):Option[B]={
		if(isEmpty) ob
		else this
	}
	def filter(f: A => Boolean): Option[A]={
		if(isEmpty) None
		else if(f(get)) this
		else None

	}
}

case class Some[+A](get: A) extends Option[A]{
	 def isEmpty=false
	 //def get = value
	 
}

case object None extends Option[Nothing]{
	def isEmpty = true
	def get = throw new java.util.NoSuchElementException
	
}