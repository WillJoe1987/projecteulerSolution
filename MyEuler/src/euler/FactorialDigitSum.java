package euler;

import java.math.BigDecimal;

public class FactorialDigitSum {
	
	public BigDecimal factorial(int n){
		BigDecimal result = BigDecimal.ONE;
		int i=2;
		while(i<=n){
			result = result.multiply(new BigDecimal(i));
			i++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		FactorialDigitSum fds = new FactorialDigitSum();
		String sum  =fds.factorial(100).toString();
		int result = 0;
		for(int i=0;i<sum.length();i++){
			result += ( sum.charAt(i) - 48 );
		}
		long end = System.currentTimeMillis();
		System.out.println(result);
		System.out.println("used : "+ (end - start));
	}
	
}
