
/**
implement the high-order function that composes two functions
f of g , written as  f o g
***/

def compose[A,B,C](f: B=> C, g: A =>B)={

	(a: A) => f(g(a))
}