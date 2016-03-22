package com.algo.euler;

public class AdjacentDigitProduct {
	static final int DIGITS = 13;
	public static void main(String[] args) {
		//Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?	
		//7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450
		String num = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		int temp=1, max=-1;
		for(int i=0;i<num.length();i++){
			if(i==613){
					System.out.println();
			}
			int num1 = Integer.valueOf(num.charAt(i)+"");
			//System.out.println(num1);
			temp*=num1;
			if(i>=DIGITS && num.charAt(i-DIGITS) != '0')
				temp/=Integer.valueOf(""+num.charAt(i-DIGITS));
			else if(i>=DIGITS) {
				temp=1;
				for(int i1=0;i1<DIGITS;i1++){
					temp*=Integer.valueOf(num.charAt(i-i1)+"");
				}
			}
			if(temp>max){
				max=temp;
				System.out.println(num.substring(0,i));
				//System.out.println(max);
			}
			//System.out.println(temp);
		}
		System.out.println(max);
	}

}