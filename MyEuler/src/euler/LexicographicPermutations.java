package euler;

import org.apache.commons.lang.ArrayUtils;


/**
 * Lexicographic permutations
Problem 24
A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 * @author WILLJOE
 *
 */
public class LexicographicPermutations {
	
	char[] actorChars = {'0','1','2','3','4','5','6','7','8','9'};
	
	public int factorial(int number){
		int result = 1;
		int fetch = 1;
		while(fetch<=number){
			result *= fetch;
			fetch ++;
		}
		return result;
	}
	
	public String getOrderedPermutation(int upperIndex){
		if(upperIndex > factorial(actorChars.length)){
			return null;
		}
		String tmpChars = "";
		int total = upperIndex;
		while(total>0 && actorChars.length>1){
			int fl = factorial(actorChars.length - 1);
			int localIndex = total/fl;
			total = total % fl;
			tmpChars += actorChars[localIndex];
			actorChars = ArrayUtils.remove(actorChars, localIndex);
		}
		if(actorChars.length>0){
			int i = 0;
			while(i<actorChars.length){
				tmpChars += actorChars[i];
				i++;
			}
		}
		return tmpChars;
	}
	
	
	public static void main(String[] args) {
		LexicographicPermutations lp = new LexicographicPermutations();
		long start = System.currentTimeMillis();
		System.out.println("result:"+lp.getOrderedPermutation(999999));
		long end = System.currentTimeMillis();
		System.out.println("used:"+(end - start)+"ms");
	}
	
}
