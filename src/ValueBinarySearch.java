
public class ValueBinarySearch {
	public static void main(String[] args) {
		System.out.println(getValue(35,0));
	}
	private static double getValue(double approximateValue, int time) {
		if(time>30) return approximateValue;   //Recursing 30 iterations
		return getValue(approximateValue - ((double) func(approximateValue)/funcD(approximateValue)),time+1);
	}
	/**
	 * 
	 * @param x
	 * @return Function value
	 */
	public static Double func(double a){
		return a - 10* Math.log(a);
	}
	/**
	 * 
	 * @param x
	 * @return differentiation value of func at x= a
	 */
	public static Double funcD(double a){
		return (double)(func(a)-func(a-0.00001))/0.00001;
	}

}
