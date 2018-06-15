package euler;

import java.util.Arrays;
/**
 * Pandigital prime
Problem 41 
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?
 * @author wlj
 *
 */
/**
 * No 9-digit pandigital, or 6-digit pandigital, or 3-digit pandigital, for they all can be devide by 3;
 * Last digit is no in 2,4,6,8.
 * So the Start number is a 8-digits number.
 * 
 * @author wlj
 */
public class PandigitalPrime {
	
	PrimeNumber10001th pn = new PrimeNumber10001th();
	
	public int getDigitNPrime(int n){
		int[] digits = new int[n];
		for(int i=0;i<n;i++){
			digits[i] = i+1;
		}
		return 0;
	}
	
	public int getNumber(int[] digits, int n){
		if(digits.length == 0){
			
			return n;
		}else {
			for(int i=0;i<digits.length; i++){
				int number = n * 10 + digits[i];
				int[] lastdigits = new int[digits.length -1];
				System.arraycopy(digits, 0, lastdigits, 0, i);
				System.arraycopy(digits, i+1, lastdigits, i, digits.length - i - 1);
				int nnumber = getNumber(lastdigits,number);
				if(pn.isPrime(nnumber)){
					return nnumber;
				}
			}
			return 0;
		}
	}
	
	public static void main(String[] args) {
		
		int[] digits = {1,2,3,4,5,6,7};
		int[] lastdigits = new int[6];
		int i=3;
		System.arraycopy(digits, 0, lastdigits, 0, i);
		System.arraycopy(digits, i+1, lastdigits, i, digits.length - i -1);
		System.out.println(Arrays.toString(lastdigits));
	}
	
}
