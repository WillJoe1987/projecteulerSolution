package euler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * Distinct powers
Problem 29
Consider all integer combinations of ab for 2 ≤ a ≤ 5 and 2 ≤ b ≤ 5:

22=4, 23=8, 24=16, 25=32
32=9, 33=27, 34=81, 35=243
42=16, 43=64, 44=256, 45=1024
52=25, 53=125, 54=625, 55=3125
If they are then placed in numerical order, with any repeats removed, we get the following sequence of 15 distinct terms:

4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125

How many distinct terms are in the sequence generated by ab for 2 ≤ a ≤ 100 and 2 ≤ b ≤ 100?
 * @author WILLJOE
 *
 */
/**
 * The value a1^b1 == a2^b2, if b2 = a2.log(a1)*b1;
 * 
 * @author WILLJOE
 *
 */
public class DistinctPowers {
	
	public class PowerPair{
		
		int a = 0;
		int b = 0;
		String buff = "";
		
		public PowerPair(int a, int b){
			this.a = a;
			this.b = b;
			buff = new BigDecimal(a).pow(b).toString();
		}
		
		public BigDecimal getPower(){
			BigDecimal ba = new BigDecimal(a);
			return ba.pow(b);
		}
		
		public boolean equals(PowerPair pp){
			
//			if(b % pp.b == 0 ){
//				int bactor = b/pp.b;
////				BigDecimal ba = new BigDecimal(a);
////				BigDecimal bpa = new BigDecimal(pp.a);
////				if(ba.pow(bactor).equals(bpa)){
////					System.out.println("1 "+ba.pow(bactor));
////					return true;
////				}
//				
//				if(Math.pow(a, bactor) == pp.a){
//					return true;
//				}
//			}
//			if(pp.b % b == 0){
//				int bactor = pp.b/b;
////				BigDecimal ba = new BigDecimal(a);
////				BigDecimal bpa = new BigDecimal(pp.a);
////				if(bpa.pow(bactor).equals(ba)){
////					System.out.println("2 "+bpa.pow(bactor));
////					return true;
////				}
//				if(Math.pow(pp.a, bactor) == a){
//					return true;
//				}
//			}
//			
//			if(this.getPower().equals(pp.getPower())){
//				System.out.println(this+""+pp);
//				return true;
//			}
//			
////			double bactor = (double)b/(double)pp.b;
////			if(Math.pow(a, bactor) == pp.a){
////				return true;
////			}
//			
//			
//			
//			return false;
			return buff.equals(pp.buff);
		}
		
		public String toString(){
			return "a:"+a+",b:"+b+";";
		}
	}
	
	List<PowerPair> pps = new ArrayList<PowerPair>();
	
	public boolean addDistinct(PowerPair pp){
		for(int i=0;i<pps.size();i++){
			if(pps.get(i).equals(pp)){
				return false;
			}
		}
		pps.add(pp);
		return true;
	}
	
	public int getCount(){
		return this.pps.size();
	}
	
	public int countAll(){
		for(int b = 2; b<101; b++){
		for(int a = 2; a<101; a++){
				if(addDistinct(new PowerPair(a, b))){
					System.out.println(a+","+b+"; "+getCount());
				}
			}
		}
		return getCount();
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		DistinctPowers dp = new DistinctPowers();
		System.out.println("result is "+dp.countAll());
		long end = System.currentTimeMillis();
		System.out.println("used : "+(end - start)+"ms");
		
	}
}
