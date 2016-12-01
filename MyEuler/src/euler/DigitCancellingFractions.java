package euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Digit cancelling fractions
Problem 33
The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.

If the product of these four fractions is give in its lowest common terms, find the value of the denominator.
 *
 *	Actor:
 *		1、numerator and denominator is between 10-99;
 *		2、numerator\denominator's second digit is the same as denominator\numerator's first digit.
 *		3、the same digit must not be 0.
 *		4、And the other digit in the numbers also must not be 0.
 *		5、fraction is less than 1.
 *	resolve:
 *		so, now we need to choose three numbers in 1-9. to make the numerator and denominator, 
 *		and check if they ware non-trivial.
 *		
 */
public class DigitCancellingFractions {
	
	List<int[]> allComps = new ArrayList<int[]>();
	
	List<int[]> fraction = new ArrayList<int[]>();
	
	public void buildAllComps(){
		for(int i=0;i<7;i++){
			for(int j=i+1;j<8;j++){
				for(int k=j+1;k<9;k++){
					int[] com = new int[3];
					com[0] = i+1;
					com[1] = j+1;
					com[2] = k+1;
					allComps.add(com);
				}
			}
		}
	}
	
	public void getNontrivialFraction(){
		for(int[] comps : allComps){
			this.trivialable(comps[0],comps[1],comps[2]);
			this.trivialable(comps[1],comps[0],comps[2]);
			this.trivialable(comps[2],comps[0],comps[1]);
		}
	}
	//a xi ba!
	public void trivialable(int n1, int n2, int n3){
		int num1= n1 * 10 + n2;
		int den1= n3 * 10 + n1;
		if(num1<den1){
			float d = (float)num1/(float)den1;
			float d2 = (float)n2/(float)n3;
			if(d == d2){
				int[] frac = {num1,den1};
				fraction.add(frac);
			}
		}else if(den1>num1){
			float d = (float)den1/(float)num1;
			float d2 = (float)n3/(float)n2;
			if(d == d2){
				int[] frac = {den1,num1};
				fraction.add(frac);
			}
		}
		
		int num2= n2 * 10 + n1;
		int den2 =n1 * 10 + n3;
		if(num2<den2){
			float d = (float)num2/(float)den2;
			float d2 = (float)n2/(float)n3;
			if(d == d2){
				int[] frac = {num2,den2};
				fraction.add(frac);
			}
		}else if(den2>num2){
			float d = (float)den2/(float)num2;
			float d2 = (float)n3/(float)n2;
			if(d == d2){
				int[] frac = {den2,num2};
				fraction.add(frac);
			}
		}
	}
	
	public int[] fractionsProduct(){
		int num =1;
		int den = 1;
		for(int[] frac : this.fraction){
			num *= frac[0];
			den *= frac[1];
		}
		int[] res = {num, den};
		return res;
	}
	
	/**
	 * E. the fraction's product is 387296/38729600;
	 * it's enought.
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		DigitCancellingFractions dcf = new DigitCancellingFractions();
		dcf.buildAllComps();
		System.out.println(dcf.allComps.size());
		dcf.getNontrivialFraction();
		System.out.println(dcf.fraction.size());
		for(int[] frac : dcf.fraction){
			System.out.println(Arrays.toString(frac));
		}
		System.out.println(Arrays.toString(dcf.fractionsProduct()));
		long end = System.currentTimeMillis();
		System.out.println("result is 100, used:"+(end - start)+"ms");
		
	}

}
