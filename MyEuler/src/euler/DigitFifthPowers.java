package euler;

/**
 * Digit fifth powers
Problem 30
Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

1634 = 14 + 64 + 34 + 44
8208 = 84 + 24 + 04 + 84
9474 = 94 + 44 + 74 + 44
As 1 = 14 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 * @author WILLJOE
 *
 */
/**
 * 9^5 = 59049
 * *6 = 354294
 * *7 = 413343
 * so , top limit of the number is 354294
 * @author WILLJOE
 *
 */
public class DigitFifthPowers {

	public static void main(String[] args) {
		int res = 0;
		for(int i=2;i<=354294;i++){
			String t = i+"";
			int iValue = 0;
			for(int j = 0;j<t.length();j++){
				iValue += Math.pow(((int)t.charAt(j) - 48),5);
			}
			if(iValue == i){
				System.out.println(i);
				res += i;
			}
		}
		System.out.println(res);
	}
}
