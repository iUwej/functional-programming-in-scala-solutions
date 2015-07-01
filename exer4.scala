
/**
Currying - Convert a  function of N arguments into a function
of one argument  that returns another function as its results

**/

def curry[A,B,C](f: (A,B) => C): A => (B => C)={

	(a: A)=> (b: B)=>f(a,b)
}

/***
A concrete implementation of the same would be some function like
*/

val f= curry[Int,Int,Int]((a,b)=> a+ b)

//here we can do something like
f(6)(9)
