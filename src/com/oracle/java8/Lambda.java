package com.oracle.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lambda {
	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("Nitin");names.add("1itin1");names.add("Nitin2");names.add("Pitin3");names.add("Nitin4");names.add("Nitin5");
		Collections.sort(names, (s1,s2) -> s1.compareTo(s2));
		MathOperation add= (a,b)->a+b;
		MathOperation sub= (a,b)->a-b;
		System.out.println(operate(12, 32, add));
		System.out.println(operate(12, 32, sub));
		System.out.println(names);
	}
	public static int operate(int a, int b, MathOperation op){
		return op.operation(a, b);
	}
	public int operate(int a,int b){return a+b;}
}

interface MathOperation{
	int operation(int a, int b);
}