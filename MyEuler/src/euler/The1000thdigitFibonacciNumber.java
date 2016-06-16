package euler;

import com.ibm.icu.math.BigDecimal;


/**
 * 1000-digit Fibonacci number
Problem 25
The Fibonacci sequence is defined by the recurrence relation:

Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
Hence the first 12 terms will be:

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
The 12th term, F12, is the first term to contain three digits.

What is the index of the first term in the Fibonacci sequence to contain 1000 digits?

To enum the sequence, we found that the number to add one digit by 5 steps or 4 steps from f2, 
and it's recycle always by 5 5 5 4.
So by the law , we can count the first 1000-digit number's index.

 * @author WILLJOE
 *
 */
public class The1000thdigitFibonacciNumber {
	
	public int getIndexFirstDigits(int digit){
		if(digit == 1) return 1;
		int count4 = (digit - 1) / 4;
		int add4 = (digit-1) % 4;
		int index = 2;
		index += count4 * 19;
		index += add4 * 5;
		return index;
	}
	
	
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		The1000thdigitFibonacciNumber number = new The1000thdigitFibonacciNumber();
		System.out.println(number.getIndexFirstDigits(1000));
		long end = System.currentTimeMillis();
		System.out.println("used:"+(end - start)+"ms");
		
		
		BigDecimal fpre = BigDecimal.ONE;
		BigDecimal fnex = BigDecimal.ONE;
		BigDecimal ftmp = null;
		int len = 1;
		int curindex = 2;
		System.out.println("index 1, is 1, length is 1");
		for(int i=3;i<5000;i++){
			ftmp = fpre.add(fnex);
			fpre = fnex;
			fnex = ftmp;
			if(ftmp.toString().length() != len){
				len = ftmp.toString().length();
				System.out.println("index :"+i+", \tlength :"+len+" \tsteps: "+ (i - curindex));
				curindex = i;
			}
		}
		
	}
	
}
