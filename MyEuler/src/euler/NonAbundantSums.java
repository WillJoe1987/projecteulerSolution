package euler;


/**
 * Non-abundant sums
Problem 23
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. 
By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. 
However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 * @author WILLJOE
 *
 */
public class NonAbundantSums {
	
	/**
	 * To adjust weather a number is abundant or not.
	 * @param number
	 * @return
	 */
	public boolean isAbundant(int number){
		int actorsum = 1;
		long sqrt = Math.round(Math.sqrt(new Float(number)));
		for(int i=2;i<=sqrt;i++){
			if(number % i == 0){
				if(number / i == i){
					actorsum += i;
				}else{
					actorsum += i + number / i;
				}
			}
		}
		return actorsum > number;
	}
	
	/**
	 * To adjust if a number is the sum of two abundant number.
	 * We know the smallest abundant number is 12.
	 * @param number
	 * @return
	 */
	public boolean aubundantSummable(int number){
		int half = number >>> 1;
		for(int i=12;i<=half;i++){
			if(isAbundant(i) && isAbundant(number - i)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * We know the upper limit is 28123. 
	 * @return
	 */
	public int getAllNonAbundantSums(){
		int result = 0;
		for( int i=1;i<=28123;i++){
			if(!aubundantSummable(i)){
				result += i;
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		NonAbundantSums nas = new NonAbundantSums();
		System.out.println("result:"+nas.getAllNonAbundantSums());
		long end = System.currentTimeMillis();
		System.out.println("used:"+(end - start));
	}
	
}
