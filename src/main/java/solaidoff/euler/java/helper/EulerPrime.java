package solaidoff.euler.java.helper;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * A helper class that identifies and stores prime numbers. It works by checking small natural numbers for primeness (specifically, it starts with 2,
 * which is by definition the first prime number) and building on the results to check increasingly larger numbers.
 */
public class EulerPrime {
    private static LinkedList<Long> primes = new LinkedList<Long>();
    private static int primesFound = 0;
    private static long highestNumberChecked = 0;

    public static long largestPrimeFound() {
        return primes.peekLast();
    }

    /**
     * Checks to see whether a given number is prime or not.
     * 
     * @param candidate
     * @return
     */
    public static boolean isPrime(long candidate) {
        if (primesFound == 0 || candidate > highestNumberChecked) {
            findPrimesUpToValue(candidate);
        }

        return primes.contains(new Long(candidate));
    }

    public static Iterator<Long> getPrimes() {
        return primes.iterator();
    }

    /**
     * Calculates prime numbers, where the first prime is 2, the second is 3, the third is 5, etc., until the nth prime is found
     * 
     * @param primesToFind
     *            the total number of prime numbers to find; the n in the description above
     */
    public static void findPrimesByQuantity(long primesToFind) {
        if (primesToFind < primesFound) {
            return;
        }

        while (primesFound < primesToFind) {
            checkNextCandidateForPrimeness();
        }
    }

    /**
     * Calculates prime numbers starting from the lowest natural number and increasing until all primes up to a certain value are found
     * 
     * @param ceiling
     *            the value up to which to find primes
     */
    public static void findPrimesUpToValue(long ceiling) {
        while (highestNumberChecked < ceiling) {
            checkNextCandidateForPrimeness();
        }
    }

    private static void checkNextCandidateForPrimeness() {
        /*
         * <em>Key assumption: all lower natural numbers have already been checked for primeness</em>
         */

        long candidate = (primesFound == 0) ? 2 : highestNumberChecked + 1;

        // Check candidate against all known primes; if divisible by any, it's composite
        for (Long i : primes) {
            if (EulerBasicMath.divisibleBy(candidate, i)) {
                highestNumberChecked = candidate;
                return;
            }
        }

        // Otherwise, it's prime by definition
        primes.add(candidate);
        primesFound++;
        highestNumberChecked = candidate;
    }
}
