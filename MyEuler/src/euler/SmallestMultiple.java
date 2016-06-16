package euler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Smallest multiple


Problem 5
 

2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 
What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

 * @author WILLJOE
 *
 */
public class SmallestMultiple {

	
	public List<Integer> buildArray(int num){
		List<Integer> res = new ArrayList<Integer>();
		for(int i=1;i<=num;i++){
			res.add(i);
		}
		return res;
	}
	
	public List<Integer> devidedList(List<Integer> input){
		List<Integer> res = new ArrayList<Integer>();
		for(int i=0;i<input.size();i++){
			if(i==0){
				res.add(input.get(i));
			} else {
				int theNumber = input.get(i);
				for(int j=0;j<i;j++){
					int before = res.get(j);
					if((theNumber % before) == 0){
						theNumber = theNumber/before;
					}
				}
				res.add(theNumber);
			}
		}
		return res;
	}
	
	public BigDecimal multipleList(List<Integer> dev){
		BigDecimal res =BigDecimal.ONE;
		for(int i=0;i<dev.size();i++){
			res = res.multiply(new BigDecimal(dev.get(i)));
		}
		return res;
	}
	
	public static void main(String[] args) {
		SmallestMultiple sm = new SmallestMultiple();
		List<Integer> order = sm.buildArray(100);
		List<Integer> dev = sm.devidedList(order);
		System.out.println(dev);
		System.out.println(sm.multipleList(dev));
	}
	
}
