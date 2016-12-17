package euler;

/**
 * 
Integer right triangles
Problem 39
If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p ≤ 1000, is the number of solutions maximised?
 *And smallest one is 12 : {3,4,5};
 *resolve:
 *		a + b + c = p;
 *		a^2 + b^2 = c^2;
 *		
 *		trans:
 *			c = x - a - b;
 *			c = sqrt(a^2 + b^2);
 *
 *
 *			sqrt(a^2 + b^2) = p - a - b;
 *			c < a + b;
 *			a + b > p/2;
 *			c < p/2;
 *			a <= b;
 *		a,b,c are integer.
 *		
 */
public class IntegerRightTriangles {
	
	int maxP = 0;
	int maxCount = 0;
	
	public boolean check(int a, int b, int c){
		return Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2);
	}
	
	public int checkSolutionByC(int c, int left){
		int count = 0;
		int aTop = (int)left/2;
		for(int a = 1; a <= aTop; a++){
			if(check(a, left - a, c)){
				count ++;
			}
		}
		return count;
	}
	
	public int checkSolutionCount(int p){
		int count = 0;
		int cTop = (int)p/2;
		for(int c = 5; c <= cTop; c++){
			count += checkSolutionByC(c, p-c);
		}
		return count;
	}
	
	public int checkSolutionByA(int a, int left){
		int count = 0;
		int bTop = (int)left/2;
		for(int b=a;b<=bTop;b++){
			if(check(a,b,left -b)){
				count ++;
			}
		}
		return count;
	}
	
	public int checkSoluteionCountA(int p){
		int count = 0;
		int aTop = (int)p/3;
		for(int a = 1; a<= aTop; a++){
			count += checkSolutionByA(a, p - a);
		}
		return count;
	}
	
	public void buildAll(){
		for( int i=1000; i>=12; i--){
			int soluteI = checkSolutionCount(i);
			//int soluteI = checkSoluteionCountA(i);
			if(soluteI > maxCount){
				System.out.println("p :["+i+"]'s solution count is "+soluteI+" ;");
				maxCount = soluteI;
				maxP = i;
			}
		}
	}
	
	/**
	 * With method : checkSolutionCount : 
	 * 		p :[1000]'s solution count is 1 ;
			p :[990]'s solution count is 4 ;
			p :[924]'s solution count is 5 ;
			p :[840]'s solution count is 8 ;
			result is 840 ; used 10337ms
		With method : checkSoluteionCountA : 
			p :[1000]'s solution count is 1 ;
			p :[990]'s solution count is 4 ;
			p :[924]'s solution count is 5 ;
			p :[840]'s solution count is 8 ;
			result is 840 ; used 4678ms
	 * @param args
	 */
	public static void main(String[] args) {
		IntegerRightTriangles irt = new IntegerRightTriangles();
		long start = System.currentTimeMillis();
		irt.buildAll();
		long end = System.currentTimeMillis();
		System.out.println("result is "+irt.maxP+" ; used "+(end - start)+"ms");
	}
	
	
}
