package euler;

/**
 * 10001st prime
Problem 7
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
 * @author WILLJOE
 *
 */
public class PrimeNumber10001th {
	
	public boolean isPrime(long num){
		if(num>1){
			/**
			 * 这里num可以做一次开方再循环，降低逻辑复杂度。
			 * 不开方的运行结果：
			 * 	104743
			 *	2249
			 * 开方后的运行结果：
			 * 
			 */
			long sqrt = (long) Math.floor(Math.sqrt(num)+1);
			for(long i=2;i<sqrt;i++){
				if(num % i == 0) return false;
				else continue;
			}
			return true;
		}
		return false;
	}
	
	public boolean isPrime(int num){
		if(num>1){
			/**
			 * 这里num可以做一次开方再循环，降低逻辑复杂度。
			 * 不开方的运行结果：
			 * 	104743
			 *	2249
			 * 开方后的运行结果：
			 * 
			 */
			int sqrt = (int) Math.floor(Math.sqrt(num)+1);
			for(int i=2;i<sqrt;i++){
				if(num % i == 0) return false;
				else continue;
			}
			return true;
		}
		return false;
	}
	
	public int getOrderPrime(int order){
		int count = 0;
		int number = 2;
		while(count<order){
			if(this.isPrime(number))
				count++;
			number++;
		}
		number -- ;
		return number;
	}
	
	
	public long getOrderPrime(long order){
		int count = 0;
		long number = 2;
		while(count<order){
			if(this.isPrime(number))
				count++;
			number++;
		}
		number -- ;
		return number;
	}
	
	public static void main(String[] args) {
		
		PrimeNumber10001th pn1 = new PrimeNumber10001th();
		long start = System.currentTimeMillis();
		System.out.println(pn1.getOrderPrime(10001));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		//System.out.println(pn1.isPrime(871));
	}
	
}
