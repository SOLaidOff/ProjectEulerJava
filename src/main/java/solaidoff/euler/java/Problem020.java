package solaidoff.euler.java;

import java.math.BigInteger;

/**
 * https://projecteuler.net/problem=20
 * 
 * Factorial digit sum
 * 
 * Problem 20
 * 
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * 
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 */
public class Problem020 extends EulerProblem {
    public static final int CEILING = 100;
    
    private BigInteger factorial = BigInteger.ONE;
    int digitSum = 0;
    
    @Override
    public long doProblem() {
        // Calculate the factorial
        for(int i = 2; i <= CEILING; i++) {
            BigInteger iObj = new BigInteger(Integer.toString(i));
            factorial = factorial.multiply(iObj);
        }
        
        String factorialAsString = factorial.toString();
        int factorialLength = factorialAsString.length();
        for(int i = 0; i < factorialLength; i++) {
            digitSum += Integer.valueOf(factorialAsString.substring(i, i + 1));
        }
        
        return digitSum;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem020().doProblem());
    }
}
