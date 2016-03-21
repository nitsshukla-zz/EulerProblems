package com.maths.numericalmethod;

public class RegulaFalsi extends Bisection {
	public static void main(String[] args) throws Exception {
		System.out.println(getBisection(-2, -1));
	}

	public static double getMid(double x2, double x1) {
		System.out.println("oye");
		return x2 * function(x2) - x1 * function(x1) / (x2 - x1);
	}
}
