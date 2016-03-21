package com.maths.numericalmethod;

public class Trapezoidal {
	public static void main(String[] args) {
		/*F f = new F();
		double steps = 8, lower = 1, upper = 5;
		double den = (double)(upper - lower)/steps;
		System.out.println(simpleTrapez(f,den,lower,upper));*/
		F1 f = new F1();double steps = 6, lower = 0, upper = 6;
		double den = (double)(upper - lower)/steps;
		System.out.println(simpson38(f,den,lower,upper));
	}
	private static double simpson38(Function f, double den, double lower, double upper) {
		double ans=0;int count=0;
		for (double i = lower + den; i < upper; i = i + den){
			ans += (count%3==2?2:3) * f.function(i);
			System.out.println((count++)+"\t"+i+"\t"+ans);
		}
		ans += f.function(lower) + f.function(upper);
		return (double)(den *3* ans / 8);
	}
	
	private static double simpson13(Function f, double den, double lower, double upper) {
		double ans=0;int count=0;
		for (double i = lower + den; i < upper; i = i + den){
			ans += (count%2==0?4:2) * f.function(i);
			System.out.println((count++)+"\t"+i+"\t"+ans);
		}
		ans += f.function(lower) + f.function(upper);
		return (double)(den * ans / 3);
	}
	
	private static double simpleTrapez(Function f, double den, double lower, double upper) {
		double ans=0;
		for (double i = lower + den; i < upper; i = i + den){
			ans += 2 * f.function(i);
			System.out.println(ans);
		}
		ans += f.function(lower) + f.function(upper);
		return (double)(den * ans / 2);
	}
	
}


class F1 implements Function {

	@Override
	public double function(double... args) {
		double x = args[0];
		return (1/(1 + Math.pow(x ,2)));
	}

	@Override
	public double functionD(double... args) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double functionDD(double... args) {
		// TODO Auto-generated method stub
		return 0;
	}

}


class F implements Function {

	@Override
	public double function(double... args) {
		double x = args[0];
		return Math.sqrt(1 + x * x);
	}

	@Override
	public double functionD(double... args) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double functionDD(double... args) {
		// TODO Auto-generated method stub
		return 0;
	}

}

interface Function {
	public double function(double... args);

	public double functionD(double... args);

	public double functionDD(double... args);
}