package chapter4

object Stats{

def mean(xs: Seq[Double]): Option[Double]={
	if(xs.isEmpty) None
	else Some(xs.sum/xs.length)
}

def variance(xs: Seq[Double]): Option[Double]={
	mean(xs).flatMap{m=>
		mean(xs.map(d=> math.pow(d - m,2)))
	}
}

}