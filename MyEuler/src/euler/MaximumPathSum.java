package euler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Maximum path sum I
Problem 18
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:

75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
 * @author WILLJOE
 *
 */
/**
 * Maximum path sum II
Problem 67
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.

NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this problem, as there are 299 altogether! If you could check one trillion (1012) routes every second it would take over twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)
 */
public class MaximumPathSum {
	
	private Integer[] pathSumCache;
	private IntHeap heap;
	
	public MaximumPathSum(){
		this.heap = new IntHeap();
		this.pathSumCache = new Integer[this.heap.getTotalLevel()];
		Arrays.fill(this.pathSumCache, 0);
	}
	
	public MaximumPathSum( String filename ){
		this.heap = new IntHeap( filename );
		this.pathSumCache = new Integer[this.heap.getTotalLevel()];
		Arrays.fill(this.pathSumCache, 0);
	}
	
	/**
	 * Fetch level by level to computer the largest path sum.
	 * @param i
	 */
	private void fetchLevel(int i){
		Integer[] level = this.heap.getByLevel(i);
		Integer[] pathSumCacheTmp = new Integer[this.heap.getTotalLevel()];
		Arrays.fill(pathSumCacheTmp, 0);
		for(int index = 0; index < level.length; index++){
			if(index == 0){
				pathSumCacheTmp[index] = this.pathSumCache[0] + level[0];
			}else{
				int int1 = level[index] + this.pathSumCache[index-1];
				int int2 = level[index] + this.pathSumCache[index];
				pathSumCacheTmp[index] = Math.max(int1, int2);
			}
		}
		this.pathSumCache = pathSumCacheTmp;
	}
	
	public void searchLevel(int i){
		if(i>this.heap.getTotalLevel()){
			i = this.heap.getTotalLevel();
		}
		if(i<1) i=1;
		for(int index = 0;index < i;index ++){
			this.fetchLevel(index);
		}
	}
	
	public int findMax(){
		Arrays.sort(this.pathSumCache);
		return this.pathSumCache[this.pathSumCache.length-1];
	}

	public static void main(String[] args) {
		
		String filename = "E:/YTEC_PROS/TRUNC_ERR/sdffasdfasf/src/p067_triangle.txt";
		long start = System.currentTimeMillis();
		MaximumPathSum mps = new MaximumPathSum();
		mps.searchLevel(15);
		System.out.println(mps.findMax());
		long end = System.currentTimeMillis();
		System.out.println("problem 18 used : "+ (end - start));
		start = System.currentTimeMillis();
		mps = new MaximumPathSum(filename);
		mps.searchLevel(100);
		System.out.println(mps.findMax());
		end = System.currentTimeMillis();
		System.out.println("problem 67 used : "+ (end - start));
	}
	
	public class IntHeap{
		
		Integer[][] heap;
		
		public IntHeap(){
			heap = new Integer[15][15];
			heap[0]  = this.buildArray("75",15);
			heap[1]  = this.buildArray("95 64",15);
			heap[2]  = this.buildArray("17 47 82",15);
			heap[3]  = this.buildArray("18 35 87 10",15);
			heap[4]  = this.buildArray("20 04 82 47 65",15);
			heap[5]  = this.buildArray("19 01 23 75 03 34",15);
			heap[6]  = this.buildArray("88 02 77 73 07 63 67",15);
			heap[7]  = this.buildArray("99 65 04 28 06 16 70 92",15);
			heap[8]  = this.buildArray("41 41 26 56 83 40 80 70 33",15);
			heap[9]  = this.buildArray("41 48 72 33 47 32 37 16 94 29",15);
			heap[10] = this.buildArray("53 71 44 65 25 43 91 52 97 51 14",15);
			heap[11] = this.buildArray("70 11 33 28 77 73 17 78 39 68 17 57",15);
			heap[12] = this.buildArray("91 71 52 38 17 14 91 43 58 50 27 29 48",15);
			heap[13] = this.buildArray("63 66 04 68 89 53 67 30 73 16 69 87 40 31",15);
			heap[14] = this.buildArray("04 62 98 27 23 09 70 98 73 93 38 53 60 04 23",15);
		}
		
		public IntHeap(String fileName){
			heap = new Integer[100][100];
			FileInputStream fis;
			try {
				fis = new FileInputStream(fileName);
				BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
				String line = reader.readLine();
				int i=0;
				while(line != null){
					heap[i] = this.buildArray(line, 100);
					i++;
					line = reader.readLine();
				}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public Integer[] buildArray(String numbers, int length){
			String [] result = numbers.split(" ");
			Integer [] ints = new Integer[length];
			Arrays.fill(ints, 0);
			for(int i=0;i<result.length;i++){
				ints[i] = Integer.valueOf(result[i]);
			}
			return ints;
		}
		
		public Integer[] getByLevel(int level){
			return this.heap[level];
		}
		
		public int getTotalLevel(){
			return this.heap.length;
		}
		
	}
	
}
