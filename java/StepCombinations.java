/*

Print all combinations of steps 1,2,3 to reach 100 steps

*/

import java.util.*;

public class StepCombinations {
	public static void main(String[] args) {
		int[] steps = {1,2,3};
		int destination = 7;

		for(String combination : findStepCombinations(destination, steps)) {
			System.out.println(combination);
		}
	}

	public static LinkedList<String> findStepCombinations(int destination, int[] steps) {

		HashMap<Integer, LinkedList<String>> store = new HashMap<Integer, LinkedList<String>>();

		for(int i = 1; i<=destination; i++) {
	
			System.out.println("Destination : " + i);

			LinkedList<String> result = new LinkedList<String>();
			
			if(i == 1) {
				result.add("1");
				store.put(i, result);
				continue;
			}	
	
			for(int step : steps) {
				System.out.println("Step : " + step);
				if(i == step) {
					result.add("" + step);
				}

				if(i > step) {
					LinkedList<String> combinations = store.get(i - step);
					for(String combination : combinations) {
						result.add(combination + step);
					}
				}				
			}

			store.put(i, result);
		}

		return store.get(destination);
	}
}