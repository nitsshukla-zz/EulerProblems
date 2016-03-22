package com.algo.euler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.maths.util.Factorization;

public class HighestDivisibleTriangularNumber {

	public static void main(String[] args) {
		// What is the value of the first triangle number to have over five hundred divisors?
		int i=1;
		while(true){
			int next = getNextTriangularNumber(i++);
			List<Integer> factors = Factorization.primeFactors(next);
			Map<Integer,Integer> map = getMap(factors);
			int ans = 1;
			for(int i1:map.values())
				ans*=i1+1;
			
			if(ans>500){
				System.out.println(next);
				break;
			}
			
		}
	
	}

	private static Map<Integer, Integer> getMap(List<Integer> factors) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i :factors){
			if(map.containsKey(i))
				map.put(i, map.get(i)+1);
			else
				map.put(i,1);
		}
		return map;
	}

	private static int getNextTriangularNumber(int i) {
		return i*(i+1)/2;
	}

}
