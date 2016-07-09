/*

Given a String, print all the Permutations of the string

*/

public class PermuteString {

	public static void main(String[] args) {
		String input = "abcd";
		for (String string : permuteString(input)) {
			System.out.println(string);
		}
	}

	public static String[] permuteString(String input) {

		if(input.length() == 1) {
			String[] output = new String[1];
			output[0] = new String(input);
			return output;
		} else {
			char lastChar = input.charAt(input.length()-1);
			String[] strings = permuteString(input.substring(0,input.length()-1));
			String[] output = new String[strings.length * input.length()];
			int count = 0;

			for (String string : strings) {
				output[count++] = lastChar + string;
				for(int i = 1 ; i<string.length(); i++) {
					output[count++] = string.substring(0,i) + lastChar + string.substring(i);
				}
				output[count++] =  string + lastChar;
			}
			return output;
		}
	}
}