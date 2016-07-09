/*

Problem: Novel String

Program: novel.java

Problem:

The K-doublets of a string of characters are the ordered pairs of characters that are K distance from each other. A string is K-singular if all its K- doublets are different. A string is Novel String if it is K-singular for all possible K distances.

For e.g. take the string FLBL, its 0-doublets are FL, LB and BL. Since all these are different, FLBL is 0-singular. Similarly, its 1-doublets are FB and LL, since they are different FLBL is 1-singular as well. Lastly, the only 2-doublet of FLBL is FL, so FLBL is 2-singular. Hence, FLBL is a Novel String.

Note that the fact that FL is both a 0-doublet and 2-doublet is insignificant as zero and two are different distances.

Input:

The input is one or more non-empty strings of at most 100 capital letters, each string on a line by itself, followed by a line containing only two dollars ($$) signaling the end of the input.

Output:

For each input line, output whether or not it is a Novel string using the exact output format shown below.

Sample Input: (Input File: novel.in)
FLBL
FFLL
ORDINARY
R
QYQRQYY
$$

Sample Output: (Output File: novel.out)
FLBL is a Novel string
FFLL is not a Novel string
ORDINARY is a Novel string
R is a Novel string
QYQRQYY is not a Novel string

FLBL is a Novel string
FFLL is not a Novel string
ORDINARY is a Novel string
R is a Novel string
QYQRQYY is not a Novel string

*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Novel {
	static boolean isStringNovel(String input) {

		int len = input.length();
		boolean novel = true;

		for (int doubletId = 0; doubletId < (len - 2); doubletId++) {
			boolean charMap[][] = new boolean[26][26];
			for (int i = 0; i < len - (doubletId + 1); i++) {
				int charIndex1 = input.charAt(i) - 'A';
				int charIndex2 = input.charAt(i + (doubletId + 1)) - 'A';
				if (charMap[charIndex1][charIndex2]) {
					novel = false;
					break;
				}
				charMap[charIndex1][charIndex2] = true;
			}
			if (!novel)
				break;
		}

		return novel;
	}

	public static void main(String[] args) {

		clearOutputFile();
		
		String[] inputs = readInputsFromFile();
		// String[] inputs = { "FLBL", "FFLL", "ORDINARY", "R", "QYQRQYY" };

		for (String input : inputs) {
			String response = input
					+ (isStringNovel(input) ? " is a Novel string"
							: " is not a Novel string");
			System.out.println(response);

			writeToFile(response);
		}
	}

	static String[] readInputsFromFile() {
		LinkedList<String> response = new LinkedList<String>();
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader("novel.in"));
			while ((line = br.readLine()) != null && !line.equals("$$")) {
				response.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		String[] result = new String[response.size()];
		response.toArray(result);
		return result;
	}

	static void writeToFile(String line) {
		try {
			FileWriter fstream = new FileWriter("novel.out", true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(line + "\n");
			out.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	static void clearOutputFile() {
		File file = new File("novel.out");
		file.delete();
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}