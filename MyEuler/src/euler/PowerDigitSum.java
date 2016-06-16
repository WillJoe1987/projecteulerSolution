package euler;

import java.math.BigDecimal;

public class PowerDigitSum {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		int result = 0;
		BigDecimal power = new BigDecimal(2).pow(1000);
		String powerStr = power.toString();
		for(int i=0;i<powerStr.length();i++){
			result +=( powerStr.charAt(i) - 48);
		}
		System.out.println(result);
		long end = System.currentTimeMillis();
		System.out.println("used :"+(end - start));
		
	}
	
}
