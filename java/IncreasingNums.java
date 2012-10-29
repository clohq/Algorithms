public class IncreasingNums {
	
	//public static int a[] = {2,3,1,2,6};
	//public static int a[] = {2,3,1,6,2};
	//public static int a[] = {4,3,1,6,2,4};
	//public static int a[] = {4,9,8,7,6,5,4,5,6};
	public static int a[] = {4,9,8,7,6,5,4,4,3,2,1,6};

	public static void main(String[] args) {

		int n = a.length;

		int i1 = 0, i2 = 1, i3 = 2;

		int min1 = -1;

		boolean found = false;

		while( i1 < n && i2 < n && i3 < n ) {
			if (a[i1] < a[i2] && a[i2] < a[i3]) {
				found = true;
				break;
			}

			if( a[i1] >= a[i2]) {
				i1 = i2;
				i2 = i1 + 1;
				i3 = i2 + 1;
			} else if( a[i1] >= a[i3]) {
				if( min1 != -1 && a[min1] < a[i3]) {
					i1 = min1;
					i2 = i3;
					i3 = i2 + 1;
					min1 = -1;
				} else {
					min1 = i3;
					i3++;
				}
			} else if( a[i2] >= a[i3]) {
				i2 = i3;
				i3 = i2 + 1;
			}
		}

		if(found) {
			System.out.println(a[i1]);
			System.out.println(a[i2]);
			System.out.println(a[i3]);
		} else {
			System.out.println("Not Found");	
		}
	}
}