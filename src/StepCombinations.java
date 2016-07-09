/*

Print all combinations of steps 1,2,3 to reach 100 steps

*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class StepCombinations {
	public static void main(String[] args) {
		int[] steps = {1,2,3};
		int destination = 7;

		List<String> result = findStepCombinations(destination, steps);

		System.out.println(result.size());

		for(String combination : result) {
			System.out.println(combination);
		}
	}

	public static List<String> findStepCombinations(int destination, int[] steps) {

		HashMap<Integer, List<String>> store = new HashMap<>();

		for(int i = 1; i<=destination; i++) {
	
			System.out.println("Destination : " + i);

			List<String> result = new LinkedList<>();
			
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
					List<String> combinations = store.get(i - step);
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