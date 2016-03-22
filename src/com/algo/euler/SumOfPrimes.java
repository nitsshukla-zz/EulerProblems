package com.algo.euler;

import java.util.List;

import com.maths.util.Factorization;

public class SumOfPrimes {
	public static void main(String[] args) {
		//Find the sum of all the primes below two million
		final int BELOW = 2000000;
		List<Integer> primes = Factorization.getAllPrimes(BELOW);
		long ans=0;
		for(int i:primes)
			ans+=i;
		System.out.println(ans);
	}
}
