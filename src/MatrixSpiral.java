/*
Print a Matrix as a spiral
*/

public class MatrixSpiral {
	public static void main(String args[]) {
		int[][] matrix = {
							{1, 2, 3},
							{4, 5, 6},
							{7, 8, 9}
						 };

		printSpiral(matrix);
	}

	public static void printSpiral(int[][] array) {
		int starti = 0;
		int startj = 0;
		int endi = array.length-1;
		int endj = array.length-1;
		int i = starti;
		int j = startj;
		int x = 1;
		int y = 0;

		System.out.println(array[i][j]);

		while(starti != endi || startj != endj) {

			if(x == 1) {
				j++;
				if(j > endj) {
					x = 0;
					y = 1;

					starti++;
					i = starti;
					j = endj;
				}
			} else if(y == 1) {
				i++;
				if(i > endi) {
					x = -1;
					y = 0;

					endj--;
					j = endj;
					i = endi;
				}
			} else if(x == -1) {
				j--;
				if(j < startj) {
					x = 0;
					y = -1;

					endi--;
					i = endi;
					j = startj;
				}
			} else if(y == -1) {
				i--;
				if(i < starti) {
					x = 1;
					y = 0;

					startj++;
					j = startj;
					i = starti;
				}
			}

			System.out.println(array[i][j]);

		}
	}
}