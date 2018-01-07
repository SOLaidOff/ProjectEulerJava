package solaidoff.euler.java;

import java.util.HashMap;
import java.util.Map;

import solaidoff.euler.java.helper.EulerBasicMath;

/**
 * https://projecteuler.net/problem=14
 * 
 * Longest Collatz sequence
 * 
 * Problem 14
 * 
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following sequence:
 * 
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * 
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class Problem014 extends EulerProblem {
    public static final int CEILING = 1000000;
    
    // Weirdly, this doesn't work with ints, even though MAX_INTEGER is over 2 billion. Causes a StackOverflowError.
    // Something flipping over to a negative value, maybe?
    
    private long longestCollatzChainSoFar = 0;
    private long longestCollatzStartingNumberSoFar = -1;
    
    private Map<Long, Long> knownCollatzLengths;
    
    @Override
    public long doProblem() {
        knownCollatzLengths = new HashMap<Long, Long>();
        
        for(long i = 1; i < CEILING; i++) {
            long collatzLength = collatz(i);
            
            if(collatzLength > longestCollatzChainSoFar) {
                longestCollatzChainSoFar = collatzLength;
                longestCollatzStartingNumberSoFar = i;
            }
        }
        
        return longestCollatzStartingNumberSoFar;
    }
    
    private long collatz(long term) {
        /*
         * Recursive method to find Collatz chain length.
         * 
         * If the term has been seen before, the length is returned.
         * Else, the length is incremented and added to the length of the next term's chain.
         * 
         * <em>NB: assumes that all chains do finish at 1.</em>
         */
        
        if(term == 1) {
            return 1;
        }
        
        if(knownCollatzLengths.containsKey(term)) {
            return knownCollatzLengths.get(term);
        }
        
        long collatzLength;
        if(EulerBasicMath.isEven(term)) {
            collatzLength = 1 + collatz(term / 2);
        } else {
            collatzLength = 1 + collatz(3 * term + 1);
        }
        knownCollatzLengths.put(term, collatzLength);
        
        return collatzLength;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem014().doProblem());
    }
}
