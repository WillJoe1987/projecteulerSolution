package euler;


/**
 * 
Previous	
Next
Number letter counts
Problem 17
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
 * @author WILLJOE
 *
 */
public class NumberLetterCounts {

	String[] baseNumber = {"one","two","three","four","five","six","seven","eight","nine","ten",
			"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty",
			"thirty","forty","fifty","sixty","seventy","eighty","ninety","hundred","hundredAnd","thousand"};
	
	String one2Nine = "onetwothreefourfivesixseveneightnine";
	String ten = "ten";
	String eleven2NineTeen = "eleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen";
	String twenty2Ninety = "twentythirtyfortyfiftysixtyseventyeightyninety";
	String hundred = "hundred";
	String and = "and";
	String thousand = "onethousand";
	
	public int totalLengthOne2Ninetynine(){
		int length = 0;
		length += one2Nine.length()*9;
		length += ten.length();
		length += eleven2NineTeen.length();
		length += twenty2Ninety.length()*10;
		return length;
	}
	
	public int totalLength(){
		int length = 0;
		length += this.totalLengthOne2Ninetynine() * 10;
		length += one2Nine.length() * 100;
		length += hundred.length() * 900;
		length += and.length() * 99 * 9;
		length += thousand.length();
		return length;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		NumberLetterCounts count = new NumberLetterCounts();
		System.out.println(count.totalLength());
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
