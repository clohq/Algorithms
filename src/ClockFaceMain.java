/**
 * Created by sivragav on 7/12/16.
 * <p>
 * One of the puzzles was to create a program that would solve a problem in which you have a clock face and 12 coins (4 pennies, 4 nickles, 4 dimes) that you place one by one on the numbers of the clock face. The program has to be able to allow the most possible moves that allow you to place a coin on a number (if you place a penny on the number 1, then your next move will be on the number 2. If you place a nickle on two the next move will be on the number 7. A dime moves you 10 places)
 * Another "case study" question involving a clock, and a bunch of pennies/nickels/dimes. Problem required putting a coin on a face of the clock and moving that many steps clockwise (putting a nickel on the 12 would move you to 5, putting a penny on 5 would move you to 6). Multi-step problem where we were ultimately trying to find all of the sequence of 12 coin placements that would be "valid" (never putting a coin on a face that already has a coin on it). Don't overthink it. They took me step by step through it. They want to see if you can program on the spot. Brush up on some useful string manipulating functions in your favorite language.
 */

public class ClockFaceMain {
    public static void main(String[] args) {
        ClockFace face = new ClockFace();
        face.findSequences();
    }
}

class ClockFace {

    private final static String COIN_PENNY = "p";
    private final static int COIN_PENNY_VALUE = 1;

    private final static String COIN_NICKEL = "n";
    private final static int COIN_NICKEL_VALUE = 5;

    private final static String COIN_DIME = "d";
    private final static int COIN_DIME_VALUE = 10;

    void findSequences() {
        placeCoin("", COIN_PENNY, "000000000000", 0, 3, 4, 4);
        placeCoin("", COIN_NICKEL, "000000000000", 0, 4, 3, 4);
        placeCoin("", COIN_DIME, "000000000000", 0, 4, 4, 3);
    }

    private void placeCoin(String seq, String coin, String clockFace, int cursor, int pCount, int nCount, int dCount) {
        clockFace = clockFace.substring(0, cursor) + "1" + clockFace.substring(cursor);
        cursor += getValue(coin);
        cursor %= 12;
        int newCursor = cursor;
        String newSeq = seq + coin;

        if (pCount + nCount + dCount == 0) {
            processResult(newSeq);
        } else if (clockFace.charAt(newCursor) == '0') {
            if (pCount > 0)
                placeCoin(newSeq, COIN_PENNY, clockFace, newCursor, pCount - 1, nCount, dCount);
            if (nCount > 0)
                placeCoin(newSeq, COIN_NICKEL, clockFace, newCursor, pCount, nCount - 1, dCount);
            if (dCount > 0)
                placeCoin(newSeq, COIN_DIME, clockFace, newCursor, pCount, nCount, dCount - 1);
        }
    }

    private int getValue(String coin) {
        switch (coin) {
            case COIN_PENNY:
                return COIN_PENNY_VALUE;
            case COIN_NICKEL:
                return COIN_NICKEL_VALUE;
            case COIN_DIME:
                return COIN_DIME_VALUE;
            default:
                return 0;
        }
    }

    private void processResult(String seq) {
        System.out.println(seq);
    }
}