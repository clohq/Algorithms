/*

A sorted array has been rotated so that the elements might appear in the order 3 4 5 6 7 1 2. How would you find the minimum element?

*/

public class FindReset {
	
	public static void main(String args[]) {
		int[] inputs = {7,1,2,3,4,5,6};
		int length = inputs.length;

		int output = binaryFindReset(inputs, 0,length-1);
		System.out.println(output);
	}

	public static int binaryFindReset(int[] inputs, int start, int end) {
		
		if(start + 1 == end && inputs[start] > inputs[end]) {
			return end;
		}

		if(inputs[start] < inputs[end]) {
			return -1;
		}

		int mid = (start + end) / 2;

		if(inputs[start] > inputs[mid]) {
			return binaryFindReset(inputs, start, mid);
		} else {
			return binaryFindReset(inputs, mid, end);
		}
	}
}