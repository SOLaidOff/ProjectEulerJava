package solaidoff.euler.java;

/**
 * https://projecteuler.net/problem=3
 * 
 * Largest prime factor
 * 
 * Problem 3
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem003 extends EulerProblem {
    public long doProblem() {
        long startingNumber = 600851475143l;
        
        for(int i = 2; i < Integer.MAX_VALUE; i++) {
            while(startingNumber % i == 0) {
                startingNumber /= i;
            }
            
            if(startingNumber == 1) {
                return i;
            }
        }
        
        return -1; // Should never occur. Not exactly production-grade code, but sufficient to solve this problem.
    }

    public static void main(String[] args) {
        System.out.println(new Problem003().doProblem());
    }
}