package com.maths.util;

public class Lexical {
	public static boolean isPalindrom(Object number){
		String num = number.toString();
		if(num.length()<2)
			return true;
		if(num.charAt(0)!=num.charAt(num.length()-1))
			return false;
		return isPalindrom(num.substring(1, num.length()-1));
	}
	public static void main(String[] args) {
		//Tests
		System.out.println(isPalindrom("121221"));
	}
}
