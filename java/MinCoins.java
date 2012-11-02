/*

Given a set of coin denominations, find the minimum number of coins required to match a sum

*/

public class MinCoins {
	public static void main(String[] args) {
		int[] coins = {1,8,10};
		int sum = 64;

		int[] min = new int[sum + 1];

		min[0] = 0;

		for(int subSum = 1; subSum <= sum; subSum++) {
			min[subSum] = 999999;
			for(int coin = 0; coin < coins.length; coin++) {
				int previousSum = subSum - coins[coin];
				if(previousSum < 0) 
					continue;
				if(min[previousSum] + 1 < min[subSum]) {
					min[subSum] = min[previousSum] + 1;
					System.out.println(subSum + " : " + coin + " : " + min[subSum]);
				}
			}
		}

		System.out.println(min[sum]);
	}
}