package euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
Pandigital multiples
Take the number 192 and multiply it by each of 1, 2, and 3:

192 × 1 = 192
192 × 2 = 384
192 × 3 = 576
By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)
The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?
 *
 *	resolve:
 *		1、the largest 9-digit pandigital number is 987654321, and smallest is 123456789;
 *		2、n > 1 and n < 9 of course.
 *		3、checking P-M we need to know:
 *			first number * 2 = second number;
 *			second number * 1.5 = third number;
 *			let's get a function of n , and every digits.
 *			n= 1; digit is {9};
 *			n= 2; digits are {4,5};
 *			n= 3; digits are {3,3,3};
 *			n= 4; digits are {2,2,2,3};
 *			n= 5; digits are {1,2,2,2,2};
 *			n= 6; digits are {1,1,1,2,2,2};
 *			n= 7; digits are {1,1,1,1,1,2,2};
 *			n= 8; digits are {1,1,1,1,1,1,1,2};
 *			n= 9; digits are {1,1,1,1,1,1,1,1,1};
 *			ALL? 
 *
 */
public class PandigitalMultiples {

	int[][] digitis = {
			{9},
			{4,5},
			{3,3,3},
			{2,2,2,3},
			{1,2,2,2,2},
			{1,1,1,2,2,2},
			{1,1,1,1,1,2,2},
			{1,1,1,1,1,1,1,2},
			{1,1,1,1,1,1,1,1,1}
	};
	
	String numbers = "987654321";
	
	List<Integer> pmNumbers = new ArrayList<Integer>();
	int largetestPm = 0;
	
	public boolean checkPandigitalMultiples(int x){
		for(int n=1; n < digitis.length; n ++){
			int[] theDigits = digitis[n];
			if(checkPMByDigits(x, theDigits)) {
				System.out.println("pm adding :"+x+ " ; the digits is "+Arrays.toString(theDigits));
				return true;
			}
		}
		return false;
	}
	
	public boolean checkPMByDigits(int x, int[] digits){
		int [] div = new int[digits.length];
		int leftDigitCount = 9;
		int leftX = x;
		for(int i=0;i<digits.length;i++){
			div[i] = leftX /(int) Math.pow(10, leftDigitCount-digits[i]);
			leftDigitCount = leftDigitCount-digits[i];
			leftX = leftX - div[i] * (int)Math.pow(10, leftDigitCount);
			if(i>0){
				if(div[i]% div[0] != 0 || (int)(div[i] / div[0]) != (i+1)){
					return false;
				}
			}
		}
		return true;
	}
	
	public void buildPandigitNumber(String pmNumber){
		if(pmNumber.length() == 9){
			int pm = Integer.valueOf(pmNumber);
			if(checkPandigitalMultiples(pm)){
				pmNumbers.add(pm);
				if(pm > largetestPm){
					largetestPm = pm;
				}
			}
		}else{
			for(int i=0;i< 9;i ++){
				//if(largetestPm > 0 ) return;
				char theChar = numbers.charAt(i);
				if(pmNumber.indexOf(theChar)>=0) continue;
				else{
					buildPandigitNumber(pmNumber + theChar);
				}
			}
		}
	}
	
	public void buildAll(){
		buildPandigitNumber("");
	}
	
	
	/**
	 * pm adding :932718654 ; the digits is [4, 5]
result is 932718654; used 123ms.
	 * @param args
	 */
	/**
	 * FOR find all the numbers.
	 * 
	 * pm adding :932718654 ; the digits is [4, 5]
pm adding :927318546 ; the digits is [4, 5]
pm adding :926718534 ; the digits is [4, 5]
pm adding :918273645 ; the digits is [1, 2, 2, 2, 2]
pm adding :793215864 ; the digits is [4, 5]
pm adding :792315846 ; the digits is [4, 5]
pm adding :769215384 ; the digits is [4, 5]
pm adding :732914658 ; the digits is [4, 5]
pm adding :729314586 ; the digits is [4, 5]
pm adding :726914538 ; the digits is [4, 5]
pm adding :692713854 ; the digits is [4, 5]
pm adding :679213584 ; the digits is [4, 5]
pm adding :672913458 ; the digits is [4, 5]
pm adding :327654981 ; the digits is [3, 3, 3]
pm adding :273546819 ; the digits is [3, 3, 3]
pm adding :219438657 ; the digits is [3, 3, 3]
pm adding :192384576 ; the digits is [3, 3, 3]
pm adding :123456789 ; the digits is [1, 1, 1, 1, 1, 1, 1, 1, 1]
result is 932718654; used 1267ms.
	 * @param args
	 */
	public static void main(String[] args) {
		PandigitalMultiples pm = new PandigitalMultiples();
		long start = System.currentTimeMillis();
		pm.buildAll();
		long end = System.currentTimeMillis();
		System.out.println("result is "+pm.largetestPm+"; used "+(end - start)+"ms.");
	}

}
