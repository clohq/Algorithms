/*

Add without using + sign

*/

public class AddWithoutPlus {
	public static void main(String[] args) {
		int result = add(99,99);
		System.out.println(result);
	}

	public static int add(int x, int y) {
		int carry = 0;
		int result = 0;
		int i =0;

		for(i =0 ; i<32; i++) {
			int xbit = (x >> i) & 1;
			int ybit = (y >> i) & 1;

			result |= (xbit ^ ybit) ^ carry << i;
			carry = (xbit & ybit) | (carry & xbit) | (carry & ybit);
		}

		return result;
	}
}