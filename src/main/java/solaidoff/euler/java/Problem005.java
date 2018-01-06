package solaidoff.euler.java;

/**
 * https://projecteuler.net/problem=5
 * 
 * Smallest multiple
 * 
 * Problem 5
 * 
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Problem005 extends EulerProblem {
    public long doProblem() {
        /*
         * @formatter:off
         * 
         * Two possible approaches
         * 
         * Approach 1
         * - Keep a running temporary answer variable
         * - Increase through numbers the answer needs to be divisible by (i.e. 1-20)
         * - For each, find the greatest common divisor between the running temporary answer and the divisor, then multiply the temporary answer variable
         *   by whatever portion of the divisor number remains (possibly all of it)
         * 
         * Approach 2
         * - For each number in the divisors list (i.e. 1-20), break down into prime factors
         * - For each prime factor, note which divisor has the greatest number (e.g. in the example, 8 has three 2s and 9 has two 3s and 5 has one 5)
         * - Multiply together the greatest single group of each prime factor (continuing the 1-10 example, this automatically produces a number divisible
         *   by 4 (two 2s) and 6 (one 3 and one 2))
         * 
         * @formatter:on
         */

        // Using approach 1; might be slightly easier to code, plus I suspect GCD will come up in the planned refactoring stage (see README)
        int answer = 1;

        for (int i = 2; i <= 20; i++) {
            answer *= (i / findGcd(answer, i));
        }

        return answer;
    }
    
    // Obviously inefficient. Improve in planned refactor (see README). Move to math helper class maybe.
    private int findGcd(int a, int b) {
        int bigger = (a > b) ? a : b;
        int smaller = (a < b) ? a : b;
        
        for(int i = smaller; i >= 2; i--) {
            if((smaller % i == 0) && (bigger % i == 0)) {
                return i;
            }
        }
        
        return 1; // Kinda ugly, should be included in loop above and throw exception if integers are somehow not divisible by 1... fix in refactor
    }

    public static void main(String[] args) {
        System.out.println(new Problem005().doProblem());
    }
}
