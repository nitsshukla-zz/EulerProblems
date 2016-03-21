package com.oracle.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class MethodReference {
	public static void main(String[] args) {

		List<String> names = new ArrayList<String>();
		names.add("Nitin");names.add("1itin1");names.add("Nitin2");names.add("Pitin3");names.add("Nitin4");names.add("Nitin5");
		
		Scanner scan = new Scanner(System.in);
		/*names.removeIf(new Predicate<String>() {

			@Override
			public boolean test(String t) {
				return t.startsWith("N");
			}
		});*/
		names.removeIf((s)->s.charAt(0)=='N');  //Lambda
		names.forEach(System.out::println);    //Method
	}
}
