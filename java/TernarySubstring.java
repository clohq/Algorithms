/*

Find the number of sub strings in a ternary string which don't contain all the 3 chars.

*/

import java.util.*;

public class TernarySubstring {
	public static void main(String[] args) {
		System.out.println(numberOfSubstrings("abc"));
	}

	static int numberOfSubstrings(String A) {

	    if(A.length() <= 1) {
	        return 1;
	    }
	    
	    int previousResult = numberOfSubstrings(A.substring(1));

	    Set<Character> charSet = new HashSet<Character>();
	    
	    int charCount = 0;
	    
	    for(char c : A.toCharArray()) {
	        charSet.add(c);
	        if(charSet.size() > 2) break;
	        charCount ++;
	    }
	    
	    return (previousResult + charCount) % 1000000;
	}

}