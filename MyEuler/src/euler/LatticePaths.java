package euler;


/**
 * Lattice paths
Problem 15
Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.


How many such routes are there through a 20×20 grid?
 * @author WILLJOE
 *
 */
public class LatticePaths {

	
	private long[][] grid = new long[21][21];
	
	public long totolStack = 0;
	public long inGrid = 0;
	
	/**
	 * f(x,y) = f(x-1,y)+f(x,y-1)
	 * if x or y is 0, the result is 1.
	 * @param x
	 * @param y
	 * @return
	 */
	public long latice(int x, int y){
		this.totolStack ++;
		if(this.grid[x][y] > 0) {
			return this.grid[x][y];
		}
		if(x == 0 || y == 0){
			this.grid[x][y] = 1l;
			return 1l;
		}else {
			this.grid[x][y] = this.latice(x-1,y)+this.latice(x,y-1);
			return this.grid[x][y];
		}
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		LatticePaths paths = new LatticePaths();
		System.out.println(paths.latice(5,5));
		long end = System.currentTimeMillis();
		System.out.println("used : "+(end - start));
		System.out.println("total:"+paths.totolStack+";ingrid :"+paths.inGrid);
	}
	
}
