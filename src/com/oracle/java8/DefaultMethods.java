package com.oracle.java8;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DefaultMethods {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Car c = new Car();
		//c.s();
		Method m = java.lang.invoke.MethodHandle.class.getMethod("operate", Lambda.class);
		System.out.println(m.invoke(1, 2));
	}
}

interface Vehicle{
	default void print(){
		System.out.println(32131);
	}
}

interface FourWheeler{
	default void print(){
		System.out.println(23123);
	}
}

class Car implements Vehicle, FourWheeler{

	@Override
	public void print() {
	}
	public void s(){
		Vehicle.super.print();
	}
}