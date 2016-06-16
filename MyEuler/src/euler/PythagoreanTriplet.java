package euler;

/**
 * Special Pythagorean triplet
Problem 9
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
 * @author WILLJOE
 *
 */
public class PythagoreanTriplet {
	
	/**
	 * b = (1000^2 - 2000a) / (2000 -2a)
	 * @param a
	 * @return
	 */
	public int computeB(int a){
		int son = 1000 * 1000 - 2000 * a;
		int mother = 2000 - 2*a;
		
		if(son % mother == 0){
			return son/mother;
		}
		
		return -1;
	}
	
	/**
	 * c = 100 - a - b
	 * @param a
	 * @param b
	 * @return
	 */
	public int computeC(int a, int b){
		return 1000 - a - b;
	}
	
	/**
	 * Because a < b < c and a + b + c = 1000
	 * so , the value's range of a is from 1 to 332.
	 * So , let's find it.
	 * @return
	 */
	public int getProcduct(){
		int result = 0;
		int a = 1;
		int b = 0;
		int c = 0;
		
		while(a< 332){
			b = this.computeB(a);
			if(b>0){
				c = this.computeC(a, b);
				break;
			}
			a ++ ;
		}
		result = a*b*c;
		System.out.println("a=>"+a+";b=>"+b+";c=>"+c+";");
		return result;
	}
	
	public static void main(String[] args) {
		PythagoreanTriplet pt = new PythagoreanTriplet();
		long start = System.currentTimeMillis();
		System.out.println(pt.getProcduct());
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
	
}
