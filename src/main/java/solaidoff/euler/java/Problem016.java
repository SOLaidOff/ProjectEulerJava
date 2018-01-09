package solaidoff.euler.java;

import java.math.BigInteger;

/**
 * https://projecteuler.net/problem=16
 * 
 * Power digit sum
 * 
 * Problem 16
 * 
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 */
public class Problem016 extends EulerProblem {
    @Override
    public long doProblem() {
        BigInteger two = new BigInteger("2");
        BigInteger inputNumber = two.pow(1000);
        String input = inputNumber.toString();
        
        return sumDigits(input);
    }
    
    // Based on similar method from Problem 13; consider moving to helper class in the Great Refactor
    private long sumDigits(String input) {
        int sum = 0;
        
        for(int index = input.length(); index > 0; index--) {
            String digit = input.substring(index - 1, index);
            sum += Integer.valueOf(digit);
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem016().doProblem());
    }

/*
 * The first time through Project Euler ten years ago, I remember relying on BigInteger for Problem 13. This time I figured out
 * a smarter way for 13, but I'm still stumped here. The BigInteger crutch will have to do for now.
 * 
 * For future reference, here are early powers of two and the sums of their digits (no obvious pattern except in the ones place):
 * 
 * @formatter:off

for(int powerCounter = 0; powerCounter < 62; powerCounter++) {
    long power = (long) Math.pow(2, powerCounter);
    long digitSum = sumDigits(power);
            
    System.out.println("n: " + powerCounter + "   Power of 2: " + power + "   Sum of digits: " + digitSum);
}

n: 0   Power of 2: 1   Sum of digits: 1
n: 1   Power of 2: 2   Sum of digits: 2
n: 2   Power of 2: 4   Sum of digits: 4
n: 3   Power of 2: 8   Sum of digits: 8
n: 4   Power of 2: 16   Sum of digits: 7
n: 5   Power of 2: 32   Sum of digits: 5
n: 6   Power of 2: 64   Sum of digits: 10
n: 7   Power of 2: 128   Sum of digits: 11
n: 8   Power of 2: 256   Sum of digits: 13
n: 9   Power of 2: 512   Sum of digits: 8
n: 10   Power of 2: 1024   Sum of digits: 7
n: 11   Power of 2: 2048   Sum of digits: 14
n: 12   Power of 2: 4096   Sum of digits: 19
n: 13   Power of 2: 8192   Sum of digits: 20
n: 14   Power of 2: 16384   Sum of digits: 22
n: 15   Power of 2: 32768   Sum of digits: 26
n: 16   Power of 2: 65536   Sum of digits: 25
n: 17   Power of 2: 131072   Sum of digits: 14
n: 18   Power of 2: 262144   Sum of digits: 19
n: 19   Power of 2: 524288   Sum of digits: 29
n: 20   Power of 2: 1048576   Sum of digits: 31
n: 21   Power of 2: 2097152   Sum of digits: 26
n: 22   Power of 2: 4194304   Sum of digits: 25
n: 23   Power of 2: 8388608   Sum of digits: 41
n: 24   Power of 2: 16777216   Sum of digits: 37
n: 25   Power of 2: 33554432   Sum of digits: 29
n: 26   Power of 2: 67108864   Sum of digits: 40
n: 27   Power of 2: 134217728   Sum of digits: 35
n: 28   Power of 2: 268435456   Sum of digits: 43
n: 29   Power of 2: 536870912   Sum of digits: 41
n: 30   Power of 2: 1073741824   Sum of digits: 37
n: 31   Power of 2: 2147483648   Sum of digits: 47
n: 32   Power of 2: 4294967296   Sum of digits: 58
n: 33   Power of 2: 8589934592   Sum of digits: 62
n: 34   Power of 2: 17179869184   Sum of digits: 61
n: 35   Power of 2: 34359738368   Sum of digits: 59
n: 36   Power of 2: 68719476736   Sum of digits: 64
n: 37   Power of 2: 137438953472   Sum of digits: 56
n: 38   Power of 2: 274877906944   Sum of digits: 67
n: 39   Power of 2: 549755813888   Sum of digits: 71
n: 40   Power of 2: 1099511627776   Sum of digits: 61
n: 41   Power of 2: 2199023255552   Sum of digits: 50
n: 42   Power of 2: 4398046511104   Sum of digits: 46
n: 43   Power of 2: 8796093022208   Sum of digits: 56
n: 44   Power of 2: 17592186044416   Sum of digits: 58
n: 45   Power of 2: 35184372088832   Sum of digits: 62
n: 46   Power of 2: 70368744177664   Sum of digits: 70
n: 47   Power of 2: 140737488355328   Sum of digits: 68
n: 48   Power of 2: 281474976710656   Sum of digits: 73
n: 49   Power of 2: 562949953421312   Sum of digits: 65
n: 50   Power of 2: 1125899906842624   Sum of digits: 76
n: 51   Power of 2: 2251799813685248   Sum of digits: 80
n: 52   Power of 2: 4503599627370496   Sum of digits: 79
n: 53   Power of 2: 9007199254740992   Sum of digits: 77
n: 54   Power of 2: 18014398509481984   Sum of digits: 82
n: 55   Power of 2: 36028797018963968   Sum of digits: 92
n: 56   Power of 2: 72057594037927936   Sum of digits: 85
n: 57   Power of 2: 144115188075855872   Sum of digits: 80
n: 58   Power of 2: 288230376151711744   Sum of digits: 70
n: 59   Power of 2: 576460752303423488   Sum of digits: 77
n: 60   Power of 2: 1152921504606846976   Sum of digits: 82
n: 61   Power of 2: 2305843009213693952   Sum of digits: 74

 * @formatter:on
 */
}