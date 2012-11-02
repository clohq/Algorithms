public class FindReset {
	
	public static int[] inputs = {4,5,6,7,1,2,3};

	public static void main(String args[]) {

		int length = inputs.length;

		int output = binary_find_reset(0,length-1);
		System.out.println(output);

	}

	public static int binary_find_reset(int start, int end) {
		
		if(start + 1 == end && inputs[start] > inputs[end]) {
			return inputs[end];
		}

		if(inputs[start] < inputs[end]) {
			return -1;
		}

		int mid = (start + end) / 2;

		if(inputs[start] > inputs[mid]) {
			return binary_find_reset(start, mid);
		} else {
			return binary_find_reset(mid, end);
		}
	}
}