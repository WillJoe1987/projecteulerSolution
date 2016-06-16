package euler;

import java.util.Calendar;

/**
 * 
Previous	
Next
Counting Sundays
Problem 19
You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 * @author WILLJOE
 *
 */
public class CountingSundays {
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Calendar top = Calendar.getInstance();
		top.set(2000, Calendar.DECEMBER, 2);
		Calendar buttom = Calendar.getInstance();
		buttom.set(1901, Calendar.JANUARY, 1);
		int count = 0;
		while(buttom.before(top)){
			if(buttom.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) count++;
			buttom.add(Calendar.MONTH, 1);
		}
		long end = System.currentTimeMillis();
		System.out.println(count);
		System.out.println("used : "+(end - start));
	}
	
}
