package solaidoff.euler.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://projecteuler.net/problem=67
 * 
 * Maximum path sum II
 * 
 * Problem 67
 * 
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
 * 
 * @formatter:off
 *    <span class="color: red;">3</span>
 *   <span class="color: red;">7</span> 4
 *  2 <span class="color: red;">4</span> 6
 * 8 5 <span class="color: red;">9</span> 3
 * @formatter:on
 * 
 * That is, 3 + 7 + 4 + 9 = 23.
 * 
 * Find the maximum total from top to bottom in <a href="https://projecteuler.net/project/resources/p067_triangle.txt">triangle.txt</a>
 * (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.
 * 
 * NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this problem, as there are 2^99
 * altogether! If you could check one trillion (10^12) routes every second it would take over twenty billion years to check them all. There
 * is an efficient algorithm to solve it. ;o)
 */
public class Problem067 extends EulerProblem {
    // Code mostly copy-pasted from Problem018; these classes are being designed for modification (i.e. running the same problem with different
    // parameters), not reuse as libraries
    //
    // Problem 18 algorithm had decent speed at 20 rows of input, but took unreasonably long even at 25 rows, let alone 100
    // Issue was a huge amount of unnecessary visiting of most nodes (applying BST-esque walking to non-BST-shaped tree)

    public static final int INPUT_ROW_COUNT = 100;

    private String[] input;
    private P67Node root;
    private List<List<P67Node>> treeRows;
    private List<P67Node> leafRow;

    int debugCounter = 0;

    @Override
    public long doProblem() {
        setUpInput();

        convertInputToTree();

        walkTree();

        return findMaxTotal();
    }

    private void setUpInput() {
        input = new String[INPUT_ROW_COUNT];

        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new FileReader("resources/p067_triangle.txt"));
            fileScanner.useDelimiter("\n");

            for (int i = 0; i < INPUT_ROW_COUNT; i++) {
                input[i] = fileScanner.next();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileScanner != null) {
                fileScanner.close();
            }
        }
    }

    private void convertInputToTree() {
        treeRows = new ArrayList<List<P67Node>>();

        // Would prefer to do something like "new List<P67Node>[INPUT_ROW_COUNT]" but that's invalid
        // Instead, that would require "(List<P67Node>) new List[INPUT_ROW_COUNT]"; the exact kind of thing generics were supposed to fix
        // See https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html#createArrays

        List<P67Node> previousRow = new ArrayList<P67Node>();
        List<P67Node> currentRow = null;

        // First row is a special case, do it manually to get things started
        root = new P67Node(Integer.valueOf(input[0]));
        root.maxSum = root.value;
        previousRow.add(root);

        // Do remaining rows iteratively
        for (int i = 1; i < input.length; i++) {
            treeRows.add(previousRow);

            Scanner scanner = null;
            try {
                // Read in the current row
                scanner = new Scanner(input[i]);
                currentRow = new ArrayList<P67Node>();
                while (scanner.hasNextInt()) {
                    currentRow.add(new P67Node(scanner.nextInt()));
                }
            } finally {
                if (scanner != null) {
                    scanner.close();
                }
            }

            // Now that the current row exists, make the left and right references from the previous row point correctly
            int prevRowSize = previousRow.size();
            for (int j = 0; j < prevRowSize; j++) {
                P67Node prevRowNode = previousRow.get(j);
                prevRowNode.leftChild = currentRow.get(j);
                prevRowNode.rightChild = currentRow.get(j + 1);
            }

            // For problem 67, add back references to parents, too
            int curRowSize = currentRow.size();
            // Special cases: first node has only right parent; last node has only left parent
            currentRow.get(0).rightParent = previousRow.get(0);
            currentRow.get(curRowSize - 1).leftParent = previousRow.get(prevRowSize - 1);
            // Regular cases
            for (int j = 1; j < curRowSize - 1; j++) {
                P67Node curRowNode = currentRow.get(j);
                curRowNode.leftParent = previousRow.get(j - 1);
                curRowNode.rightParent = previousRow.get(j);
            }

            // Prep for next iteration
            previousRow = currentRow;
        }

        assert currentRow != null : "Read failure";
        treeRows.add(currentRow);
        leafRow = currentRow;
    }

    private void walkTree() {
        for (List<P67Node> row : treeRows) {
            for (P67Node node : row) {
                long parentMax = calcParentMax(node);
                node.maxSum = node.value + parentMax;
            }
        }
    }

    private long calcParentMax(P67Node node) {
        long leftMax = (node.leftParent == null) ? 0 : node.leftParent.maxSum;
        long rightMax = (node.rightParent == null) ? 0 : node.rightParent.maxSum;

        return Math.max(leftMax, rightMax);
    }

    private long findMaxTotal() {
        long highestMax = -1;
        for (P67Node node : leafRow) {
            if (node.maxSum > highestMax) {
                highestMax = node.maxSum;
            }
        }

        return highestMax;
    }

    public static void main(String[] args) {
        System.out.println(new Problem067().doProblem());
    }

    public class P67Node {
        P67Node leftChild = null;
        P67Node rightChild = null;
        P67Node leftParent = null;
        P67Node rightParent = null;
        int value;
        long maxSum;

        public P67Node(int value) {
            this.value = value;
        }
    }
}
