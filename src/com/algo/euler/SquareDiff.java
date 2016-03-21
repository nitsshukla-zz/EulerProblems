package com.algo.euler;

public class SquareDiff {
	public static void main(String[] args) {
		//Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
		//(a+b+c)2-(a2+b2+c2)={(a+b)2-(a2+b2) + c2-2(a+b)c}
		System.out.println(getSquareDiff(100));
	}

	private static int getSquareDiff(int num) {
		int ans=0,sum=1;
		for(int i=2;i<=num;i++){
			ans+=2*sum*i;
			sum+=i;
		}
		return ans;
	}
}
