/*

1. Given a chess board of n*n, a horse placed at i,j now with m moves what is the probability that the horse remains inside the board. Write the code.

*/

public class HorseProbability {
	public static void main(String[] args) {

		int numOfMoves = 1;
		int chessSize = 8;
		int horseI = 6;
		int horseJ = 6;

		System.out.println(findHorseProbability(chessSize, horseI, horseJ, numOfMoves));
	}

	public static double findHorseProbability(int chessSize, int horseI, int horseJ, int numberofMoves) {

		if(horseI >= chessSize || horseJ >= chessSize || horseI < 0 || horseJ < 0) {
			return 0;
		}

		if(numberofMoves == 0) {
			return 1;
		}

		return 

		(1.0/8) * findHorseProbability(chessSize, horseI + 1, horseJ + 2, numberofMoves -1) +
		(1.0/8) * findHorseProbability(chessSize, horseI + 1, horseJ - 2, numberofMoves -1) +
		(1.0/8) * findHorseProbability(chessSize, horseI - 1, horseJ + 2, numberofMoves -1) +
		(1.0/8) * findHorseProbability(chessSize, horseI - 1, horseJ - 2, numberofMoves -1) +
		(1.0/8) * findHorseProbability(chessSize, horseI + 2, horseJ + 1, numberofMoves -1) +
		(1.0/8) * findHorseProbability(chessSize, horseI + 2, horseJ - 1, numberofMoves -1) +
		(1.0/8) * findHorseProbability(chessSize, horseI - 2, horseJ + 1, numberofMoves -1) +
		(1.0/8) * findHorseProbability(chessSize, horseI - 2, horseJ - 1, numberofMoves -1);

	}
}