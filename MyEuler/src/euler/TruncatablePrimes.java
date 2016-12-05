package euler;

/**
 * 
Truncatable primes
Problem 37
The number 3797 has an interesting property. Being prime itself, 
it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. 
Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 *
 *
 *resolve:
 *	1、the last digit must not be 2 or 5;
 *	2、if 2 or 5 is one of the digits, it must be the first.
 *	3、the middle digits must be chose from collection : {1,3,7,9}
 *	4、the first digit must be one of 2,3,5,7
 *  5、the last digit must be on of 3,7
 *	6、there are only eleven numbers.
 */
public class TruncatablePrimes {

	PrimeNumber10001th pn = new PrimeNumber10001th();
	int totalCount = 0;
	final int topCount = 11;
	int sum = 0;
	int[] leadingDigits = {2,3,5,7};
	int[] midDigits = {1,3,7,9};
	int[] lastDigits = {3,7};
	
	public boolean checkTruncatable(long n){
		int pow = 1;
		if(!pn.isPrime(n)) return false;
		while(n/(long)Math.pow(10, pow)>0){
			long x = n/(long)Math.pow(10, pow);
			if(!pn.isPrime(x)) return false;
			if(!pn.isPrime(n - x*(long)Math.pow(10, pow))) return false;
			pow ++;
		}
		return true;
	}
	
	public void buildTrancatable(){
		int order = 5;
		while(totalCount<=topCount){
			int prime = pn.getOrderPrime(order);
			System.out.println(prime);
			if(checkTruncatable(prime)){
				sum += prime;
				totalCount ++;
				System.out.println("the "+totalCount+"th number is "+prime+". The sum is "+sum+".");
			}
			order ++ ;
		}
	}
	
	public void buildTrancatable(long ns, int digitLevel){
		if(digitLevel < 2 || totalCount >= topCount) return;
		if((ns + "").length() >= digitLevel){
			//System.out.println(ns);
			if(checkTruncatable(ns)){
				sum += ns;
				totalCount ++;
				System.out.println("the "+totalCount+"th number is "+ns+". The sum is "+sum+".");
			}
			return;
		}else{
			int curLen = (ns+"").length();
			if(ns == 0 || curLen == 0){
				for(int i=0;i<leadingDigits.length;i++){
					int nextNs = leadingDigits[i];
					buildTrancatable(nextNs, digitLevel);
				}
			}else if(curLen == digitLevel -1){
				for(int i=0;i<lastDigits.length;i++){
					long nextNs = ns * 10 + lastDigits[i];
					buildTrancatable(nextNs, digitLevel);
				}
			}else{
				for(int i=0;i<midDigits.length;i++){
					long nextNs = ns * 10 + midDigits[i];
					buildTrancatable(nextNs, digitLevel);
				}
			}
		}
	}
	
	public void findAll(){
		int checkingDigitLevel = 2;
		while(totalCount<topCount){
			System.out.println("building digitLevel ["+checkingDigitLevel+"] start");
			buildTrancatable(0, checkingDigitLevel);
			System.out.println("building digitLevel ["+checkingDigitLevel+"] end");
			checkingDigitLevel ++;
		}
	}
	
	/**
	 * result is 748317 . used 31ms
	 * @param args
	 */
	public static void main(String[] args) {
		TruncatablePrimes tp = new TruncatablePrimes();
		long start = System.currentTimeMillis();
		tp.findAll();
		long  end = System.currentTimeMillis();
		System.out.println("result is "+tp.sum+" . used "+(end - start)+"ms");
		
	}
	
}
