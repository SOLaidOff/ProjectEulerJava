package solaidoff.euler.java;

/**
 * https://projecteuler.net/problem=15
 * 
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 * 
 * [https://projecteuler.net/project/images/p015.gif]
 * 
 * How many such routes are there through a 20×20 grid?
 */
public class Problem015 extends EulerProblem {
    public static final int HEIGHT = 20;
    public static final int WIDTH = 20;

    @Override
    public long doProblem() {
        // # of paths to a given corner = # of paths to corner above it + # of paths to corner left of it
        // This is kinda like a DFS or BFS

        long[][] vertices = new long[HEIGHT + 1][WIDTH + 1];
        vertices[0][0] = 1; // Initialize: by definition, there's exactly one way to start off, which is at the top left corner

        // In 2x2 example grid: vertices run from (0,0) to 2,2 and there are a total of 5 diagonals
        //
        // @formatter:off
        // Vertices: (0,0)   (0,1)/(1,0)   (0,2)/(1,1)/(2,0)   (1,2)/(2,1)   (2,2)
        // Diagonal numbers: 0-4
        // Note that i + j = diagonal
        // @formatter:on

        // Process each diagonal in order
        for (int diagonal = 0; diagonal < HEIGHT + WIDTH + 1; diagonal++) {
            // Pick out the vertices that are on the given diagonal
            for (int i = 0; i <= diagonal; i++) {
                int j = diagonal - i;

                if (i + 1 <= HEIGHT && j <= WIDTH) {
                    vertices[i + 1][j] += vertices[i][j];
                }
                if (j + 1 <= WIDTH && i <= HEIGHT) {
                    vertices[i][j + 1] += vertices[i][j];
                }
            }
        }

        return vertices[HEIGHT][WIDTH];
    }

    public static void main(String[] args) {
        System.out.println(new Problem015().doProblem());
    }
}
