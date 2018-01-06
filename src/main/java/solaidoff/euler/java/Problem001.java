package solaidoff.euler.java;

import solaidoff.euler.java.helper.EulerBasicMath;

/**
 * https://projecteuler.net/problem=1
 * 
 * Title: Multiples of 3 and 5
 * 
 * Problem 1
 * 
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem001 extends EulerProblem {
    public static final int CEILING = 1000;
    
    public long doProblem() {
        int sum = 0;
        
        for(int i = 0; i < CEILING; i++) {
            if(EulerBasicMath.divisibleBy(i, 3) || EulerBasicMath.divisibleBy(i, 5)) {
                sum += i;
            }
        }
        
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Problem001().doProblem());
    }
}
