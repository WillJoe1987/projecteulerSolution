package euler;

/**
 * Largest palindrome product


Problem 4
 

A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 
Find the largest palindrome made from the product of two 3-digit numbers.

 * @author WILLJOE
 *
 */
public class MaxPalineromic {
	
	public static int getPalindromic(){
		
		int result = 0;
		
		for(int x = 999; x>=900; x--){
			for( int y=999 ; y>=900; y--){
				int tmpresult = x * y;
				if(ifPalindromic(tmpresult)){
					if(tmpresult > result) result = tmpresult;
				}
			}
		}
		System.out.println(result);
		return result;
	}
	
	public static boolean ifPalindromic(int num){
		String numStr = num + "";
		StringBuffer sb = new StringBuffer(numStr);
		String sbp = sb.reverse().toString();
		if(numStr.equals(sbp)) return true;
		return false;
	}
	
	public static void main(String[] args) {
		getPalindromic();
	}
	
}
