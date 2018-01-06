package solaidoff.euler.java.helper;

public class EulerBasicMath {
    public static boolean divisibleBy(long dividend, long divisor) {
        return dividend % divisor == 0;
    }
    
    public static boolean isEven(long number) {
        return divisibleBy(number, 2);
    }
}
