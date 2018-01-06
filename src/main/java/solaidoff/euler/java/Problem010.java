package solaidoff.euler.java;

import java.util.Iterator;

import solaidoff.euler.java.helper.EulerPrime;

/**
 * https://projecteuler.net/problem=10
 * 
 * Summation of primes
 * 
 * Problem 10
 * 
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 */
public class Problem010 extends EulerProblem {
    // TODO: This outputs correct answer, but far too slowly (almost two minutes). A quick test confirms the problem is in the EulerPrime code.
    public static final int CEILING = 2000000;
    
    public long doProblem() {
        EulerPrime.findPrimesUpToValue(CEILING);
        
        Iterator<Long> primeIter = EulerPrime.getPrimes();
        long sum = 0;
        while(primeIter.hasNext()) {
            sum += primeIter.next();
        }
        
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Problem010().doProblem());
    }
}
