package euler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Names scores
Problem 22
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
 * @author WILLJOE
 *
 */
public class NamesScores {
	
	public static final int BIGGER = 1;
	public static final int SMALLER = -1;
	
	private NameSequence ns ;
	
	public NamesScores(){
		ns = this.new NameSequence();
	}
	
	public NamesScores(String filename){
		ns = this.new NameSequence();
		try {
			loadName(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadName(String filename) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		String nameline = br.readLine();
		br.close();
		String[] names = nameline.split(",");
		for(int i=0;i<names.length;i++){
			String theName = names[i];
			theName = theName.substring(1, theName.length()-1);
			ns.insertName(this.new Name(theName));
		}
	}
	
	public int readAllScores(){
		return this.ns.getAllScores();
	}
	
	
	public class NameSequence{
		
		private List<Name> names = new ArrayList<Name>();
		
		public int insertName(Name name){
			int index = getOrders(name);
			this.names.add(index, name);
			return index;
		}
		
		private int getOrders(Name name){
			if(names.size() == 0) return 0;
			int high = names.size() - 1;
			int low = 0;
			while(low <= high){
				int half = (high + low ) >>> 1;
				Name fetchHalf = names.get(half);
				if(fetchHalf.compareTo(name, 0)>0){
					high = half - 1;
				}else{
					low = half + 1;
				}
			}
			return low;
		}
		
		public int getScoreByIndex(int i){
			if(i>=this.names.size()) return -1;
			return (i+1)*this.names.get(i).getWorth();
		}
		
		public int getAllScores(){
			int result = 0;
			for(int i=0;i<this.names.size();i++){
				result += getScoreByIndex(i);
			}
			return result;
		}
		
		public String toString(){
			String lineSep = "\n";
			String result = "";
			for(int i=0;i<this.names.size();i++){
				result += this.names.get(i)+lineSep;
			}
			return result;
		}
		
	}
	
	public class Name{
		
		int[] nameChar;
		
		public Name(String name){
			String upper = name.toUpperCase();
			int len = name.length();
			this.nameChar = new int[name.length()];
			for(int i=0;i<len;i++){
				this.nameChar[i] = upper.charAt(i) - 64;
			}
		}

		public int compareTo(Name name, int fetch){
			if(fetch>=this.nameChar.length){
				return NamesScores.SMALLER;
			}
			if(fetch>=name.nameChar.length){
				return NamesScores.BIGGER;
			}
			if(name.nameChar[fetch] > this.nameChar[fetch]){
				return NamesScores.SMALLER;
			}
			if(name.nameChar[fetch] < this.nameChar[fetch]) {
				return NamesScores.BIGGER;
			}
			return compareTo(name, fetch + 1);
		}
		
		public int getWorth(){
			int worth = 0;
			for(int i=0;i<this.nameChar.length;i++) worth += this.nameChar[i];
			return worth;
		}
		
		public String toString(){
			String value = "";
			for(int i = 0;i < this.nameChar.length; i++){
				value += (char)(this.nameChar[i]+64);
			}
			return value;
		}
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		NamesScores ns = new NamesScores("E:/YTEC_PROS/TRUNC_ERR/sdffasdfasf/src/p022_names.txt");
		System.out.println("result :"+ns.readAllScores());
		long end = System.currentTimeMillis();
		System.out.println("used:"+(end - start)+"ms");
		System.out.println(ns.ns);
	}
	
}
