package com.algo.euler;

import java.util.List;

import com.maths.util.Factorization;

public class Prime10001 {

	public static void main(String[] args) {
		int PRIME_N = 10001,start=1;
		while(true){
			List<Integer> list = Factorization.getAllPrimes(start);
			if(list.size()>PRIME_N){
				System.out.println(list.get(PRIME_N));
				break;
			}
			start*=2;
		}
	}

}
