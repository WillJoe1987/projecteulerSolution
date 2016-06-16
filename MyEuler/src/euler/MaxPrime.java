package euler;

/**
 * Largest prime factor


Problem 3
 

The prime factors of 13195 are 5, 7, 13 and 29.
 
What is the largest prime factor of the number 600851475143 ?

 * @author WILLJOE
 *
 */
public class MaxPrime {
	public static int getMaxPrimes(long n){
		int i=2;        
		while(n>1){            
			if(n%i==0){                
				System.out.println(i);                
				n/=i;            
			}else{
				i++;            
			}        
		}
		return i;
	}
	public static void main(String args[]){
		long n=600851475143l;  
		getMaxPrimes(n);
	}
}
