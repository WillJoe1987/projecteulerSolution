package euler;

import java.util.ArrayList;
import java.util.List;

/**
 * Sub-string divisibility
 * Problem 43 
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
 * d2d3d4=406 is divisible by 2
 * d3d4d5=063 is divisible by 3
 * d4d5d6=635 is divisible by 5
 * d5d6d7=357 is divisible by 7
 * d6d7d8=572 is divisible by 11
 * d7d8d9=728 is divisible by 13
 * d8d9d10=289 is divisible by 17
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 * @author wlj
 *	
 */
public class SubStringDivisibility {

	String digits = "0123456789";
	
	int[] actors = {2,3,5,7,11,13,17};
	
	int total = 1000/17;
	
	List<Long> results = new ArrayList<Long>();
	
	long result = 0;
	
	/**
	 * find from the last 3 digits;
	 */
	public void findAll(){
		for(int i=1;i<=total;i++){
			int product = i*17;
			String productStr = product<100?"0"+product:product+"";
			//not beautiful
			if(productStr.charAt(0) == productStr.charAt(1) ||
					productStr.charAt(1)==productStr.charAt(2) ||
					productStr.charAt(0)==productStr.charAt(2))
				continue;
			checkRightNumber(productStr, 6);
		}
	}
	
	/**
	 * check if going on
	 * @param productStr
	 * @param actor
	 */
	public void checkRightNumber(String productStr, int actor){
		if(0 == actor) {
			for(int i=0;i<digits.length();i++){
				if(productStr.indexOf(digits.charAt(i))<0){
					productStr = digits.charAt(i) + productStr;
				}
			}
			results.add(Long.valueOf(productStr));
			result += Long.valueOf(productStr);
			return;
		}
		for(int i=0;i<digits.length();i++){
			if(productStr.indexOf(digits.charAt(i))>=0)
				continue;
			else {
				String productNewStr = digits.charAt(i)+productStr;
				if(Integer.valueOf(productNewStr.substring(0, 3))%actors[actor-1]==0){
					checkRightNumber(productNewStr, actor-1);
				}else continue;
			}
		}
	}
	
	/**
	 * result is: 16695334890; 
	 * used 2ms
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		SubStringDivisibility ssd = new SubStringDivisibility();
		ssd.findAll();
		long end = System.currentTimeMillis();
		System.out.println("result is: "+ ssd.result+"; \nused "+(end - start)+"ms");
	}
	
	
}
