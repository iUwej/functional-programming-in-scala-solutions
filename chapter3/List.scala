

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A,tail: List[A]) extends List[A]

object List {

	def apply[A](as: A*): List[A]=
		if(as.isEmpty) Nil
		else Cons(as.head,apply(as.tail: _*))
}

//Exercise 2
def tail[A](lst: List[A]):List[A]={
	lst match {
		case Nil => Nil
		case Cons(head,tail) => tail
		
	}
	
}

//Exercise 3

def drop[A](list: List[A],n: Int):List[A]={

	if(n==0)list
	else list match {
		case Nil => Nil
		case Cons(x,y) => drop(y,n-1)
	}
	
}

//Exercise 4
def dropWhile[A](list: List[A])(f: A=> Boolean): List[A]={

	list match {
		case Nil => Nil
		case Cons(x,y) => if(!f(x))Cons(x,dropWhile(y)(f))
						  else dropWhile(y)(f)
	}
	
}

//Exercise 5

def setHead[A](list:List[A],newHead: A): List[A]={
	list match {
		case Nil => Cons(newHead,Nil)
		case Cons(x,y) => Cons(newHead,y)
	}
	
}

//exercise 6

def init[A](l: List[A]):List[A]={
	l match {
		case Nil => Nil
		case Cons(x,Nil)=>Nil
		case Cons(x,y) =>Cons(x,init(y))
	}
	
}

//foldRight example
def foldRight[A,B](l: List[A],z: B)(f : (A,B) => B): B =
	l match {
		case Nil => z
		case Cons(x,xs) => f(x,foldRight(xs,z)(f))
	}

//exercise 9
def length[A](list: List[A]):Int =
	foldRight(list,0: Int){(x,y) => 1 + y}

//exercise 10
def foldLeft[A,B](list: List[A],z: B)(f: (B,A) => B): B={
	
	def foldIter(l: List[A],a: B): B=
		l match {
			case Nil => a
			case Cons(x,xs) => foldIter(xs,f(a,x))
		}

	foldIter(list,z)

}

//exercise 11
def sum(list : List[Int])=
	foldLeft(list,0 : Int)(_ + _)

def product(list: List[Double])=
	foldLeft(list,1.0)(_ * _)

def foldUsingLength[A](list: List[A])={
		foldLeft(list,0 )((x,y) => x + 1)
}
	

