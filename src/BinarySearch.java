/*

Plain BFS

*/

public class BinarySearch {
	
	public static void main(String[] args) {
		int[] inputs = {1,4,6,9,11,15,20,25};
		int length = inputs.length;

		int output = binarySearch(9, inputs, 0, length);
		System.out.println(output);	
	}

	public static int binarySearch(int key, int[] inputs, int start, int end) {
		if(start > end) {
			return -1;
		}

		int mid = (start + end) / 2;

		if(inputs[mid] < key) {
			return binarySearch(key, inputs, mid+1, end);
		} else if(inputs[mid] > key) {
			return binarySearch(key, inputs, start, mid-1);
		} else {
			return mid;
		}
	}
}