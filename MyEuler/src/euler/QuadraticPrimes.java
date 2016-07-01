package euler;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 27
Euler discovered the remarkable quadratic formula:

n² + n + 41

It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.

The incredible formula  n² − 79n + 1601 was discovered, which produces 80 primes for the consecutive values n = 0 to 79. The product of the coefficients, −79 and 1601, is −126479.

Considering quadratics of the form:

n² + an + b, where |a| < 1000 and |b| < 1000

where |n| is the modulus/absolute value of n
e.g. |11| = 11 and |−4| = 4
Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.
 * @author WILLJOE
 *
 */
/**
 * Now let me see, the primes is always upon 0. We consider from 0 on, so b must larger than 0, and b is a prime. So, b can be a prime smaller than 1000.
 * And when n = 1; the value is 1+a+b, and b is prime, so 1+b is even, and the a must be a odd number.
 * if a below 0, and the value must upon 0, when n = 1, |a| < 1+b. so a > -1 - b && a <= 1000, and a is odd number. 
 * @author WILLJOE
 *
 */
public class QuadraticPrimes {

	int below = 1000;
	List<Integer> bDomain = new ArrayList<Integer>();
	PrimeNumber10001th pn = new PrimeNumber10001th();
	
	public QuadraticPrimes(){
		for(int i = 1; i<1000;i++){
			if(pn.isPrime(i)){
				bDomain.add(i);
			}
		}
	}
	
	public QuadraticPrimes(int top){
		for(int i = 1; i<top+1;i++){
			if(pn.isPrime(i)){
				bDomain.add(i);
			}
		}
	}
	
	public boolean isEven(int i){
		return i%2==0;
	}
	
	public int findConsecutivePrime(int a, int b){
		for(int i=0;;i++){
			int value = i * i + a * i + b;
			if(!pn.isPrime(value)) return i;
		}
	}
	
	public int[] findMaxA(int b){
		int[] valuePair = {0, b, 0};
		for(int i = (-2-b);i<1000;i = i + 2){
			int tmpCon = findConsecutivePrime(i, b);
			if(tmpCon>=valuePair[2]){
				valuePair[0] = i;
				valuePair[2] = tmpCon;
			}
		}
		return valuePair;
	}
	
	public int[] toFindAllMax(){
		int[] value = {0, 0, 0};
		for(int b : bDomain){
			int[] tValue = findMaxA(b);
			if(tValue[2]>=value[2]){
				value = tValue;
			}
		}
		return value;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		QuadraticPrimes qp = new QuadraticPrimes();
		int[] re = qp.toFindAllMax();
		System.out.println(re[0]+","+re[1]+","+re[2]);
		System.out.println("result is: "+re[0]*re[1]);
		long end = System.currentTimeMillis();
		System.out.println("used : "+(end - start)+"ms");
	}
	
}
