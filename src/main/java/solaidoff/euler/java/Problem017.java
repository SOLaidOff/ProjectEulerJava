package solaidoff.euler.java;

import solaidoff.euler.java.helper.EulerBasicMath;

/**
 * https://projecteuler.net/problem=17
 * 
 * Number letter counts
 * 
 * Problem 17
 * 
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out
 * numbers is in compliance with British usage.
 */
public class Problem017 extends EulerProblem {
    public static final int LETTERS_IN_ONE = 3;
    public static final int LETTERS_IN_TWO = 3;
    public static final int LETTERS_IN_THREE = 5;
    public static final int LETTERS_IN_FOUR = 4;
    public static final int LETTERS_IN_FIVE = 4;
    public static final int LETTERS_IN_SIX = 3;
    public static final int LETTERS_IN_SEVEN = 5;
    public static final int LETTERS_IN_EIGHT = 5;
    public static final int LETTERS_IN_NINE = 4;

    public static final int LETTERS_IN_TEN = 3;
    public static final int LETTERS_IN_ELEVEN = 6;
    public static final int LETTERS_IN_TWELVE = 6;
    public static final int LETTERS_IN_THIRTEEN = 8;
    public static final int LETTERS_IN_FOURTEEN = 8;
    public static final int LETTERS_IN_FIFTEEN = 7;
    public static final int LETTERS_IN_SIXTEEN = 7;
    public static final int LETTERS_IN_SEVENTEEN = 9;
    public static final int LETTERS_IN_EIGHTEEN = 8;
    public static final int LETTERS_IN_NINETEEN = 8;

    public static final int LETTERS_IN_TWENTY = 6;
    public static final int LETTERS_IN_THIRTY = 6;
    public static final int LETTERS_IN_FORTY = 5;
    public static final int LETTERS_IN_FIFTY = 5;
    public static final int LETTERS_IN_SIXTY = 5;
    public static final int LETTERS_IN_SEVENTY = 7;
    public static final int LETTERS_IN_EIGHTY = 6;
    public static final int LETTERS_IN_NINETY = 6;

    public static final int LETTERS_IN_HUNDRED = 7;
    public static final int LETTERS_IN_AND = 3;

    public static final int LETTERS_IN_ONE_THOUSAND = 11;
    
    public static final int FLOOR = 1;
    public static final int CEILING = 1000;

    @Override
    public long doProblem() {
        int lettersUsed = 0;

        for (int i = FLOOR; i < CEILING; i++) {
            lettersUsed += processNumber(i);
        }

        // Didn't bother coding for 1000 since it's the only four-digit number and basically a special case
        lettersUsed += LETTERS_IN_ONE_THOUSAND;

        return lettersUsed;
    }
    
    private int processNumber(int i) {
        // Two basic cases: 1-99 or 101-999
        
        // 1-99
        if (i < 100) {
            return process1To100(i);
        }

        // 100-999
        int hundredsPlace = i / 100;
        
        // Special case: exact hundred (e.g. 100, 300, 800)
        if(EulerBasicMath.divisibleBy(i, 100)) {
            return getSimpleDigitLetterCount(hundredsPlace) + LETTERS_IN_HUNDRED;
        }
        
        // "Regular" hundred case (i.e. n hundred and m)
        return getSimpleDigitLetterCount(hundredsPlace) + LETTERS_IN_HUNDRED + LETTERS_IN_AND + process1To100(i % 100);
    }

    private int process1To100(int i) {
        // 10-19 are special cases, because English
        switch (i) {
            case 10:
                return LETTERS_IN_TEN;
            case 11:
                return LETTERS_IN_ELEVEN;
            case 12:
                return LETTERS_IN_TWELVE;
            case 13:
                return LETTERS_IN_THIRTEEN;
            case 14:
                return LETTERS_IN_FOURTEEN;
            case 15:
                return LETTERS_IN_FIFTEEN;
            case 16:
                return LETTERS_IN_SIXTEEN;
            case 17:
                return LETTERS_IN_SEVENTEEN;
            case 18:
                return LETTERS_IN_EIGHTEEN;
            case 19:
                return LETTERS_IN_NINETEEN;
            default:
                break;
        }

        // Numbers other than 10-19 can be assembled (e.g. five, twenty-three, ninety-two, seventy)
        int onesPlace = i % 10;
        int tensPlace = i / 10;

        int lettersUsed = 0;

        // Ones place
        lettersUsed += getSimpleDigitLetterCount(onesPlace);

        // Tens place
        switch (tensPlace) {
            case 0:
                break;
            case 2:
                lettersUsed += LETTERS_IN_TWENTY;
                break;
            case 3:
                lettersUsed += LETTERS_IN_THIRTY;
                break;
            case 4:
                lettersUsed += LETTERS_IN_FORTY;
                break;
            case 5:
                lettersUsed += LETTERS_IN_FIFTY;
                break;
            case 6:
                lettersUsed += LETTERS_IN_SIXTY;
                break;
            case 7:
                lettersUsed += LETTERS_IN_SEVENTY;
                break;
            case 8:
                lettersUsed += LETTERS_IN_EIGHTY;
                break;
            case 9:
                lettersUsed += LETTERS_IN_NINETY;
                break;
            default:
                break;
        }

        return lettersUsed;
    }
    
    private int getSimpleDigitLetterCount(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return LETTERS_IN_ONE;
            case 2:
                return LETTERS_IN_TWO;
            case 3:
                return LETTERS_IN_THREE;
            case 4:
                return LETTERS_IN_FOUR;
            case 5:
                return LETTERS_IN_FIVE;
            case 6:
                return LETTERS_IN_SIX;
            case 7:
                return LETTERS_IN_SEVEN;
            case 8:
                return LETTERS_IN_EIGHT;
            case 9:
                return LETTERS_IN_NINE;
            default:
                assert i >= 0 && i <= 9 : "Method for single digits";
                return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem017().doProblem());
    }
}
