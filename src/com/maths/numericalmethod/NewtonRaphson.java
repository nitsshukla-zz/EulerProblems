package com.maths.numericalmethod;

public class NewtonRaphson {
	public static void main(String[] args) {
		System.out.println(computeRoot(0));
	}

	private static double computeRoot(double x) {
		double fx = func(x);
		double fdx = funcd(x);
		while(!(Math.abs(fx)<0.0000001)){
			x = x - fx/fdx;
			System.out.println(x);
			fx=func(x);
			fdx=funcd(x);
		}
		return x;
	}

	private static double func(double x) {
		return Math.pow(x,4)-2*Math.pow(x,3)+2*x-1;
	}

	private static double funcd(double x) {
		return 4*Math.pow(x, 3)-6*x*x+2;
	}
	
}
