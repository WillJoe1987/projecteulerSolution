package euler;

import java.util.ArrayList;
import java.util.List;


/**
 * Reciprocal cycles
Problem 26
A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

1/2	= 	0.5
1/3	= 	0.(3)
1/4	= 	0.25
1/5	= 	0.2
1/6	= 	0.1(6)
1/7	= 	0.(142857)
1/8	= 	0.125
1/9	= 	0.(1)
1/10	= 	0.1
Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 * @author WILLJOE
 *
 */
public class ReciprocalCycles {
	
	public int largest = 0;
	public int tmpmodeLength = 0;
	
	
	/**
	 * To get remainder, and judge if the remainder has appeared. 
	 * @param number
	 * @return
	 */
	public int findCycleSize2(int number){
		int tmode = 10 % number;
		List<Integer> mod = new ArrayList<Integer>();
		while(tmode != 0){
			if(mod.contains(tmode)){
				return mod.size() - mod.indexOf(tmode);
			}else{
				mod.add(tmode);
				tmode = (tmode * 10) % number;
			}
		}
		return 0;
	}
	
	public int findCycleSize(String number){
		int size = -1;
		for( int i=1;i<number.length();i++){
			String firstMode = number.substring(0,i);
			for(int j = 0; j< firstMode.length();j++){
				if(this.ajusticeMode(number,firstMode.substring(j))){
					return firstMode.length() - j;
				}
			}
		}
		return size;
	}
	
	/**
	 * 判断mode是否是循环体，不能确定mode中是否包含多个循环体
	 * @param number
	 * @param mode
	 * @return
	 */
	public boolean ajusticeMode(String number, String mode){
		if(null == mode || mode.length() == 0) return false;
		if(number.indexOf(mode)<0) return false;
		int adjustCount = 2;
		if(mode.length()<10){
			adjustCount = 5;
		}
		if(mode.length()>100){
			adjustCount = 1;
		}
		int index = number.indexOf(mode);
		int modeLen = mode.length();
		for(int i = 0;i < adjustCount;i++){
			String tmpMode = number.substring(index + modeLen + (i * modeLen), index + (modeLen*2) + (i * modeLen));
			if(!tmpMode.equals(mode)) return false;
		}
		return true;
		
	}
	
	public int getLargestBlow(int top){
		
		for( int i = top;i>0;i--){
			//BigDecimal d = BigDecimal.ONE.divide(new BigDecimal(i), 2000, BigDecimal.ROUND_FLOOR);
			//int modlen = this.findCycleSize(d.toString().substring(2));
			int modlen = this.findCycleSize2(i);
			/**
			 * 经过勘察循环体与除数的关系，发现，循环体的长度小于等于除数减一；
			 * 所以，从1000递减测算，如果发现循环体的长度等于除数减一，且比当前遍历的循环体最大长度大，则直接返回当前数；
			 * 否则，返回已记录的最大数；
			 */
			if(modlen == i -1){
				if(modlen <= tmpmodeLength){
					return largest;
				}else{
					return i;
				}
			}
			if(modlen > tmpmodeLength){
				tmpmodeLength =  modlen;
				largest = i;
			}
		}
		return largest;
	}
	
	
	public static void main(String[] args) {
		ReciprocalCycles rc = new ReciprocalCycles();
		long start = System.currentTimeMillis();
		System.out.println("result:"+rc.getLargestBlow(1000));
		long end = System.currentTimeMillis();
		System.out.println("used:"+(end - start));
		
	}
}
