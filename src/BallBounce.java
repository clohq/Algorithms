/*

1. There are N stairs and a ball is dropped from the top stair. A ball can land in the next step or the step next to it. Find the number of ways the ball will reach the ground. Write a code for this.

*/

public class BallBounce {
	public static void main(String[] args) {
		int[] steps = {1,2, 3};
		int totalSteps = 7;
		System.out.println(findCombinationCount(steps, totalSteps));
	}

	public static long findCombinationCount(int[] steps, int totalSteps) {

		long[] stepCombs = new long[totalSteps];

		for(int i = 0; i < totalSteps; i++) {
			long result = 0;

			for(int j = 0; j < steps.length; j++) {

				int step = steps[j];

				if(i + 1 == step)
					result ++;

				if(i + 1 > step) {
					result += stepCombs[i - step];
				}
			}	

			stepCombs[i] = result;
		}

		return stepCombs[totalSteps - 1];
	}
}