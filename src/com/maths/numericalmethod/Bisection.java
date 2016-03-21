package com.maths.numericalmethod;

public class Bisection {
	public static void main(String[] args) throws Exception {
		System.out.println(getBisection(-2,-1));
	}
	public static double getBisection(double x2, double x1) throws Exception {
		double temp2 = function(x2);
		double temp1 = function(x1),x0=0,temp0;
		boolean b01,b02;int i=0;
		while(!(Math.abs(function(x0))<0.00001)){i++; 
			x0=RegulaFalsi.getMid(x2,x1);
			temp0=function(x0);
			System.out.println(temp0 +"\t" + temp1 + "\t" + temp2);
			if(temp0*temp1<0)
				b01=true;
			else
				b01=false;
			if (temp0*temp2<0)
				b02=true;
			else b02=false;
			if(b01 && !b02){
				x2=x0;
			}else if(b02 && !b01){
				x1=x0;
			}else if(b01&&b02){
				throw new Exception("Multi root exception");
			}else{
				throw new Exception("No root exception");				
			}
		}
		System.out.printf("Took %d iterations",i);
		return x0;
	}
	public static double getMid(double x2, double x1) {
		return (x2+x1)/2;
	}
	public static double function(double x){
		System.out.println("returning "+(x*x-4*x-10));
		return (double)x*x-4*x-10;
	}
}
