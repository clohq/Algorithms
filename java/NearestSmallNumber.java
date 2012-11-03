/*

Find the nearest small number using the same digits of a given number

*/

import java.util.*;

public class NearestSmallNumber {
	public static void main(String[] args) {
		int input = 431249;
		System.out.println(findNearestSmallNumber(input));
	}

	public static int findNearestSmallNumber(int input) {

		int digitCount = 0;
		int temp = input;
		
		while(temp > 0) {
			temp /= 10;
			digitCount++;
		}

		int[] digits = new int[digitCount];
		int i = 0;
		temp = input;
				
		while(temp > 0) {
			int digit = temp % 10;
			digits[i++] = digit;
			temp /= 10;
		}

		System.out.println(Arrays.toString(digits));

		int source = -1;
		int swap = -1;

		for(int digit1 = 0; digit1<digits.length; digit1++) {
			for(int digit = digit1 + 1; digit<digits.length; digit++) {
				if (digits[digit] > digits[digit1]) {
					swap = digit;
					source = digit1;
					break;
				}
			}
			if(swap > -1) break;
		}

		System.out.println(source);
		System.out.println(swap);

		if (swap == -1) return swap;
		else {
			int temp1 = digits[source];
			digits[source] = digits[swap];
			digits[swap] = temp1;
		}

		System.out.println(Arrays.toString(digits));

		int[] digitMap = new int[10];

		for(int digit = 0; digit<swap; digit++) {
			digitMap[digits[digit]]++;
		}

		System.out.println(Arrays.toString(digitMap));
		int temp2 = 0;

		for(int j=0; j<10 ; j++) {
			for(int k=0 ; k<digitMap[j]; k++)
				digits[temp2++] = j;
		}

		System.out.println(Arrays.toString(digitMap));

		int result = 0;

		for(int digit = digits.length-1; digit>=0; digit--) {
			result *= 10;
			result += digits[digit];
		}		

		return result;
	}
}	