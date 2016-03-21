package com.algo.euler;

import java.util.Arrays;
import java.util.List;

import com.maths.util.Factorization;
import com.maths.util.Lexical;

public class PalindromeProduct {
	public static void main(String[] args) {
		//Find the largest palindrome made from the product of two 3-digit numbers.
		int next = 1000000;int[] prods;
		do{
			next = getNextPalindrome(next-1);
			prods = getProds(Factorization.primeFactors(next));
		}while(!(prods[0]<1000 && prods[0]>99 && prods[1]<1000 && prods[1]>99));
			System.out.println(Arrays.toString(prods));
	}



	private static int getNextPalindrome(int i) {
		do{	
			if(Lexical.isPalindrom(i))
				return i;
		}while(i-->=0);
		return 0;
	}



	private static int[] getProds(List<Integer> primeFactors) {
		int[] arr = new int[]{1,1};
		for(int i=primeFactors.size()-1;i>=0;i--){
			if(arr[0]>arr[1])
				arr[1]*=primeFactors.get(i);
			else arr[0]*=primeFactors.get(i);
		}
		return arr;
	}

}
