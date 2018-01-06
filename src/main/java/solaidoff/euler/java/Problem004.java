package solaidoff.euler.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * https://projecteuler.net/problem=4
 * 
 * Largest palindrome product
 * 
 * Problem 4
 * 
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem004 extends EulerProblem {
    public static final int LARGEST_THREE_DIGIT_NUM = 999;
    public static final int SMALLEST_THREE_DIGIT_NUM = 100;
    
    public long doProblem() {
        // Brute force is inelegant, but there aren't that many three-digit numbers
        
        // Come up with all of the potential three-digit-number products
        List<Integer> products = new ArrayList<Integer>();
        for(int i = LARGEST_THREE_DIGIT_NUM; i >= SMALLEST_THREE_DIGIT_NUM; i--) {
            for(int j = LARGEST_THREE_DIGIT_NUM; j >= SMALLEST_THREE_DIGIT_NUM; j--) {
                products.add(i * j);
            }
        }
        
        // Arrange the products in a greatest-first list
        Collections.sort(products);
        Collections.reverse(products);
        
        // Now that the products are sorted, the first palindrome should be the answer
        ListIterator<Integer> iterator = products.listIterator();
        Integer current = null;
        while(iterator.hasNext()) {
            current = iterator.next();
            if(isPalindrome(current)) {
                return current.intValue();
            }
        }
        
        return -1; // Should never occur. Not exactly production-grade code, but sufficient to solve this problem.
    }
    
    // Note to self, keep this in mind for planned refactoring stage (note to others: see README)
    /**
     * Clip off each individual digit and put it into a list.
     * If the list is the same as its reverse, it's a palindrome.
     */
    private boolean isPalindrome(Integer currentAsObj) {
        int current = currentAsObj.intValue();
        
        if(current == 0) {
            return true; // Technically true, though probably an error in the context of this particular question
        }

        List<Integer> digitsA = new ArrayList<Integer>();
        List<Integer> digitsB = new ArrayList<Integer>();
        
        while(current != 0) {
            digitsA.add(current % 10);
            digitsB.add(current % 10);
            current /= 10;
        }
        
        Collections.reverse(digitsB);
        
        return digitsA.equals(digitsB);
    }

    public static void main(String[] args) {
        System.out.println(new Problem004().doProblem());
    }
}
