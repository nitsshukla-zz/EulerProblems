package com.algo.euler;

public class SpecialPythogreanTriplet {
	public static void main(String[] args) {
		//There exists exactly one Pythagorean triplet for which a + b + c = 1000.				Find the product abc.
		for(int i=1;i<1000;i++)
			for(int i1=1;i1<1000;i1++){
				if(i*i1%1000==0 && Math.sqrt(i*i+i1*i1) == (int)Math.sqrt(i*i+i1*i1)){
					int c=(int)Math.sqrt(i*i+i1*i1);
					if(c==500-i*i1/1000)
						System.out.printf("%d\t%d\t%d\n",i,i1,(int)Math.sqrt(i*i+i1*i1));
				}
			}
	}
}
