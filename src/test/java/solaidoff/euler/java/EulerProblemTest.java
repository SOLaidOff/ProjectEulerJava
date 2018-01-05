package solaidoff.euler.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class EulerProblemTest {
    /*
     * According to https://projecteuler.net/about,
     * 
     * "Each problem has been designed according to a 'one-minute rule', which means that although it may take several hours to design a successful algorithm with
     * more difficult problems, an efficient implementation will allow a solution to be obtained on a modestly powered computer in less than one minute."
     */
    
    public static int ONE_MINUTE_IN_MILLIS = 60 * 1000;
    
    public void testProblem(EulerProblem problem, int correctAnswer) {
        long startTime = System.currentTimeMillis();
        int calculatedAnswer = problem.doProblem();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        
        assertEquals(calculatedAnswer, correctAnswer);
        assertTrue(duration < ONE_MINUTE_IN_MILLIS);

        System.out.println("Test of " + problem.getClass() +" took " + duration + " milliseconds.");
    }
}
