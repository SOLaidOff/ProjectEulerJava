package solaidoff.euler.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://projecteuler.net/problem=18
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
 * Find the maximum total from top to bottom of the triangle below:
 * 
 * @formatter:off
 *               75
 *              95 64
 *             17 47 82
 *            18 35 87 10
 *           20 04 82 47 65
 *          19 01 23 75 03 34
 *         88 02 77 73 07 63 67
 *        99 65 04 28 06 16 70 92
 *       41 41 26 56 83 40 80 70 33
 *      41 48 72 33 47 32 37 16 94 29
 *     53 71 44 65 25 43 91 52 97 51 14
 *    70 11 33 28 77 73 17 78 39 68 17 57
 *   91 71 52 38 17 14 91 43 58 50 27 29 48
 *  63 66 04 68 89 53 67 30 73 16 69 87 40 31
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 * @formatter:on
 *
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with
 * a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
 */
public class Problem018 extends EulerProblem {
    private String[] input;
    private P18Node root;
    private List<P18Node> leafRow;

    @Override
    public long doProblem() {
        setUpInput();

        convertInputToTree();

        walkTree(root, 0);

        return findMaxTotal();
    }

    @SuppressWarnings("unused")
    private void setUpInputExample() {
        input = new String[] { "3", "7 4", "2 4 6", "8 5 9 3" };
    }

    private void setUpInput() {
        input = new String[] {
                // @formatter:off
                "75",
                "95 64",
                "17 47 82",
                "18 35 87 10",
                "20 04 82 47 65",
                "19 01 23 75 03 34",
                "88 02 77 73 07 63 67",
                "99 65 04 28 06 16 70 92",
                "41 41 26 56 83 40 80 70 33",
                "41 48 72 33 47 32 37 16 94 29",
                "53 71 44 65 25 43 91 52 97 51 14",
                "70 11 33 28 77 73 17 78 39 68 17 57",
                "91 71 52 38 17 14 91 43 58 50 27 29 48",
                "63 66 04 68 89 53 67 30 73 16 69 87 40 31",
                "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23"
                // @formatter:on
        };
    }

    private void convertInputToTree() {
        List<P18Node> previousRow = new ArrayList<P18Node>();
        List<P18Node> currentRow = null;

        // First row is a special case, do it manually to get things started
        root = new P18Node(Integer.valueOf(input[0]));
        root.maxSum = root.value;
        previousRow.add(root);

        // Do remaining rows iteratively
        for (int i = 1; i < input.length; i++) {
            Scanner scanner = null;
            try {
                // Read in the current row
                scanner = new Scanner(input[i]);
                currentRow = new ArrayList<P18Node>();
                while (scanner.hasNextInt()) {
                    currentRow.add(new P18Node(scanner.nextInt()));
                }
            } finally {
                if (scanner != null) {
                    scanner.close();
                }
            }

            // Now that the current row exists, make the left and right references from the previous row point correctly
            int prevRowSize = previousRow.size();
            for (int j = 0; j < prevRowSize; j++) {
                P18Node prevRowNode = previousRow.get(j);
                prevRowNode.left = currentRow.get(j);
                prevRowNode.right = currentRow.get(j + 1);
            }

            // Prep for next iteration
            previousRow = currentRow;
        }

        assert currentRow != null : "Read failure";
        leafRow = currentRow;
    }

    private void walkTree(P18Node node, int parentMax) {
        if (node == null) {
            return;
        }

        if (node.value + parentMax > node.maxSum) {
            node.maxSum = node.value + parentMax;
        }

        walkTree(node.left, node.maxSum);
        walkTree(node.right, node.maxSum);
    }

    private int findMaxTotal() {
        int highestMax = -1;
        for (P18Node node : leafRow) {
            if (node.maxSum > highestMax) {
                highestMax = node.maxSum;
            }
        }

        return highestMax;
    }

    public static void main(String[] args) {
        System.out.println(new Problem018().doProblem());
    }

    public class P18Node {
        P18Node left = null;
        P18Node right = null;
        int value;
        int maxSum;

        public P18Node(int value) {
            this.value = value;
        }
    }
}
