package euler;


/**
 * Longest Collatz sequence
Problem 14
The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
 * @author WILLJOE
 *
 */
public class LongestCollatzSequence {
	
	Long upSize = 0l;
	
	public LongestCollatzSequence(long upsize){
		upSize = upsize;
	}
	
	int currentLongStep = 0;
	long currentNumber = 0;
	
	public int getCollatzStepCount(long startNumber){
		
		int stepCount = 0;
		Long stepedNumber = new Long(startNumber);
		while(stepedNumber != 1l){
			stepCount ++ ;
			stepedNumber = this.isEven(stepedNumber) ? stepedNumber/2 : 3 * stepedNumber + 1;
		}
		return stepCount;
	}
	
	public boolean isEven(long number){
		return (number&1) == 0;
	}
	
	public void loopDownByStart(){
		Long upside = new Long(this.upSize);
		while(upside > this.upSize/2){
			int step = this.getCollatzStepCount(upside);
			if(step>currentLongStep){
				currentLongStep = step;
				currentNumber = upside;
			}
			upside --;
		}
	}
	
	public static void main(String[] args) {
		long upside = 1000000;
		LongestCollatzSequence sequence = new LongestCollatzSequence(upside);		
		long start = System.currentTimeMillis();
		sequence.loopDownByStart();
		long end = System.currentTimeMillis();
		System.out.println("step is :"+sequence.currentLongStep);
		System.out.println("number is :" + sequence.currentNumber);
		System.out.println("used : "+(end - start));
	}
}
