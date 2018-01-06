package solaidoff.euler.java;

import solaidoff.euler.java.helper.EulerPrime;

/**
 * https://projecteuler.net/problem=7
 * 
 * 10001st prime
 * 
 * Problem 7
 * 
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * 
 * What is the 10 001st prime number?
 */
public class Problem007 extends EulerProblem {
    public static final int CEILING = 10001;
    
    public long doProblem() {
        EulerPrime.findPrimesByQuantity(CEILING);
        
        return EulerPrime.largestPrimeFound();
    }

    public static void main(String[] args) {
        System.out.println(new Problem007().doProblem());
    }
}
