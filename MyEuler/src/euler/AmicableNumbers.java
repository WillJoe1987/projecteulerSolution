package euler;

/**
 * Amicable numbers
Problem 21
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
 * @author WILLJOE
 *
 */
public class AmicableNumbers {
	
	public int getActorSum(int n){
		int result = 1;
		int start = 2;
		double sqrt = Math.sqrt(Double.valueOf(n+""));
		while(start <= sqrt){
			if( n % start == 0 && n/start >= start){
				if(n/start == start){
					result += start;
				}else{
					result += start;
					result += n/start;
				}
			}
			start ++;
		}
		return result;
	}
	
	public int fetchBelow(int n){
		int result = 0;
		int i = 2;
		while( i <= n ){
			Integer sum = this.getActorSum(i);
			if(sum != i && sum <= n && this.getActorSum(sum) == i){
				result += i;
			}
			i++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		long start  = System.currentTimeMillis();
		AmicableNumbers an = new AmicableNumbers();
		System.out.println(an.fetchBelow(10000));
		long end = System.currentTimeMillis();
		System.out.println("used : "+(end - start));
		
	}
}
