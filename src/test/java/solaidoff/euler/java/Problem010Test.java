package solaidoff.euler.java;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Problem010Test extends EulerProblemTest {
    @Test
    @Disabled ("Technically finishes in under 60 seconds, but only by 0.1 second. Fix later, but disable for now to avoid wasting time.")
    public void test010() {
        testProblem(new Problem010(), 142913828922l);
    }
}
