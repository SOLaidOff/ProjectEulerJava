package solaidoff.euler.java;

import java.util.Set;

import solaidoff.euler.java.helper.EulerPrime;

/**
 * https://projecteuler.net/problem=21
 * 
 * Amicable numbers
 * 
 * Problem 21
 * 
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class Problem021 extends EulerProblem {
    public static final int CEILING = 10000;
    
    int[] divisorList = new int[CEILING + 1];
    int amicableSum = 0;

    @Override
    public long doProblem() {
        for(int i = 1; i <= CEILING; i++) {
            divisorList[i] = d(i);
        }
        
        for(int a = 1; a < CEILING; a++) {
            int b = divisorList[a];
            
            if(b > CEILING) {
                continue;
            }
            
            if(divisorList[b] == a && a != b) {
                // Amicable
                amicableSum += a; // b gets picked up separately
            }
        }
        
        return amicableSum;
    }
    
    private int d(int n) {
        Set<Long> divisors = EulerPrime.findDivisors(n);
        int divisorSum = 0;
        for(Long divisor : divisors) {
            divisorSum += divisor;
        }
        divisorSum -= n;
        
        return divisorSum;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem021().doProblem());
    }
}
