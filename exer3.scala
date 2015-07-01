 /**
Implement  partial1 and write down a concrete usage of it
 */


 def partial1[A,B,C](a: A, f: (A,B) => C): B => C={

 	(b: B) => f(a,b)

 }

 /***
A concrete implementation would be a function defined on arithmetic operations of the integer such as
 **/

 val f= partial1[Int,Int,Int](1,(a,b)=> a + b)
 //call the function
 f(4)