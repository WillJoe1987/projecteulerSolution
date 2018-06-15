package euler;

/**
 * 
 *	Double-base palindromes
 *	Problem 36
 *	The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.
 *
 *	Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 *
 *	(Please note that the palindromic number, in either base, may not include leading zeros.)
 *
 */
public class DoubleBasePalindromes {

	int sum = 0;
	
	public boolean huiwen(String n){
		int len = n.length();
		int hl = (int)(len /2);
		for(int i=0;i<=hl;i++){
			if(n.charAt(i)!=n.charAt(len - 1 - i)){
				return false;
			}
		}
		return true;
	}
	
	public void buildAllBelow(int n){
		
		int i=1;
		while(i<=n){
			String is = i+"";
			String bs = Integer.toBinaryString(i);
			if(huiwen(is) && huiwen(bs)){
				sum += i;
			}
			i++;
		}
		
	}
	
	/**
	 * result is: 872187; used 188ms
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		DoubleBasePalindromes dbp = new DoubleBasePalindromes();
		dbp.buildAllBelow(1000000);
		long end = System.currentTimeMillis();
		System.out.println("result is: "+dbp.sum+"; used "+(end - start)+"ms");
	}

}
