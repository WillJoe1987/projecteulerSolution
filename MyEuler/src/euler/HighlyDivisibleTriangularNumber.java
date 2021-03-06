package euler;

import java.util.HashMap;
import java.util.Map;

/**
 * Highly divisible triangular number
Problem 12
The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

Let us list the factors of the first seven triangle numbers:

 1: 1
 3: 1,3
 6: 1,2,3,6
10: 1,2,5,10
15: 1,3,5,15
21: 1,3,7,21
28: 1,2,4,7,14,28
We can see that 28 is the first triangle number to have over five divisors.

What is the value of the first triangle number to have over five hundred divisors?
 * @author WILLJOE
 *
 */
public class HighlyDivisibleTriangularNumber {
	
	/**
	 * To count the actors of number.
	 * Use sqrt, to get log(number).
	 * @param number
	 * @return
	 */
	public int getActorCount(int number){
		int count = 0;
		long sqrt = Math.round(Math.sqrt(new Float(number)));
		for(int i=1;i<=sqrt;i++){
			if(number % i == 0){
				if(number / i == i){
					count += 1;
				}else{
					count += 2;
				}
			}
		}
		return count;
	}
	
	/**
	 * by prime actors count.
	 * We begin by writing the number as a product of prime factors: n = p^a*q^b*r^c...
	 * then the number of divisors, d(n) = (a+1)(b+1)(c+1)...
	 * It's proved by Math. So, this can be another solution.
	 * @param number
	 * @return
	 */
	public int getActorCountByPrime(int number){
		int i=1;
		Map<Integer, Integer> primeActors = new HashMap<Integer, Integer>();
		PrimeNumber10001th pn = new PrimeNumber10001th();
		Integer prime = 0;
		while(!pn.isPrime(number)){
			prime = MaxPrime.getMaxPrimes(number);
			number = number / prime;
			if(primeActors.containsKey(prime)){
				primeActors.put(prime, primeActors.get(prime)+1);
			}else{
				primeActors.put(prime, 1);
			}
		}
		
		if(primeActors.containsKey(number)){
			primeActors.put(number, primeActors.get(number)+1);
		}else{
			primeActors.put(number, 1);
		}
		
		for(Integer key : primeActors.keySet()){
			i *= (primeActors.get(key) + 1);
		}
		return i;
	}
	
	private int number = 0;
	private int order = 0;
	public int getNext(){
		this.order ++;
		this.number += this.order;
		return this.number;
	}
	
	public int getDivisibleNumber(int number){
		int i=1;
		int size = 0;
		this.getNext();
		while( size < number ) {
			i = this.getNext();
			
			
			size = this.getActorCountByPrime(i);
		}
		return i;
	}
	
	/**
	 * result
	 * 76576500
     * 347
	 * @param args
	 */
	public static void main(String[] args) {
		HighlyDivisibleTriangularNumber h = new HighlyDivisibleTriangularNumber(); 
		long start = System.currentTimeMillis();
		System.out.println(h.getDivisibleNumber(2000));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
