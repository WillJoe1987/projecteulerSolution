package euler;

import java.util.ArrayList;
import java.util.List;

/**
 * Coin sums
Problem 31
In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
It is possible to make £2 in the following way:

1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
How many different ways can £2 be made using any number of coins?
 * @author WILLJOE
 *
 */
/**
 * p200 = 1 + P100 * P100
 * P100 = 1 + P50 * P50
 * p50 = 1 + P20 * P20 * P10
 * P20 = 1 + P10 * P10
 * P10 = 11
 * p9 = 8
 * p8 = 7
 * p7 = 5
 * p6 = 5
 * P5 = 4
 * p4 = 3
 * p3 = 2
 * P2 = 2
 * P1 = 1
 * 
 * 查看了各种组合数学，动态规划之类的算法，决定还是暴力求解吧。还好，353ms。
 * 直接main函数。
 * 
 * @author WILLJOE
 *
 */
public class CoinSums {
	
	int[] coins = {1,2,5,10,20,50,100,200};
	
	
	
	int wayCount = 0;
	
	public class CoinTree{
		CoinNode root;
		public CoinTree(){
			root = new CoinNode(200,0);
		}
	}
	
	public class CoinNode{
		
		int value ;
		int level;
		List<CoinNode> childs;
		
		public CoinNode(int i , int level){
			value = i;
			this.level = level;
			if(i == 1){
				return;
			}else{
				childs = new ArrayList<CoinNode>();
				if(i == 5){
					childs.add(new CoinNode(2,level+1));
					childs.add(new CoinNode(2,level+1));
					childs.add(new CoinNode(1,level+1));
				}else if(i == 50){
					childs.add(new CoinNode(20,level+1));
					childs.add(new CoinNode(20,level+1));
					childs.add(new CoinNode(10,level+1));
				}else{
					childs.add(new CoinNode(i/2,level+1));
					childs.add(new CoinNode(i/2,level+1));
				}
			}
			
		}
	}
	
	public void count(){
		
	}
	
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		int x1 = 0,x2 = 0,x5 = 0,x10 = 0,x20 = 0,x50 = 0,x100 = 0,x200 = 0;
		int count = 0;
		for(x1 = 0; x1<=200;x1++){
			if(x1+2*x2+5*x5+10*x10+20*x20+50*x50+100*x100+200*x200>200){
				continue;
			}
			for(x2 = 0;x2<=100;x2++){
				if(x1+2*x2+5*x5+10*x10+20*x20+50*x50+100*x100+200*x200>200){
					continue;
				}
				for(x5 = 0; x5<=40;x5++){
					if(x1+2*x2+5*x5+10*x10+20*x20+50*x50+100*x100+200*x200>200){
						continue;
					}
					for(x10=0;x10<=20;x10++){
						if(x1+2*x2+5*x5+10*x10+20*x20+50*x50+100*x100+200*x200>200){
							continue;
						}
						for(x20=0;x20<=10;x20++){
							if(x1+2*x2+5*x5+10*x10+20*x20+50*x50+100*x100+200*x200>200){
								continue;
							}
							for(x50=0;x50<=4;x50++){
								if(x1+2*x2+5*x5+10*x10+20*x20+50*x50+100*x100+200*x200>200){
									continue;
								}
								for(x100=0;x100<=2;x100++){
									if(x1+2*x2+5*x5+10*x10+20*x20+50*x50+100*x100+200*x200>200){
										continue;
									}
									for(x200=0;x200<=1;x200++){
										if(x1+2*x2+5*x5+10*x10+20*x20+50*x50+100*x100+200*x200==200){
											count ++;
										}
									}
									x200=0;
								}
								x100=0;
							}
							x50=0;
						}
						x20=0;
					}
					x10=0;
				}
				x5=0;
			}
			x2=0;
		}
		System.out.println("result is "+count);
		long end = System.currentTimeMillis();
		System.out.println("used: "+(end - start)+"ms");
		
	}

}
