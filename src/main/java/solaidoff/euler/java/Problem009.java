package solaidoff.euler.java;

/**
 * https://projecteuler.net/problem=9
 * 
 * Special Pythagorean triplet
 * 
 * Problem 9
 * 
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * 
 * a^2 + b^2 = c^2
 * 
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * 
 * Find the product abc.
 */
public class Problem009 extends EulerProblem {
    public static final int TRIPLET_SUM = 1000;
    
    public long doProblem() {
        // Another inelegant brute force solution
        // Even when brute forcing, the for loops need SOME kind of bounds
        // The problem states that a < b < c and that a, b, and c are all natural, so the lowest possible a is 1 and the lowest possible b is 2
        // Given natural a < b < c and a + b + c = 1000, a can get up to 332 (332/333/334) while b can get up to 499 (1/499/500)
        for(int a = 1; a < 332; a++) {
            for(int b = a + 1; b < 499; b++) {
                int c = TRIPLET_SUM - a - b;
                
                if(a * a + b * b == c * c) {
                    return a * b * c;
                }
            }
        }
        
        return 1; // Again, should never be reached; not production-grade code but fine for Project Euler
    }

    public static void main(String[] args) {
        System.out.println(new Problem009().doProblem());
    }
}
