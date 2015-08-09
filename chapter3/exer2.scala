

def tail[A](lst: List[A]):List[A]={
	lst match {
		case Nil => Nil
		case Cons(head,tail) => tail
		
	}
	
}
