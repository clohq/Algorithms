/*

Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.

For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.

*/

public class CoinChange {
	public static void main(String args[]) {
		int N = 4;
		int[] coins = {1,2,3};
		System.out.println(countCoinCombinations(N, coins));
	}

	public static int countCoinCombinations(int n, int[] coins) {
		int[] nArray = new int[n+1];

		// Base Case
		nArray[0] = 1;

		for(int coin = 0; coin < coins.length; coin++) {
			for(int i = coins[coin]; i <= n; i++) {
				nArray[i] += nArray[i - coins[coin]];
			}
		}

		return nArray[n];
	}
}