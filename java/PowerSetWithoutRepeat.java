/*

Given n, you have find all the combinations from power set which doesnt have consecutive 1's in it. For example if n =2 possible values are (00,01,10,11) , here you have to exclude 11 as it has consecutive 1's in it. So answer will be 3 for n=2

*/

import java.util.*;

public class PowerSetWithoutRepeat {
	public static void main(String[] args) {
		ArrayList<Integer> result = findPowerSet(4);
		System.out.println(result.size());	
	}

	public static ArrayList<Integer> findPowerSet(int n) {		
		int max = (1 << n) - 1;
		ArrayList<Integer> result = new ArrayList<Integer>();

		for(int i =0 ; i<= max; i++) {
			int temp = i;
			boolean isResult = true;

			while(temp > 0) {

				if((temp & 3) == 3) {
					isResult = false;
					break;
				}

				temp >>= 1;				
			}

			if(isResult) result.add(i);
		}

		return result;
	}
}