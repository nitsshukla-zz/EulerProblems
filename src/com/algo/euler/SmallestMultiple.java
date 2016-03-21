package com.algo.euler;

import com.maths.util.Factorization;

public class SmallestMultiple {
	public static void main(String[] args) {
		//What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
		//Answer- this is like getting lcm of all these numbers
		int lcm=1;
		for(int i=1;i<=20;i++){
			lcm = getLCM(lcm,i);
		}
		System.out.println(lcm);
	}

	private static int getLCM(int lcm, int i) {
		return lcm*i/Factorization.gcd(lcm, i);
	}
}
