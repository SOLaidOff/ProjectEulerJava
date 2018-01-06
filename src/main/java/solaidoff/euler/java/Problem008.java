package solaidoff.euler.java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://projecteuler.net/problem=8
 * 
 * Largest product in a series
 * 
 * Problem 8 
 * 
 * The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
 * 
 * @formatter:off
 * 73167176531330624919225119674426574742355349194934
 * 96983520312774506326239578318016984801869478851843
 * 85861560789112949495459501737958331952853208805511
 * 12540698747158523863050715693290963295227443043557
 * 66896648950445244523161731856403098711121722383113
 * 62229893423380308135336276614282806444486645238749
 * 30358907296290491560440772390713810515859307960866
 * 70172427121883998797908792274921901699720888093776
 * 65727333001053367881220235421809751254540594752243
 * 52584907711670556013604839586446706324415722155397
 * 53697817977846174064955149290862569321978468622482
 * 83972241375657056057490261407972968652414535100474
 * 82166370484403199890008895243450658541227588666881
 * 16427171479924442928230863465674813919123162824586
 * 17866458359124566529476545682848912883142607690042
 * 24219022671055626321111109370544217506941658960408
 * 07198403850962455444362981230987879927244284909188
 * 84580156166097919133875499200524063689912560717606
 * 05886116467109405077541002256983155200055935729725
 * 71636269561882670428252483600823257530420752963450
 * @formatter:on
 * 
 * Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
 */
public class Problem008 extends EulerProblem {
    public static final String INPUT = setupInput();
    public static final int INPUT_LENGTH = 1000;
    public static final int ADJACENT_DIGIT_COUNT = 13;
    
    private int currentInputPosition;
    private Queue<Integer> currentDigits;
    private long maxProductSoFar;
    
    public static String setupInput() {
        StringBuilder input = new StringBuilder();
        input.append("73167176531330624919225119674426574742355349194934");
        input.append("96983520312774506326239578318016984801869478851843");
        input.append("85861560789112949495459501737958331952853208805511");
        input.append("12540698747158523863050715693290963295227443043557");
        input.append("66896648950445244523161731856403098711121722383113");
        input.append("62229893423380308135336276614282806444486645238749");
        input.append("30358907296290491560440772390713810515859307960866");
        input.append("70172427121883998797908792274921901699720888093776");
        input.append("65727333001053367881220235421809751254540594752243");
        input.append("52584907711670556013604839586446706324415722155397");
        input.append("53697817977846174064955149290862569321978468622482");
        input.append("83972241375657056057490261407972968652414535100474");
        input.append("82166370484403199890008895243450658541227588666881");
        input.append("16427171479924442928230863465674813919123162824586");
        input.append("17866458359124566529476545682848912883142607690042");
        input.append("24219022671055626321111109370544217506941658960408");
        input.append("07198403850962455444362981230987879927244284909188");
        input.append("84580156166097919133875499200524063689912560717606");
        input.append("05886116467109405077541002256983155200055935729725");
        input.append("71636269561882670428252483600823257530420752963450");
        
        return input.toString();
    }
    
    public long doProblem() {
        startup();
        
        while(currentInputPosition < INPUT_LENGTH) {
            testNextDigit();
        }
        
        return maxProductSoFar;
    }
    
    private void startup() {
        currentDigits = new LinkedList<Integer>();

        // Beginning is a special case, we need to grab ADJACENT_DIGIT_COUNT (13) digits at once
        for(int i = 0; i < ADJACENT_DIGIT_COUNT; i++) {
            int nextDigit = obtainNextDigit();
            currentDigits.add(nextDigit);
            maxProductSoFar *= nextDigit;
        }
    }
    
    private void testNextDigit() {
        // After we've gotten started, we grab one digit at a time and see how it changes things from the previous state
        
        // There might be room here for micro-optimizations like skipping ahead on 0 or a new digit less than a removed one, but it's probably not worth
        // the time it would take to code... maybe consider it for the planned refactor

        int nextDigit = obtainNextDigit();
        currentDigits.add(nextDigit);
        currentDigits.remove();
        
        long currentProduct = 1;
        for(Integer digit : currentDigits) {
            currentProduct *= digit.intValue();
        }
        
        if(currentProduct > maxProductSoFar) {
            maxProductSoFar = currentProduct;
        }
    }
    
    private int obtainNextDigit() {
        int nextDigit = Integer.parseInt(INPUT.substring(currentInputPosition, currentInputPosition + 1));
        currentInputPosition++;
        
        return nextDigit;
    }

    public static void main(String[] args) {
        System.out.println(new Problem008().doProblem());
    }
}
