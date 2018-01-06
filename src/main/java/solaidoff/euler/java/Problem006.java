package solaidoff.euler.java;

/**
 * https://projecteuler.net/problem=6
 * 
 * Sum square difference
 * 
 * Problem 6
 * 
 * The sum of the squares of the first ten natural numbers is,
 * 
 * 1^2 + 2^2 + ... + 10^2 = 385
 * 
 * The square of the sum of the first ten natural numbers is,
 * 
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * 
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class Problem006 extends EulerProblem {
    public long doProblem() {
        int sumOfSquares = 0;
        for(int i = 1; i <= 100; i++) {
            sumOfSquares += i * i;
        }
        
        int sums = 0;
        for(int i = 1; i <= 100; i++) {
            sums += i;
        }
        
        int squareOfSums = sums * sums;
        
        return squareOfSums - sumOfSquares;
    }

    public static void main(String[] args) {
        System.out.println(new Problem006().doProblem());
    }
}
