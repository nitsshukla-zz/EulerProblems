package com.maths.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.omg.Messaging.SyncScopeHelper;

public class Factorization {
	public static List<Integer> primeFactors(int numbers) {
	    int n = numbers;
	    List<Integer> factors = new ArrayList<Integer>();
	    for (int i = 2; i <= n / i; i++) {
	      while (n % i == 0) {
	        factors.add(i);
	        n /= i;
	      }
	    }
	    if (n > 1) {
	      factors.add(n);
	    }
	    return factors;
	  }
	public static int gcd(int x,int y){
		int a = x,  b = y,t;
		 
		  while (b != 0) {
		    t = b;
		    b = a % b;
		    a = t;
		  }
		 
		 return a;
	}
	public static List<Integer> getAllPrimes(int upper){
		int sq = (int)Math.sqrt(upper);
		boolean[] bool = new boolean[upper+1];
		Arrays.fill(bool, true);
		bool[0]=false;bool[1]=false;
		for(int i=2;i<sq+1;i++){
			if(isPrime(i)){
				for(int i1=2*i;i1<=upper;i1+=i)
					bool[i1]=false;
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=upper;i++){
			if(bool[i])
				list.add(i);
		}
		return list;
	}
	private static boolean isPrime(int num) {
		for(int i=2;i<num;i++)
			if(num%i==0)
				return false;
		return true;
	}
	public static void main(String[] args) {
		//Test
		//System.out.println(gcd(12,42));
		//System.out.println();
		System.out.println(getAllPrimes(200000).get(10000));
	}
}
