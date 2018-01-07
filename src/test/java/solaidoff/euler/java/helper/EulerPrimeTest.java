package solaidoff.euler.java.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class EulerPrimeTest {
    @Test
    public void testAllDivisors1() {
        Set<Long> result = EulerPrime.findDivisors(1);
        Set<Long> correct = new HashSet<Long>();
        correct.add(1L);
        assertEquals(result, correct);
    }

    @Test
    public void testAllDivisors2() {
        Set<Long> result = EulerPrime.findDivisors(2);
        Set<Long> correct = new HashSet<Long>();
        correct.add(1L);
        correct.add(2L);
        assertEquals(result, correct);
    }

    @Test
    public void testAllDivisors3() {
        Set<Long> result = EulerPrime.findDivisors(3);
        Set<Long> correct = new HashSet<Long>();
        correct.add(1L);
        correct.add(3L);
        assertEquals(result, correct);
    }

    @Test
    public void testAllDivisors28() {
        Set<Long> result = EulerPrime.findDivisors(28);
        Set<Long> correct = new HashSet<Long>();
        correct.add(1L);
        correct.add(2L);
        correct.add(4L);
        correct.add(7L);
        correct.add(14L);
        correct.add(28L);
        assertEquals(result, correct);
    }

    @Test
    public void testAllDivisors36() { // 2^2 * 3^2 and a square of a composite number
        Set<Long> result = EulerPrime.findDivisors(36);
        Set<Long> correct = new HashSet<Long>();
        correct.add(1L);
        correct.add(2L);
        correct.add(3L);
        correct.add(4L);
        correct.add(6L);
        correct.add(9L);
        correct.add(12L);
        correct.add(18L);
        correct.add(36L);
        assertEquals(result, correct);
    }

    @Test
    public void testAllDivisors27000() { // 2^3 * 3^3 * 5^3
        Set<Long> result = EulerPrime.findDivisors(27000);
        Set<Long> correct = new HashSet<Long>();
        correct.add(1L);
        correct.add(2L);
        correct.add(3L);
        correct.add(4L);
        correct.add(5L);
        correct.add(6L);
        correct.add(8L);
        correct.add(9L);
        correct.add(10L);
        correct.add(12L);
        correct.add(15L);
        correct.add(18L);
        correct.add(20L);
        correct.add(24L);
        correct.add(25L);
        correct.add(27L);
        correct.add(30L);
        correct.add(36L);
        correct.add(40L);
        correct.add(45L);
        correct.add(50L);
        correct.add(54L);
        correct.add(60L);
        correct.add(72L);
        correct.add(75L);
        correct.add(90L);
        correct.add(100L);
        correct.add(108L);
        correct.add(120L);
        correct.add(125L);
        correct.add(135L);
        correct.add(150L);
        correct.add(180L);
        correct.add(200L);
        correct.add(216L);
        correct.add(225L);
        correct.add(250L);
        correct.add(270L);
        correct.add(300L);
        correct.add(360L);
        correct.add(375L);
        correct.add(450L);
        correct.add(500L);
        correct.add(540L);
        correct.add(600L);
        correct.add(675L);
        correct.add(750L);
        correct.add(900L);
        correct.add(1000L);
        correct.add(1080L);
        correct.add(1125L);
        correct.add(1350L);
        correct.add(1500L);
        correct.add(1800L);
        correct.add(2250L);
        correct.add(2700L);
        correct.add(3000L);
        correct.add(3375L);
        correct.add(4500L);
        correct.add(5400L);
        correct.add(6750L);
        correct.add(9000L);
        correct.add(13500L);
        correct.add(27000L);
        assertEquals(result, correct);
    }
}
