package com.oracle.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class FunctionalInterface {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(){};arr.add(3123);arr.add(12);arr.add(78);arr.add(53);arr.add(76);
		arr.add(42);arr.add(17);arr.add(188);arr.add(231);
		eval(arr,(r)->r%2==0);
		eval(arr,(r)->r%2==1);
	}
	public static void eval(ArrayList<Integer> arr, Predicate<Integer> pre){
		for(Integer r:arr){
			if(pre.test(r))
				System.out.print(r+" ");
		}
	System.out.println();
	}
}
