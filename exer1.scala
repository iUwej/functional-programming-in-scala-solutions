def fib(n: Int):Int={

		def eval(a :Int,b: Int,counter: Int):Int=
			if(counter==n)b
			else eval(b,a+b,counter+1)
		
		if(n==1)0
		else if(n==2)1
		else eval(0,1,2)
}