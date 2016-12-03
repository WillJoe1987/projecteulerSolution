package euler;

import java.util.ArrayList;
import java.util.List;

/**
 * Circular primes
Problem 35
The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?
 *
 *resolve:
 *	1、circular prime's each digit is even.So, whe all the number is is compared by {1,3,5,7,9} by from 1 to 999999;
 *	you need to check all ? primes ? 
 * 	or we find all the primes and check check the circular?
 *	from one digit to six digits?
 *
 *	get number is o(5) + o(5^2) + o (5^3) + o(5^4) + o(5^5) + o(5^6)
 *
 */
public class CircularPrimes {
	
	PrimeNumber10001th pn = new PrimeNumber10001th();

	List<Integer> total = new ArrayList<Integer>();
	
	int[] base_int = {1,3,5,7,9};
	
	private boolean isPrime(int n){
		return pn.isPrime(n);
	}
	
	private void checkAndBuildCircular(int[] digits){
		int len = digits.length;
		int fetching = 0;
		List<Integer> prime = new ArrayList<Integer>();	
		while(fetching<len){
			int number = 0;
			for(int i=0;i<len; i++){
				if(fetching+i<len){
					number += digits[fetching+i] * Math.pow(10, i);
				}else{
					number += digits[fetching+i-len] * Math.pow(10, i);
				}
			}
			fetching ++;
			if(!isPrime(number)) return;
			else{
				if(!prime.contains(number))
					prime.add(number);
				continue;
			}
		}
		for(Integer p : prime){
			if(!total.contains(p)){
				total.add(p);
			}
		}
	}
	
	private void checkAndBuildCircularByDigitNum(int[] choosed, int n){
		if(null!=choosed && choosed.length == n){
			checkAndBuildCircular(choosed);
			return;
		}
		for(int i=0;i<base_int.length;i++){
			if(null == choosed){
				int [] build = {base_int[i]};
				checkAndBuildCircularByDigitNum(build, n);
			}else{
				int choosedLen = choosed.length;
				int [] con = new int[choosedLen + 1];
				for(int x=0;x<choosedLen;x++){
					con[x] = choosed[x];
				}
				con[choosedLen] = base_int[i];
				checkAndBuildCircularByDigitNum(con, n);
			}
		}
	}
	
	public void buildAll(){
		
		for(int i=1;i<=6;i++){
			checkAndBuildCircularByDigitNum(null, i);
		}
	}
	
	/**
	 * result is 55; used 63ms
	 * @param args
	 */
	public static void main(String[] args) {
		CircularPrimes cp = new CircularPrimes();
		long start = System.currentTimeMillis();
		cp.buildAll();
		long end = System.currentTimeMillis();
		System.out.println("result is "+(cp.total.size()+1)+"; used "+(end - start)+"ms");
	}
}
