package euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Pandigital products
Problem 32
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 *
 *
 *resolve:
 *	largest 2 digits multiple 2 digits is 97 * 86 = 8342. Only 8 digits total.
 * 	and smallest 3 digits multiple 3 digits is 135 * 246 = 33210. Used 11 digits total. 
 *  So, multiplicand and multiplier must be 2 digits number and 3 digits number.(Oh, and 1 digit number multiple 4 digits number.I've forgot.)
 *  So, the product must be 4 digits.
 *  2 digits * 3 digits, the first digit of multiplicand and multiplier 's product must smaller than 10;
 *  So, multiplicand first digit must be 1 or 2; in this case, the smallest product is 187 * 29 = 5423, the largest is 287 * 49 = 14063;
 *  
 *
 */
public class PandigitalProducts {

	int[] base_digit = {1,2,3,4,5,6,7,8,9}; 
	
	List<Integer> products = new ArrayList<Integer>();
	
	List<int[]> multiples = new ArrayList<int[]>();
	
	public void digitsOrders(){
		for(int fi=0;fi<2;fi++){
			for(int si=0;si<9;si++){
				if(si == fi) continue;
				for(int ti=0;ti<9;ti++){
					if(ti == si || ti == fi) continue;
					for(int foi=0;foi<9;foi++){
						if(fi==1 && ti>3 && foi >3) continue;
						if(foi == fi || foi == si || foi == ti) continue;
						for(int fii=0;fii<9;fii++){
							if(fii == foi || fii == ti || fii == si || fii == fi) continue;
							int[] aOrder = new int[5];
							aOrder[0] = base_digit[fi];
							aOrder[1] = base_digit[si];
							aOrder[2] = base_digit[ti];
							aOrder[3] = base_digit[foi];
							aOrder[4] = base_digit[fii];
							multiples.add(aOrder);
						}
					}
				}
			}
		}
	}
	
	public void computerProduct(int[] order){
		if(order.length<5) return;
		Integer product1 = (order[0]*10 + order[1]) * (order[2]*100 + order[3]*10 + order[4]);
		Integer product2 = (order[0]*100 + order[1]*10 + order[2]) * (order[3]*10 + order[4]);
		Integer product3 = (order[0]) * (order[1]*1000 + order[2]*100 + order[3] * 10 + order[4]);
		Integer product4 = (order[0]*1000 + order[1]* 100 + order[2] * 10 + order[3]) * (order[4]);
		
		if(!products.contains(product1)) {
			if(product1<10000){
				if(checkRightable(order, product1)){
					System.out.println(Arrays.toString(order)+" 2x3 "+product1);
					products.add(product1);
				}
			}
		}else{
			System.out.println("has contained "+Arrays.toString(order)+" 2x3 "+product1);
		}
		if(!products.contains(product2)){
			if(product2 < 10000){
				if(checkRightable(order, product2)){
					System.out.println(Arrays.toString(order)+" 3x2 "+product2);
					products.add(product2);
				}
			}
		} else{
			System.out.println("has contained "+ Arrays.toString(order)+" 3x2 "+product2);
		}
		if(!products.contains(product3)){
			if(product3 < 10000){
				if(checkRightable(order, product3)){
					System.out.println(Arrays.toString(order)+" 1x4 "+product3);
					products.add(product3);
				}
			}
		} else{
			System.out.println("has contained "+ Arrays.toString(order)+" 3x2 "+product3);
		}
		if(!products.contains(product4)){
			if(product4 < 10000){
				if(checkRightable(order, product4)){
					System.out.println(Arrays.toString(order)+" 4x1 "+product4);
					products.add(product4);
				}
			}
		} else{
			System.out.println("has contained "+ Arrays.toString(order)+" 3x2 "+product4);
		}
	}
	
	public boolean checkRightable(int[] order, int product){
		boolean res = true;
		int d1 = product / 1000;
		if(!checkInabel(order, d1)){
			return false;
		}
		int d2 = (product - 1000 * d1 )/100;
		if(!checkInabel(order, d2) || d2 == d1){
			return false;
		}
		int d3 = (product - 1000 * d1 - 100 * d2)/10;
		if(!checkInabel(order, d3) || d3 == d2 || d3 ==d1){
			return false;
		}
		int d4 = product - 1000 * d1 - 100 * d2 - 10 * d3;
		if(!checkInabel(order, d4) || d4 == d3 || d4 == d2 || d4 == d1){
			return false;
		}
		
		return res;
	}
	
	public boolean checkInabel(int[] order, int digit){
		boolean res = true;
		if(digit == 0) return false;
		for(int i=0;i<order.length;i++){
			if(order[i] == digit){
				return false;
			}
		}
		return res;
	}
	
	
	
	public void buildAllProduct(){
		for(int[] order : this.multiples){
			computerProduct(order);
		}
	}
	
	public Integer buildSum(){
		int sum = 0;
		for(Integer p : this.products){
			sum = sum + p;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		PandigitalProducts pp = new PandigitalProducts();
		System.out.println("start");
		long start = System.currentTimeMillis();
		pp.digitsOrders();
		System.out.println("order size: "+pp.multiples.size());
		pp.buildAllProduct();
		System.out.println("products size: "+pp.products.size());
		int result = pp.buildSum();
		long end = System.currentTimeMillis();
		System.out.println("result is: "+result+"; used: "+ (end -start)+"ms");
	}
}
