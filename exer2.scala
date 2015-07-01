
def isSorted[A](as: Array[A],ls:(A,A) => Boolean): Boolean={

		def check(index: Int,nextIndex: Int): Boolean={
			if(nextIndex==as.length)true
			else if(!ls(as(index),as(nextIndex))) false
			else check(nextIndex,nextIndex+1)
		}

		check(0,1)
}