package solaidoff.euler.java.helper;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * A helper class that identifies and stores prime numbers. It works by checking small natural numbers for primeness (specifically, it starts with 2, which is by definition the first prime number) and
 * building on the results to check increasingly larger numbers.
 */
public class EulerPrime {
    private static LinkedList<Long> primes;
    private static int primesFound;
    private static long highestNumberChecked;

    static {
        // Cheap micro-optimization from initial working version: load first two prime numbers (2 and 3) into list from the start
        // This allows writing code to check only odd numbers from here on out
        primes = new LinkedList<Long>();
        primes.add(2l);
        primes.add(3l);
        primesFound = 2;
        highestNumberChecked = 3;
    }

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
        if (candidate > highestNumberChecked) {
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
         * <em>Key assumption: all lower natural numbers have already been checked for primeness</em> (At least, the odds; the evens are obviously non-prime, except for the special case 2, which was
         * handled separately.)
         */

        long candidate = highestNumberChecked + 2;

        // Check candidate against all known primes; if divisible by any, it's composite
        for (Long i : primes) {
            // Second micro-optimization from initial working version: don't waste time if divisor is too large to divide evenly (i.e. greater than half)
            // (Assumes ascending order of primes; OK, because enhanced for loop is identical to using traditional Iterator per JLS 14.14.2)
            if (i > ((candidate + 1) / 2)) {
                break;
            }

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

    /**
     * Find all divisors of a given number.
     * 
     * @param target
     * @return
     */
    public static Set<Long> findDivisors(long target) {
        // Credit to ithenoob at https://stackoverflow.com/a/18282191 for a speed optimization for this over an earlier version
        // (and a different earlier attempt that tried to be more clever but ultimately failed because it was O(n^3))
        Set<Long> divisors = new HashSet<Long>();
        
        for (long potentialDivisor = 1; potentialDivisor * potentialDivisor <= target; potentialDivisor++) {
            if (target % potentialDivisor == 0) {
                divisors.add(potentialDivisor);
                divisors.add(target / potentialDivisor);
            }
        }
        
        return divisors;
    }
}
