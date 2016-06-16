package euler;

/**
 * Summation of primes
Problem 10
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
 * @author WILLJOE
 *
 */
public class SummationOfPrime {
	
	public long summationBelowTop(long top){
		long result = 0;
		int counting = 2;
		PrimeNumber10001th pn = new PrimeNumber10001th();
		while(counting < top){
			if(pn.isPrime(counting)){
				result += counting;
			}
			counting ++;
		}
		return result;
	}
	
	/**
	 * result:
	 * 142913828922
	 * 932
	 * @param args
	 */
	public static void main(String[] args) {
		
		SummationOfPrime sop = new SummationOfPrime();
		long start = System.currentTimeMillis();
		System.out.println(sop.summationBelowTop(2000000));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
	
}
