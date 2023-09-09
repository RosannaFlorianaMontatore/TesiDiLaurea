package org.apache.commons.numbers.core;

import org.junit.jupiter.api.Test;
import org.apache.commons.numbers.core.ArithmeticUtils;

import org.junit.jupiter.api.Assertions;

import java.math.BigInteger;
import java.text.MessageFormat;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test cases for the {@link ArithmeticUtils} class.
 *
 */
class ArithmeticUtilsCopilotTest {

/*create a test suite for this method:
    public static int gcd(int p, int q) {
        // Perform the gcd algorithm on negative numbers, so that -2^31 does not
        // need to be handled separately
        int a = p > 0 ? -p : p;
        int b = q > 0 ? -q : q;

        int negatedGcd;
        if (a == 0) {
        negatedGcd = b;
        } else if (b == 0) {
        negatedGcd = a;
        } else {
    // Make "a" and "b" odd, keeping track of common power of 2.
    final int aTwos = Integer.numberOfTrailingZeros(a);
    final int bTwos = Integer.numberOfTrailingZeros(b);
        a >>= aTwos;
        b >>= bTwos;
    final int shift = Math.min(aTwos, bTwos);

        // "a" and "b" are negative and odd.
        // If a < b then "gdc(a, b)" is equal to "gcd(a - b, b)".
        // If a > b then "gcd(a, b)" is equal to "gcd(b - a, a)".
        // Hence, in the successive iterations:
        //  "a" becomes the negative absolute difference of the current values,
        //  "b" becomes that value of the two that is closer to zero.
        while (a != b) {
    final int delta = a - b;
        b = Math.max(a, b);
        a = delta > 0 ? -delta : delta;

        // Remove any power of 2 in "a" ("b" is guaranteed to be odd).
        a >>= Integer.numberOfTrailingZeros(a);
        }

        // Recover the common power of 2.
        negatedGcd = a << shift;
        }
        if (negatedGcd == Integer.MIN_VALUE) {
        throw new NumbersArithmeticException("overflow: gcd({0}, {1}) is 2^31",
        p, q);
        }
        return -negatedGcd;
        }

        use significant names that are related to the method name
*/

    @Test
    void testGcdNegativePositive() {
        int a = -2;
        int b = 3;
        int result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testGcdNegativeNegative() {
        int a = -2;
        int b = -3;
        int result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testGcdPositiveNegative() {
        int a = 2;
        int b = -3;
        int result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testGcdPositivePositive() {
        int a = 2;
        int b = 3;
        int result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testGcdPositiveZero() {
        int a = 2;
        int b = 0;
        int result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testGcdZeroPositive() {
        int a = 0;
        int b = 3;
        int result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(3, result);
    }

    @Test
    void testGcdZeroNegative() {
        int a = 0;
        int b = -3;
        int result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(3, result);
    }

    @Test
    void testGcdNegativeZero() {
        int a = -2;
        int b = 0;
        int result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testGcdZeroZero() {
        int a = 0;
        int b = 0;
        int result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testGcdIntMinIntMin() {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        try {
            ArithmeticUtils.gcd(a, b);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException e) {
            // expected
        }
    }

    @Test
    void testGcdIntMinIntOne() {
        int a = Integer.MIN_VALUE;
        int b = 1;
        int result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testGcdIntMinIntTwo() {
        int a = Integer.MIN_VALUE;
        int b = 2;
        int result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testGcdIntMinIntMax() {
        int a = Integer.MIN_VALUE;
        int b = Integer.MAX_VALUE;
        int result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(1, result);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:
    public static long gcd(final long p, final long q) {
        long u = p;
        long v = q;
        if (u == 0 || v == 0) {
            if (u == Long.MIN_VALUE || v == Long.MIN_VALUE) {
                throw new NumbersArithmeticException(OVERFLOW_GCD_MESSAGE_2_POWER_63,
                                                  p, q);
            }
            return Math.abs(u) + Math.abs(v);
        }
        // keep u and v negative, as negative integers range down to
        // -2^63, while positive numbers can only be as large as 2^63-1
        // (i.e. we can't necessarily negate a negative number without
        // overflow)
        // assert u!=0 && v!=0;
        if (u > 0) {
        u = -u;
    } // make u negative
        if (v > 0) {
        v = -v;
    } // make v negative
    // B1. [Find power of 2]
    int k = 0;
        while ((u & 1) == 0 && (v & 1) == 0 && k < 63) { // while u and v are
        // both even...
        u /= 2;
        v /= 2;
        k++; // cast out twos.
    }
        if (k == 63) {
        throw new ArithmeticUtils.NumbersArithmeticException(OVERFLOW_GCD_MESSAGE_2_POWER_63,
                p, q);
    }
    // B2. Initialize: u and v have been divided by 2^k and at least
    // one is odd.
    long t = ((u & 1) == 1) ? v : -(u / 2);
    // t negative: u was odd, v may be even (t replaces v)
    // t positive: u was even, v is odd (t replaces u)
        do {
        // assert u<0 && v<0;
        // B4/B3: cast out twos from t.
        while ((t & 1) == 0) { // while t is even..
            t /= 2; // cast out twos
        }
        // B5 [reset max(u,v)]
        if (t > 0) {
            u = -t;
        } else {
            v = t;
        }
        // B6/B3. at this point both u and v should be odd.
        t = (v - u) / 2;
        // |u| larger: t positive (replace u)
        // |v| larger: t negative (replace v)
    } while (t != 0);
        return -u * (1L << k); // gcd is u*2^k
}

        use significant names that are related to the method name
*/

    @Test
    void testGcdLongNegativePositive() {
        long a = -2;
        long b = 3;
        long result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testGcdLongNegativeNegative() {
        long a = -2;
        long b = -3;
        long result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testGcdLongPositiveNegative() {
        long a = 2;
        long b = -3;
        long result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testGcdLongPositivePositive() {
        long a = 2;
        long b = 3;
        long result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testGcdLongPositiveZero() {
        long a = 2;
        long b = 0;
        long result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testGcdLongZeroPositive() {
        long a = 0;
        long b = 3;
        long result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(3, result);
    }

    @Test
    void testGcdLongZeroNegative() {
        long a = 0;
        long b = -3;
        long result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(3, result);
    }

    @Test
    void testGcdLongNegativeZero() {
        long a = -2;
        long b = 0;
        long result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testGcdLongZeroZero() {
        long a = 0;
        long b = 0;
        long result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testGcdLongLongMinLongMin() {
        long a = Long.MIN_VALUE;
        long b = Long.MIN_VALUE;
        try {
            ArithmeticUtils.gcd(a, b);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException e) {
            // expected
        }
    }

    @Test
    void testGcdLongLongMinLongOne() {
        long a = Long.MIN_VALUE;
        long b = 1;
        long result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testGcdLongLongMinLongTwo() {
        long a = Long.MIN_VALUE;
        long b = 2;
        long result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testGcdLongLongMinLongMax() {
        long a = Long.MIN_VALUE;
        long b = Long.MAX_VALUE;
        long result = ArithmeticUtils.gcd(a, b);
        Assertions.assertEquals(1, result);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:
     public static int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        final int lcm = Math.abs(Math.multiplyExact(a / gcd(a, b), b));
        if (lcm == Integer.MIN_VALUE) {
            throw new NumbersArithmeticException("overflow: lcm({0}, {1}) is 2^31",
                                              a, b);
        }
        return lcm;
    }

        use significant names that are related to the method name
*/

    @Test
    void testLcmNegativePositive() {
        int a = -2;
        int b = 3;
        int result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(6, result);
    }

    @Test
    void testLcmNegativeNegative() {
        int a = -2;
        int b = -3;
        int result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(6, result);
    }

    @Test
    void testLcmPositiveNegative() {
        int a = 2;
        int b = -3;
        int result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(6, result);
    }

    @Test
    void testLcmPositivePositive() {
        int a = 2;
        int b = 3;
        int result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(6, result);
    }

    @Test
    void testLcmPositiveZero() {
        int a = 2;
        int b = 0;
        int result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testLcmZeroPositive() {
        int a = 0;
        int b = 3;
        int result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testLcmZeroNegative() {
        int a = 0;
        int b = -3;
        int result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testLcmNegativeZero() {
        int a = -2;
        int b = 0;
        int result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testLcmZeroZero() {
        int a = 0;
        int b = 0;
        int result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testLcmIntMinIntMin() {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        try {
            ArithmeticUtils.lcm(a, b);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException e) {
            // expected
        }
    }

    @Test
    void testLcmIntMinIntOne() {
        int a = Integer.MIN_VALUE;
        int b = 1;
        int result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(Integer.MIN_VALUE, result);
    }

    @Test
    void testLcmIntMinIntTwo() {
        int a = Integer.MIN_VALUE;
        int b = 2;
        int result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(Integer.MIN_VALUE, result);
    }

    @Test
    void testLcmIntMinIntMax() {
        int a = Integer.MIN_VALUE;
        int b = Integer.MAX_VALUE;
        int result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(2, result);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:
    public static long lcm(long a, long b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        final long lcm = Math.abs(Math.multiplyExact(a / gcd(a, b), b));
        if (lcm == Long.MIN_VALUE) {
            throw new NumbersArithmeticException("overflow: lcm({0}, {1}) is 2^63",
                                              a, b);
        }
        return lcm;
    }

        use significant names that are related to the method name
*/

    @Test
    void testLcmLongNegativePositive() {
        long a = -2;
        long b = 3;
        long result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(6, result);
    }

    @Test
    void testLcmLongNegativeNegative() {
        long a = -2;
        long b = -3;
        long result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(6, result);
    }

    @Test
    void testLcmLongPositiveNegative() {
        long a = 2;
        long b = -3;
        long result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(6, result);
    }

    @Test
    void testLcmLongPositivePositive() {
        long a = 2;
        long b = 3;
        long result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(6, result);
    }

    @Test
    void testLcmLongPositiveZero() {
        long a = 2;
        long b = 0;
        long result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testLcmLongZeroPositive() {
        long a = 0;
        long b = 3;
        long result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testLcmLongZeroNegative() {
        long a = 0;
        long b = -3;
        long result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testLcmLongNegativeZero() {
        long a = -2;
        long b = 0;
        long result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testLcmLongZeroZero() {
        long a = 0;
        long b = 0;
        long result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testLcmLongLongMinLongMin() {
        long a = Long.MIN_VALUE;
        long b = Long.MIN_VALUE;
        try {
            ArithmeticUtils.lcm(a, b);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException e) {
            // expected
        }
    }

    @Test
    void testLcmLongLongMinLongOne() {
        long a = Long.MIN_VALUE;
        long b = 1;
        long result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(Long.MIN_VALUE, result);
    }

    @Test
    void testLcmLongLongMinLongTwo() {
        long a = Long.MIN_VALUE;
        long b = 2;
        long result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(Long.MIN_VALUE, result);
    }

    @Test
    void testLcmLongLongMinLongMax() {
        long a = Long.MIN_VALUE;
        long b = Long.MAX_VALUE;
        long result = ArithmeticUtils.lcm(a, b);
        Assertions.assertEquals(2, result);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:
public static int pow(final int k,
                          final int e) {
        if (e < 0) {
            throw new IllegalArgumentException(NEGATIVE_EXPONENT_1 + e + NEGATIVE_EXPONENT_2);
        }

        if (k == 0) {
            return e == 0 ? 1 : 0;
        }

        if (k == 1) {
            return 1;
        }

        if (k == -1) {
            return (e & 1) == 0 ? 1 : -1;
        }

        if (e >= 31) {
            throw new ArithmeticException("integer overflow");
        }

        int exp = e;
        int result = 1;
        int k2p    = k;
        while (true) {
            if ((exp & 0x1) != 0) {
                result = Math.multiplyExact(result, k2p);
            }

            exp >>= 1;
            if (exp == 0) {
                break;
            }

            k2p = Math.multiplyExact(k2p, k2p);
        }

        return result;
    }

        use significant names that are related to the method name
*/

    @Test
    void testPowNegativeExponent() {
        int k = 2;
        int e = -3;
        try {
            ArithmeticUtils.pow(k, e);
            Assertions.fail("an exception should have been thrown");
        } catch (IllegalArgumentException ex) {
            // expected
        }
    }

    @Test
    void testPowZeroExponent() {
        int k = 2;
        int e = 0;
        int result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testPowZeroBase() {
        int k = 0;
        int e = 2;
        int result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testPowOneBase() {
        int k = 1;
        int e = 2;
        int result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testPowMinusOneBaseEvenExponent() {
        int k = -1;
        int e = 2;
        int result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testPowMinusOneBaseOddExponent() {
        int k = -1;
        int e = 3;
        int result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(-1, result);
    }

    @Test
    void testPowTwoBaseThirtyOneExponent() {
        int k = 2;
        int e = 31;
        int result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(Integer.MIN_VALUE, result);
    }

    @Test
    void testPowTwoBaseThirtyTwoExponent() {
        int k = 2;
        int e = 32;
        try {
            ArithmeticUtils.pow(k, e);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException ex) {
            // expected
        }
    }

    @Test
    void testPowTwoBasePositiveExponent() {
        int k = 2;
        int e = 3;
        int result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(8, result);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:
public static long pow(final long k,
                           final int e) {
        if (e < 0) {
            throw new IllegalArgumentException(NEGATIVE_EXPONENT_1 + e + NEGATIVE_EXPONENT_2);
        }

        if (k == 0L) {
            return e == 0 ? 1L : 0L;
        }

        if (k == 1L) {
            return 1L;
        }

        if (k == -1L) {
            return (e & 1) == 0 ? 1L : -1L;
        }

        if (e >= 63) {
            throw new ArithmeticException("long overflow");
        }

        int exp = e;
        long result = 1;
        long k2p    = k;
        while (true) {
            if ((exp & 0x1) != 0) {
                result = Math.multiplyExact(result, k2p);
            }

            exp >>= 1;
            if (exp == 0) {
                break;
            }

            k2p = Math.multiplyExact(k2p, k2p);
        }

        return result;
    }

        use significant names that are related to the method name
*/

    @Test
    void testPowLongNegativeExponent() {
        long k = 2;
        int e = -3;
        try {
            ArithmeticUtils.pow(k, e);
            Assertions.fail("an exception should have been thrown");
        } catch (IllegalArgumentException ex) {
            // expected
        }
    }

    @Test
    void testPowLongZeroExponent() {
        long k = 2;
        int e = 0;
        long result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testPowLongZeroBase() {
        long k = 0;
        int e = 2;
        long result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testPowLongOneBase() {
        long k = 1;
        int e = 2;
        long result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testPowLongMinusOneBaseEvenExponent() {
        long k = -1;
        int e = 2;
        long result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testPowLongMinusOneBaseOddExponent() {
        long k = -1;
        int e = 3;
        long result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(-1, result);
    }

    @Test
    void testPowLongTwoBaseThirtyOneExponent() {
        long k = 2;
        int e = 31;
        long result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(Long.MIN_VALUE, result);
    }

    @Test
    void testPowLongTwoBaseThirtyTwoExponent() {
        long k = 2;
        int e = 32;
        try {
            ArithmeticUtils.pow(k, e);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException ex) {
            // expected
        }
    }

    @Test
    void testPowLongTwoBasePositiveExponent() {
        long k = 2;
        int e = 3;
        long result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(8, result);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:
    public static BigInteger pow(final BigInteger k, int e) {
        if (e < 0) {
            throw new IllegalArgumentException(NEGATIVE_EXPONENT_1 + e + NEGATIVE_EXPONENT_2);
        }

        return k.pow(e);
    }

        use significant names that are related to the method name
*/

    @Test
    void testPowBigIntegerNegativeExponent() {
        BigInteger k = BigInteger.valueOf(2);
        int e = -3;
        try {
            ArithmeticUtils.pow(k, e);
            Assertions.fail("an exception should have been thrown");
        } catch (IllegalArgumentException ex) {
            // expected
        }
    }

    @Test
    void testPowBigIntegerZeroExponent() {
        BigInteger k = BigInteger.valueOf(2);
        int e = 0;
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.ONE, result);
    }

    @Test
    void testPowBigIntegerZeroBase() {
        BigInteger k = BigInteger.ZERO;
        int e = 2;
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.ZERO, result);
    }

    @Test
    void testPowBigIntegerOneBase() {
        BigInteger k = BigInteger.ONE;
        int e = 2;
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.ONE, result);
    }

    @Test
    void testPowBigIntegerMinusOneBaseEvenExponent() {
        BigInteger k = BigInteger.valueOf(-1);
        int e = 2;
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.ONE, result);
    }

    @Test
    void testPowBigIntegerMinusOneBaseOddExponent() {
        BigInteger k = BigInteger.valueOf(-1);
        int e = 3;
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.valueOf(-1), result);
    }

    @Test
    void testPowBigIntegerTwoBaseThirtyOneExponent() {
        BigInteger k = BigInteger.valueOf(2);
        int e = 31;
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.valueOf(2147483648L), result);
    }

    @Test
    void testPowBigIntegerTwoBaseThirtyTwoExponent() {
        BigInteger k = BigInteger.valueOf(2);
        int e = 32;
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.valueOf(4294967296L), result);
    }

    @Test
    void testPowBigIntegerTwoBasePositiveExponent() {
        BigInteger k = BigInteger.valueOf(2);
        int e = 3;
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.valueOf(8), result);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:
public static BigInteger pow(final BigInteger k, final long e) {
        if (e < 0) {
            throw new IllegalArgumentException(NEGATIVE_EXPONENT_1 + e + NEGATIVE_EXPONENT_2);
        }

        long exp = e;
        BigInteger result = BigInteger.ONE;
        BigInteger k2p    = k;
        while (exp != 0) {
            if ((exp & 0x1) != 0) {
                result = result.multiply(k2p);
            }
            k2p = k2p.multiply(k2p);
            exp >>= 1;
        }

        return result;

    }

        use significant names that are related to the method name
*/

    @Test
    void testPowBigIntegerLongNegativeExponent() {
        BigInteger k = BigInteger.valueOf(2);
        long e = -3;
        try {
            ArithmeticUtils.pow(k, e);
            Assertions.fail("an exception should have been thrown");
        } catch (IllegalArgumentException ex) {
            // expected
        }
    }

    @Test
    void testPowBigIntegerLongZeroExponent() {
        BigInteger k = BigInteger.valueOf(2);
        long e = 0;
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.ONE, result);
    }

    @Test
    void testPowBigIntegerLongZeroBase() {
        BigInteger k = BigInteger.ZERO;
        long e = 2;
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.ZERO, result);
    }

    @Test
    void testPowBigIntegerLongOneBase() {
        BigInteger k = BigInteger.ONE;
        long e = 2;
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.ONE, result);
    }

    @Test
    void testPowBigIntegerLongMinusOneBaseEvenExponent() {
        BigInteger k = BigInteger.valueOf(-1);
        long e = 2;
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.ONE, result);
    }

    @Test
    void testPowBigIntegerLongMinusOneBaseOddExponent() {
        BigInteger k = BigInteger.valueOf(-1);
        long e = 3;
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.valueOf(-1), result);
    }

    @Test
    void testPowBigIntegerLongTwoBaseThirtyOneExponent() {
        BigInteger k = BigInteger.valueOf(2);
        long e = 31;
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.valueOf(2147483648L), result);
    }

    @Test
    void testPowBigIntegerLongTwoBaseThirtyTwoExponent() {
        BigInteger k = BigInteger.valueOf(2);
        long e = 32;
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.valueOf(4294967296L), result);
    }

    @Test
    void testPowBigIntegerLongTwoBasePositiveExponent() {
        BigInteger k = BigInteger.valueOf(2);
        long e = 3;
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.valueOf(8), result);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:
    public static BigInteger pow(final BigInteger k, final BigInteger e) {
        if (e.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException(NEGATIVE_EXPONENT_1 + e + NEGATIVE_EXPONENT_2);
        }

        BigInteger exp = e;
        BigInteger result = BigInteger.ONE;
        BigInteger k2p    = k;
        while (!BigInteger.ZERO.equals(exp)) {
            if (exp.testBit(0)) {
                result = result.multiply(k2p);
            }
            k2p = k2p.multiply(k2p);
            exp = exp.shiftRight(1);
        }

        return result;
    }

        use significant names that are related to the method name
*/

    @Test
    void testPowBigIntegerBigIntegerNegativeExponent() {
        BigInteger k = BigInteger.valueOf(2);
        BigInteger e = BigInteger.valueOf(-3);
        try {
            ArithmeticUtils.pow(k, e);
            Assertions.fail("an exception should have been thrown");
        } catch (IllegalArgumentException ex) {
            // expected
        }
    }

    @Test
    void testPowBigIntegerBigIntegerZeroExponent() {
        BigInteger k = BigInteger.valueOf(2);
        BigInteger e = BigInteger.ZERO;
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.ONE, result);
    }

    @Test
    void testPowBigIntegerBigIntegerZeroBase() {
        BigInteger k = BigInteger.ZERO;
        BigInteger e = BigInteger.valueOf(2);
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.ZERO, result);
    }

    @Test
    void testPowBigIntegerBigIntegerOneBase() {
        BigInteger k = BigInteger.ONE;
        BigInteger e = BigInteger.valueOf(2);
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.ONE, result);
    }

    @Test
    void testPowBigIntegerBigIntegerMinusOneBaseEvenExponent() {
        BigInteger k = BigInteger.valueOf(-1);
        BigInteger e = BigInteger.valueOf(2);
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.ONE, result);
    }

    @Test
    void testPowBigIntegerBigIntegerMinusOneBaseOddExponent() {
        BigInteger k = BigInteger.valueOf(-1);
        BigInteger e = BigInteger.valueOf(3);
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.valueOf(-1), result);
    }

    @Test
    void testPowBigIntegerBigIntegerTwoBaseThirtyOneExponent() {
        BigInteger k = BigInteger.valueOf(2);
        BigInteger e = BigInteger.valueOf(31);
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.valueOf(2147483648L), result);
    }

    @Test
    void testPowBigIntegerBigIntegerTwoBaseThirtyTwoExponent() {
        BigInteger k = BigInteger.valueOf(2);
        BigInteger e = BigInteger.valueOf(32);
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.valueOf(4294967296L), result);
    }

    @Test
    void testPowBigIntegerBigIntegerTwoBasePositiveExponent() {
        BigInteger k = BigInteger.valueOf(2);
        BigInteger e = BigInteger.valueOf(3);
        BigInteger result = ArithmeticUtils.pow(k, e);
        Assertions.assertEquals(BigInteger.valueOf(8), result);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:
    public static boolean isPowerOfTwo(long n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

        use significant names that are related to the method name
*/

    @Test
    void testIsPowerOfTwoNegative() {
        long n = -2;
        boolean result = ArithmeticUtils.isPowerOfTwo(n);
        Assertions.assertFalse(result);
    }

    @Test
    void testIsPowerOfTwoZero() {
        long n = 0;
        boolean result = ArithmeticUtils.isPowerOfTwo(n);
        Assertions.assertFalse(result);
    }

    @Test
    void testIsPowerOfTwoOne() {
        long n = 1;
        boolean result = ArithmeticUtils.isPowerOfTwo(n);
        Assertions.assertTrue(result);
    }

    @Test
    void testIsPowerOfTwoTwo() {
        long n = 2;
        boolean result = ArithmeticUtils.isPowerOfTwo(n);
        Assertions.assertTrue(result);
    }

    @Test
    void testIsPowerOfTwoThree() {
        long n = 3;
        boolean result = ArithmeticUtils.isPowerOfTwo(n);
        Assertions.assertFalse(result);
    }

    @Test
    void testIsPowerOfTwoFour() {
        long n = 4;
        boolean result = ArithmeticUtils.isPowerOfTwo(n);
        Assertions.assertTrue(result);
    }

    @Test
    void testIsPowerOfTwoMaxLong() {
        long n = Long.MAX_VALUE;
        boolean result = ArithmeticUtils.isPowerOfTwo(n);
        Assertions.assertFalse(result);
    }

    @Test
    void testIsPowerOfTwoMinLong() {
        long n = Long.MIN_VALUE;
        boolean result = ArithmeticUtils.isPowerOfTwo(n);
        Assertions.assertFalse(result);
    }

    @Test
    void testIsPowerOfTwoMaxLongMinusOne() {
        long n = Long.MAX_VALUE - 1;
        boolean result = ArithmeticUtils.isPowerOfTwo(n);
        Assertions.assertFalse(result);
    }

    @Test
    void testIsPowerOfTwoMinLongPlusOne() {
        long n = Long.MIN_VALUE + 1;
        boolean result = ArithmeticUtils.isPowerOfTwo(n);
        Assertions.assertFalse(result);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:
    public static int remainderUnsigned(int dividend, int divisor) {
        if (divisor >= 0) {
            if (dividend >= 0) {
                return dividend % divisor;
            }
            // The implementation is a Java port of algorithm described in the book
            // "Hacker's Delight" (section "Unsigned short division from signed division").
            final int q = ((dividend >>> 1) / divisor) << 1;
            dividend -= q * divisor;
            if (dividend < 0 || dividend >= divisor) {
                dividend -= divisor;
            }
            return dividend;
        }
        return dividend >= 0 || dividend < divisor ? dividend : dividend - divisor;
    }

        use significant names that are related to the method name
*/

    @Test
    void testRemainderUnsignedDividendPositiveDivisorPositive() {
        int dividend = 2;
        int divisor = 3;
        int result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testRemainderUnsignedDividendPositiveDivisorNegative() {
        int dividend = 2;
        int divisor = -3;
        int result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testRemainderUnsignedDividendNegativeDivisorPositive() {
        int dividend = -2;
        int divisor = 3;
        int result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testRemainderUnsignedDividendNegativeDivisorPositive2() {
        int dividend = -150;
        int divisor = 3;
        int result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testRemainderUnsignedDividendNegativeDivisorNegative() {
        int dividend = -2;
        int divisor = -3;
        int result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testRemainderUnsignedDividendZeroDivisorPositive() {
        int dividend = 0;
        int divisor = 3;
        int result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testRemainderUnsignedDividendPositiveDivisorZero() {
        int dividend = 2;
        int divisor = 0;
        try {
            ArithmeticUtils.remainderUnsigned(dividend, divisor);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException ex) {
            // expected
        }
    }

    @Test
    void testRemainderUnsignedDividendNegativeDivisorZero() {
        int dividend = -2;
        int divisor = 0;
        try {
            ArithmeticUtils.remainderUnsigned(dividend, divisor);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException ex) {
            // expected
        }
    }

    @Test
    void testRemainderUnsignedDividendMaxDivisorPositive() {
        int dividend = Integer.MAX_VALUE;
        int divisor = 3;
        int result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testRemainderUnsignedDividendMaxDivisorNegative() {
        int dividend = Integer.MAX_VALUE;
        int divisor = -3;
        int result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testRemainderUnsignedDividendMinDivisorPositive() {
        int dividend = Integer.MIN_VALUE;
        int divisor = 3;
        int result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testRemainderUnsignedDividendMinDivisorNegative() {
        int dividend = Integer.MIN_VALUE;
        int divisor = -3;
        int result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testRemainderUnsignedDividendMaxDivisorZero() {
        int dividend = Integer.MAX_VALUE;
        int divisor = 0;
        try {
            ArithmeticUtils.remainderUnsigned(dividend, divisor);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException ex) {
            // expected
        }
    }

    @Test
    void testRemainderUnsignedDividendMinDivisorZero() {
        int dividend = Integer.MIN_VALUE;
        int divisor = 0;
        try {
            ArithmeticUtils.remainderUnsigned(dividend, divisor);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException ex) {
            // expected
        }
    }

    @Test
    void testRemainderUnsignedDividendZeroDivisorMax() {
        int dividend = 0;
        int divisor = Integer.MAX_VALUE;
        int result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testRemainderUnsignedDividendZeroDivisorMin() {
        int dividend = 0;
        int divisor = Integer.MIN_VALUE;
        int result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testRemainderUnsignedDividendMaxDivisorMax() {
        int dividend = Integer.MAX_VALUE;
        int divisor = Integer.MAX_VALUE;
        int result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testRemainderUnsignedDividendMinDivisorMin() {
        int dividend = Integer.MIN_VALUE;
        int divisor = Integer.MIN_VALUE;
        int result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(0, result);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:
    public static long remainderUnsigned(long dividend, long divisor) {
        if (divisor >= 0L) {
            if (dividend >= 0L) {
                return dividend % divisor;
            }
            // The implementation is a Java port of algorithm described in the book
            // "Hacker's Delight" (section "Unsigned short division from signed division").
            final long q = ((dividend >>> 1) / divisor) << 1;
            dividend -= q * divisor;
            if (dividend < 0L || dividend >= divisor) {
                dividend -= divisor;
            }
            return dividend;
        }
        return dividend >= 0L || dividend < divisor ? dividend : dividend - divisor;
    }

        use significant names that are related to the method name
*/

    @Test
    void testRemainderUnsignedLongDividendPositiveDivisorPositive() {
        long dividend = 2;
        long divisor = 3;
        long result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testRemainderUnsignedLongDividendPositiveDivisorNegative() {
        long dividend = 2;
        long divisor = -3;
        long result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testRemainderUnsignedLongDividendNegativeDivisorPositive() {
        long dividend = -2;
        long divisor = 3;
        long result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testRemainderUnsignedLongDividendNegativeDivisorPositive2() {
        long dividend = -150;
        long divisor = 3;
        long result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testRemainderUnsignedLongDividendNegativeDivisorNegative() {
        long dividend = -2;
        long divisor = -3;
        long result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testRemainderUnsignedLongDividendZeroDivisorPositive() {
        long dividend = 0;
        long divisor = 3;
        long result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testRemainderUnsignedLongDividendPositiveDivisorZero() {
        long dividend = 2;
        long divisor = 0;
        try {
            ArithmeticUtils.remainderUnsigned(dividend, divisor);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException ex) {
            // expected
        }
    }

    @Test
    void testRemainderUnsignedLongDividendNegativeDivisorZero() {
        long dividend = -2;
        long divisor = 0;
        try {
            ArithmeticUtils.remainderUnsigned(dividend, divisor);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException ex) {
            // expected
        }
    }

    @Test
    void testRemainderUnsignedLongDividendMaxDivisorPositive() {
        long dividend = Long.MAX_VALUE;
        long divisor = 3;
        long result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testRemainderUnsignedLongDividendMaxDivisorNegative() {
        long dividend = Long.MAX_VALUE;
        long divisor = -3;
        long result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testRemainderUnsignedLongDividendMinDivisorPositive() {
        long dividend = Long.MIN_VALUE;
        long divisor = 3;
        long result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testRemainderUnsignedLongDividendMinDivisorNegative() {
        long dividend = Long.MIN_VALUE;
        long divisor = -3;
        long result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testRemainderUnsignedLongDividendMaxDivisorZero() {
        long dividend = Long.MAX_VALUE;
        long divisor = 0;
        try {
            ArithmeticUtils.remainderUnsigned(dividend, divisor);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException ex) {
            // expected
        }
    }

    @Test
    void testRemainderUnsignedLongDividendMinDivisorZero() {
        long dividend = Long.MIN_VALUE;
        long divisor = 0;
        try {
            ArithmeticUtils.remainderUnsigned(dividend, divisor);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException ex) {
            // expected
        }
    }

    @Test
    void testRemainderUnsignedLongDividendZeroDivisorMax() {
        long dividend = 0;
        long divisor = Long.MAX_VALUE;
        long result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testRemainderUnsignedLongDividendZeroDivisorMin() {
        long dividend = 0;
        long divisor = Long.MIN_VALUE;
        long result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testRemainderUnsignedLongDividendMaxDivisorMax() {
        long dividend = Long.MAX_VALUE;
        long divisor = Long.MAX_VALUE;
        long result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testRemainderUnsignedLongDividendMinDivisorMin() {
        long dividend = Long.MIN_VALUE;
        long divisor = Long.MIN_VALUE;
        long result = ArithmeticUtils.remainderUnsigned(dividend, divisor);
        Assertions.assertEquals(0, result);
    }


//___________________________________________________________________________________________________________________

/*create a test suite for this method:
    public static int divideUnsigned(int dividend, int divisor) {
        if (divisor >= 0) {
            if (dividend >= 0) {
                return dividend / divisor;
            }
            // The implementation is a Java port of algorithm described in the book
            // "Hacker's Delight" (section "Unsigned short division from signed division").
            int q = ((dividend >>> 1) / divisor) << 1;
            dividend -= q * divisor;
            if (dividend < 0L || dividend >= divisor) {
                q++;
            }
            return q;
        }
        return dividend >= 0 || dividend < divisor ? 0 : 1;
    }

        use significant names that are related to the method name
*/

    @Test
    void testDivideUnsignedDividendPositiveDivisorPositive() {
        int dividend = 2;
        int divisor = 3;
        int result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDivideUnsignedDividendPositiveDivisorNegative() {
        int dividend = 2;
        int divisor = -3;
        int result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDivideUnsignedDividendNegativeDivisorPositive() {
        int dividend = -2;
        int divisor = 3;
        int result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(1431655764, result);
    }

    @Test
    void testDivideUnsignedDividendNegativeDivisorNegative() {
        int dividend = -2;
        int divisor = -3;
        int result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(1431655764, result);
    }

    @Test
    void testDivideUnsignedDividendZeroDivisorPositive() {
        int dividend = 0;
        int divisor = 3;
        int result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDivideUnsignedDividendPositiveDivisorZero() {
        int dividend = 2;
        int divisor = 0;
        try {
            ArithmeticUtils.divideUnsigned(dividend, divisor);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException ex) {
            // expected
        }
    }

    @Test
    void testDivideUnsignedDividendNegativeDivisorZero() {
        int dividend = -2;
        int divisor = 0;
        try {
            ArithmeticUtils.divideUnsigned(dividend, divisor);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException ex) {
            // expected
        }
    }

    @Test
    void testDivideUnsignedDividendMaxDivisorPositive() {
        int dividend = Integer.MAX_VALUE;
        int divisor = 3;
        int result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(715827882, result);
    }

    @Test
    void testDivideUnsignedDividendMaxDivisorNegative() {
        int dividend = Integer.MAX_VALUE;
        int divisor = -3;
        int result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(715827882, result);
    }

    @Test
    void testDivideUnsignedDividendMinDivisorPositive() {
        int dividend = Integer.MIN_VALUE;
        int divisor = 3;
        int result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(715827882, result);
    }

    @Test
    void testDivideUnsignedDividendMinDivisorNegative() {
        int dividend = Integer.MIN_VALUE;
        int divisor = -3;
        int result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(715827882, result);
    }

    @Test
    void testDivideUnsignedDividendMaxDivisorZero() {
        int dividend = Integer.MAX_VALUE;
        int divisor = 0;
        try {
            ArithmeticUtils.divideUnsigned(dividend, divisor);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException ex) {
            // expected
        }
    }

    @Test
    void testDivideUnsignedDividendMinDivisorZero() {
        int dividend = Integer.MIN_VALUE;
        int divisor = 0;
        try {
            ArithmeticUtils.divideUnsigned(dividend, divisor);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException ex) {
            // expected
        }
    }

    @Test
    void testDivideUnsignedDividendZeroDivisorMax() {
        int dividend = 0;
        int divisor = Integer.MAX_VALUE;
        int result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDivideUnsignedDividendZeroDivisorMin() {
        int dividend = 0;
        int divisor = Integer.MIN_VALUE;
        int result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDivideUnsignedDividendMaxDivisorMax() {
        int dividend = Integer.MAX_VALUE;
        int divisor = Integer.MAX_VALUE;
        int result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testDivideUnsignedDividendMinDivisorMin() {
        int dividend = Integer.MIN_VALUE;
        int divisor = Integer.MIN_VALUE;
        int result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(1, result);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:
    public static long divideUnsigned(long dividend, long divisor) {
        if (divisor >= 0L) {
            if (dividend >= 0L) {
                return dividend / divisor;
            }
            // The implementation is a Java port of algorithm described in the book
            // "Hacker's Delight" (section "Unsigned short division from signed division").
            long q = ((dividend >>> 1) / divisor) << 1;
            dividend -= q * divisor;
            if (dividend < 0L || dividend >= divisor) {
                q++;
            }
            return q;
        }
        return dividend >= 0L || dividend < divisor ? 0L : 1L;
    }

        use significant names that are related to the method name
*/

    @Test
    void testDivideUnsignedLongDividendPositiveDivisorPositive() {
        long dividend = 2;
        long divisor = 3;
        long result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDivideUnsignedLongDividendPositiveDivisorNegative() {
        long dividend = 2;
        long divisor = -3;
        long result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDivideUnsignedLongDividendNegativeDivisorPositive() {
        long dividend = -2;
        long divisor = 3;
        long result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(6148914691236517204L, result);
    }

    @Test
    void testDivideUnsignedLongDividendNegativeDivisorNegative() {
        long dividend = -2;
        long divisor = -3;
        long result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(6148914691236517204L, result);
    }

    @Test
    void testDivideUnsignedLongDividendZeroDivisorPositive() {
        long dividend = 0;
        long divisor = 3;
        long result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDivideUnsignedLongDividendPositiveDivisorZero() {
        long dividend = 2;
        long divisor = 0;
        try {
            ArithmeticUtils.divideUnsigned(dividend, divisor);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException ex) {
            // expected
        }
    }

    @Test
    void testDivideUnsignedLongDividendNegativeDivisorZero() {
        long dividend = -2;
        long divisor = 0;
        try {
            ArithmeticUtils.divideUnsigned(dividend, divisor);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException ex) {
            // expected
        }
    }

    @Test
    void testDivideUnsignedLongDividendMaxDivisorPositive() {
        long dividend = Long.MAX_VALUE;
        long divisor = 3;
        long result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(3074457345618258602L, result);
    }

    @Test
    void testDivideUnsignedLongDividendMaxDivisorNegative() {
        long dividend = Long.MAX_VALUE;
        long divisor = -3;
        long result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(3074457345618258602L, result);
    }

    @Test
    void testDivideUnsignedLongDividendMinDivisorPositive() {
        long dividend = Long.MIN_VALUE;
        long divisor = 3;
        long result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(3074457345618258602L, result);
    }

    @Test
    void testDivideUnsignedLongDividendMinDivisorNegative() {
        long dividend = Long.MIN_VALUE;
        long divisor = -3;
        long result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(3074457345618258602L, result);
    }

    @Test
    void testDivideUnsignedLongDividendMaxDivisorZero() {
        long dividend = Long.MAX_VALUE;
        long divisor = 0;
        try {
            ArithmeticUtils.divideUnsigned(dividend, divisor);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException ex) {
            // expected
        }
    }

    @Test
    void testDivideUnsignedLongDividendMinDivisorZero() {
        long dividend = Long.MIN_VALUE;
        long divisor = 0;
        try {
            ArithmeticUtils.divideUnsigned(dividend, divisor);
            Assertions.fail("an exception should have been thrown");
        } catch (ArithmeticException ex) {
            // expected
        }
    }

    @Test
    void testDivideUnsignedLongDividendZeroDivisorMax() {
        long dividend = 0;
        long divisor = Long.MAX_VALUE;
        long result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDivideUnsignedLongDividendZeroDivisorMin() {
        long dividend = 0;
        long divisor = Long.MIN_VALUE;
        long result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDivideUnsignedLongDividendMaxDivisorMax() {
        long dividend = Long.MAX_VALUE;
        long divisor = Long.MAX_VALUE;
        long result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testDivideUnsignedLongDividendMinDivisorMin() {
        long dividend = Long.MIN_VALUE;
        long divisor = Long.MIN_VALUE;
        long result = ArithmeticUtils.divideUnsigned(dividend, divisor);
        Assertions.assertEquals(1, result);
    }
}