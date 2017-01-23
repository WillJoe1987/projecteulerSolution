package euler;

/**
 * 
Champernowne's constant
Problem 40
An irrational decimal fraction is created by concatenating the positive integers:

0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.

If dn represents the nth digit of the fractional part, find the value of the following expression.

d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 *
 */
public class ChampernowneConstant {

	int d1 = 1;
	int d10 = 1;
	
	public int checkDitigsCount(int index){
		if(index<10) return 1;
		int numberDigit = 1;
		while(true){
			if(this.totalDigitByNumberDigit(numberDigit)>index){
				break;
			}else{
				numberDigit++;
			}
		}
		return numberDigit;
	}
	
	public int totalDigitByNumberDigit(int index){
		int count = 2;
		int indext = 9;
		if(index == 1) return indext;
		while(count <= index){
			indext += (Double.valueOf(Math.pow(10, count) -Math.pow(10, count-1)))*count;
			count ++;
		}
		return indext;
	}
	
	public int getDigitByIndex(int index){
		if(index<10) return index;
		int digitcount = this.checkDitigsCount(index);
		int digitlast= this.totalDigitByNumberDigit(digitcount - 1);
		int theTatgetNumber = (index - digitlast )/digitcount + (int)Math.pow(10, digitcount-1);
		int digitindexintarget = (index - digitlast) % digitcount;
		//maybe it can be computer in math.
		String tarStr = theTatgetNumber + "";
		digitindexintarget --;
		if(digitindexintarget<0) {
			digitindexintarget = tarStr.length() -1;
			
		}
		System.out.println("index :"+index+", number is "+theTatgetNumber);
		return tarStr.charAt(digitindexintarget) - 48;
	}
	
	public int getProduct (int count){
		int product = 1;
		for( int i=0;i<count;i++){
			product *= this.getDigitByIndex((int)Math.pow(10, i));
		}
		return product;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		ChampernowneConstant cc = new ChampernowneConstant();
		System.out.println("result is "+cc.getProduct(10));
		long end = System.currentTimeMillis();
		System.out.println("used "+(end - start)+" ms");
	}

}
