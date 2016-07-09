/*

Find the sub array that yeilds highest sum

*/

public class MaxSubArray {
	public static void main(String[] args) {
		int[] inputs = {2, -8, 3, -2, 4, -10};

		System.out.println(findMaxSubArray(inputs));
	}

	public static int findMaxSubArray(int[] inputs) {
		
		int maxSum = 0;
		int sum = 0;
		int start = 0;
		int end = 0;

		for(int i=0; i< inputs.length; i++) {

			int num = inputs[i];

			sum += num;
			if(num >= sum) {
				start = i;
				sum = num;
			}

			if(sum > maxSum) {
				maxSum = sum;
				end = i;
			}
		}

		System.out.println(start);		
		System.out.println(end);		

		return maxSum;

	}
}