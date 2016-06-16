package euler;



/**
 * Sum square difference


Problem 6
 

The sum of the squares of the first ten natural numbers is,
 
12 + 22 + ... + 102 = 385
 
The square of the sum of the first ten natural numbers is,
 
(1 + 2 + ... + 10)2 = 552 = 3025
 
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 
Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

 * @author WILLJOE
 *
 */
public class SqualsMina {

	
	public int sumN ( float n ){
		float res= (1+n)/2*n;
		
		return Math.round(res);
	}
	
	public int sqN ( int n ){
		int res = 0;
		for(int i=1;i<=n;i++){
			res += i*i;
		}
		return res;
	}
	
	public int sqM(int n){
		int sumN = this.sumN(n);
		int sqN = this.sqN(n);
		return sumN * sumN - sqN;
	}
	
	public static void main(String[] args) {
		System.out.println(new SqualsMina().sqM(100));
	}
	
}
