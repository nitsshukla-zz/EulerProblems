package com.maths.util;

import java.util.ArrayList;
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
	public static void main(String[] args) {
		//Test
		System.out.println(gcd(12,42));
	}
}
