package euler;

/**
 * 
Digit factorials
Problem 34
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.

resolve:
	1、9!*7 is a 7 digits number. So, the largest number is 7 digits below 9!, 2540160.

and if there r only 2 number is this type. so 
 */
public class DigitFactorials {

	FactorialDigitSum fds = new FactorialDigitSum();
	
	int sum = 0;
	
	public void buildSum(){
		for(int i=10;i<2540160;i++){
			checkNumber(i);
		}
	}
	
	public void checkNumber(int n){
		String nStr = n + "";
		int curSum = 0;
		for(int i = 0; i< nStr.length();i++){
			curSum += fds.factorial(nStr.charAt(i) - 48).intValue();
			if(curSum > n) return;
		}
		if(n == curSum){
			System.out.println(n);
			sum += n;
		}
	}
	
	/**
	 * 145
40585
result is: 40730; used 943ms
WTF:::
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		DigitFactorials df = new DigitFactorials();
		df.buildSum();
		long end = System.currentTimeMillis();
		System.out.println("result is: "+ df.sum+"; used "+(end - start)+"ms");
	}
	
}
