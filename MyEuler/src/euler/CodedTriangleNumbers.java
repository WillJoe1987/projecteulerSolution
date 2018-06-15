package euler;

/**
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?
 * @author wlj
 *
 *	-0.5 + Math.sqrt((double)2*score + 0.25);
 *
 */
public class CodedTriangleNumbers {

	String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	NamesScores ns = null;
		
	public CodedTriangleNumbers(String file){
		ns = new NamesScores(file);
	}
	
	public int fetchIndex = 0;
	
	public int popAScore(){
		int score = this.ns.getNs().getOrderedScoreByIndex(fetchIndex);
		fetchIndex ++;
		return score;
	
	}
	
	public boolean ifTriangle(int score){
		if(score < 0 )return false;
		double d1 = -0.5 + Math.sqrt((double)2*score + 0.25);
		if(ifInteger(d1)){
			return true;
		}
		return false;
	}
	
	public boolean ifInteger(double d){
		if(d == (double)((int)d)) return true;
		return false;
	}
	
	public int solver(){
		int count = 0;
		int score = this.popAScore();
		while(score >= 0){
			if(ifTriangle(score)){
				count += 1;
			}
			score = this.popAScore();
		}
		return count;
	}
	
	/**
	 * result :162
		 used :13ms
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		CodedTriangleNumbers ns = new CodedTriangleNumbers("E:\\wlj_github\\projecteulerSolution\\MyEuler\\src\\p042_words.txt");
		System.out.println("result :"+ns.solver());
		long end = System.currentTimeMillis();
		System.out.println("used:"+(end - start)+"ms");
	}
	
}
