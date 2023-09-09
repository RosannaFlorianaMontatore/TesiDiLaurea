package org.apache.commons.math4.legacy.core;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

import org.apache.commons.numbers.core.Precision;
import org.apache.commons.math4.legacy.exception.DimensionMismatchException;
import org.apache.commons.math4.legacy.exception.MathArithmeticException;
import org.apache.commons.math4.legacy.exception.MathIllegalArgumentException;
import org.apache.commons.math4.legacy.exception.MathInternalError;
import org.apache.commons.math4.legacy.exception.NoDataException;
import org.apache.commons.math4.legacy.exception.NonMonotonicSequenceException;
import org.apache.commons.math4.legacy.exception.NotANumberException;
import org.apache.commons.math4.legacy.exception.NotPositiveException;
import org.apache.commons.math4.legacy.exception.NotStrictlyPositiveException;
import org.apache.commons.math4.legacy.exception.NullArgumentException;
import org.apache.commons.math4.legacy.exception.NumberIsTooLargeException;
import org.apache.commons.math4.legacy.exception.util.LocalizedFormats;
import org.apache.commons.math4.legacy.core.jdkmath.AccurateMath;
import org.junit.Test;
import org.apache.commons.math4.legacy.core.MathArrays;
import org.apache.commons.math4.legacy.core.MathArrays.OrderDirection;
import static org.junit.jupiter.api.Assertions.*;

public class MathArraysCopilotTest {

    public MathArraysCopilotTest() {
    }

/*create a test suite for this method:

        public static double[] scale(double val, final double[] arr) {
            double[] newArr = new double[arr.length];
            for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i] * val;
            }
            return newArr;
            }

            use significant names that are related to the method name
     */

    //Test the method scale with a positive value
    @Test
    public void testScalePositive() {
        double[] arr = {1.0, 2.0, 3.0};
        double val = 2.0;
        double[] expResult = {2.0, 4.0, 6.0};
        double[] result = MathArrays.scale(val, arr);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method scale with a negative value
    @Test
    public void testScaleNegative() {
        double[] arr = {1.0, 2.0, 3.0};
        double val = -2.0;
        double[] expResult = {-2.0, -4.0, -6.0};
        double[] result = MathArrays.scale(val, arr);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method scale with a zero value
    @Test
    public void testScaleZero() {
        double[] arr = {1.0, 2.0, 3.0};
        double val = 0.0;
        double[] expResult = {0.0, 0.0, 0.0};
        double[] result = MathArrays.scale(val, arr);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method scale with an empty array
    @Test
    public void testScaleEmpty() {
        double[] arr = {};
        double val = 2.0;
        double[] expResult = {};
        double[] result = MathArrays.scale(val, arr);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method scale with a null array
    @Test
    public void testScaleNull() {
        double[] arr = null;
        double val = 2.0;
        double[] expResult = null;
        double[] result = MathArrays.scale(val, arr);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method scale with a positive value and a null array
    @Test
    public void testScalePositiveNull() {
        double[] arr = null;
        double val = 2.0;
        double[] expResult = null;
        double[] result = MathArrays.scale(val, arr);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method scale with a negative value and a null array
    @Test
    public void testScaleNegativeNull() {
        double[] arr = null;
        double val = -2.0;
        double[] expResult = null;
        double[] result = MathArrays.scale(val, arr);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method scale with a zero value and a null array
    @Test
    public void testScaleZeroNull() {
        double[] arr = null;
        double val = 0.0;
        double[] expResult = null;
        double[] result = MathArrays.scale(val, arr);
        assertArrayEquals(expResult, result, 0.0);
    }
//___________________________________________________________________________________________________________________

/*create a test suite for this method:

   public static void scaleInPlace(double val, final double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= val;
        }
    }
        use significant names that are related to the method name
 */

    //Test the method scaleInPlace with a positive value
    @Test
    public void testScaleInPlacePositive() {
        double[] arr = {1.0, 2.0, 3.0};
        double val = 2.0;
        MathArrays.scaleInPlace(val, arr);
        double[] expResult = {2.0, 4.0, 6.0};
        assertArrayEquals(expResult, arr, 0.0);
    }

    //Test the method scaleInPlace with a negative value
    @Test
    public void testScaleInPlaceNegative() {
        double[] arr = {1.0, 2.0, 3.0};
        double val = -2.0;
        MathArrays.scaleInPlace(val, arr);
        double[] expResult = {-2.0, -4.0, -6.0};
        assertArrayEquals(expResult, arr, 0.0);
    }

    //Test the method scaleInPlace with a zero value
    @Test
    public void testScaleInPlaceZero() {
        double[] arr = {1.0, 2.0, 3.0};
        double val = 0.0;
        MathArrays.scaleInPlace(val, arr);
        double[] expResult = {0.0, 0.0, 0.0};
        assertArrayEquals(expResult, arr, 0.0);
    }

    //Test the method scaleInPlace with an empty array
    @Test
    public void testScaleInPlaceEmpty() {
        double[] arr = {};
        double val = 2.0;
        MathArrays.scaleInPlace(val, arr);
        double[] expResult = {};
        assertArrayEquals(expResult, arr, 0.0);
    }

    //Test the method scaleInPlace with a null array
    @Test
    public void testScaleInPlaceNull() {
        double[] arr = null;
        double val = 2.0;
        MathArrays.scaleInPlace(val, arr);
        double[] expResult = null;
        assertArrayEquals(expResult, arr, 0.0);
    }

    //Test the method scaleInPlace with a positive value and a null array
    @Test
    public void testScaleInPlacePositiveNull() {
        double[] arr = null;
        double val = 2.0;
        MathArrays.scaleInPlace(val, arr);
        double[] expResult = null;
        assertArrayEquals(expResult, arr, 0.0);
    }

    //Test the method scaleInPlace with a negative value and a null array
    @Test
    public void testScaleInPlaceNegativeNull() {
        double[] arr = null;
        double val = -2.0;
        MathArrays.scaleInPlace(val, arr);
        double[] expResult = null;
        assertArrayEquals(expResult, arr, 0.0);
    }

    //Test the method scaleInPlace with a zero value and a null array
    @Test
    public void testScaleInPlaceZeroNull() {
        double[] arr = null;
        double val = 0.0;
        MathArrays.scaleInPlace(val, arr);
        double[] expResult = null;
        assertArrayEquals(expResult, arr, 0.0);
    }
//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static boolean checkEqualLength(double[] a,
                                           double[] b,
                                           boolean abort) {
        if (a.length == b.length) {
            return true;
        } else {
            if (abort) {
                throw new DimensionMismatchException(a.length, b.length);
            }
            return false;
        }
    }
    use significant names that are related to the method name
 */

    //Test the method checkEqualLength with equal length arrays
    @Test
    public void testCheckEqualLengthEqualLength() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {1.0, 2.0, 3.0};
        boolean abort = false;
        boolean expResult = true;
        boolean result = MathArrays.checkEqualLength(a, b, abort);
        assertEquals(expResult, result);
    }

    //Test the method checkEqualLength with unequal length arrays and abort = false
    @Test
    public void testCheckEqualLengthUnequalLengthFalse() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {1.0, 2.0};
        boolean abort = false;
        boolean expResult = false;
        boolean result = MathArrays.checkEqualLength(a, b, abort);
        assertEquals(expResult, result);
    }

    //Test the method checkEqualLength with unequal length arrays and abort = true
    @Test(expected = DimensionMismatchException.class)
    public void testCheckEqualLengthUnequalLengthTrue() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {1.0, 2.0};
        boolean abort = true;
        boolean expResult = false;
        boolean result = MathArrays.checkEqualLength(a, b, abort);
        assertEquals(expResult, result);
    }

    //Test the method checkEqualLength with a null array
    @Test(expected = NullPointerException.class)
    public void testCheckEqualLengthNull() {
        double[] a = null;
        double[] b = {1.0, 2.0};
        boolean abort = true;
        boolean expResult = false;
        boolean result = MathArrays.checkEqualLength(a, b, abort);
        assertEquals(expResult, result);
    }

    //Test the method checkEqualLength with a null array and abort = true
    @Test(expected = NullPointerException.class)
    public void testCheckEqualLengthNullTrue() {
        double[] a = null;
        double[] b = {1.0, 2.0};
        boolean abort = true;
        boolean expResult = false;
        boolean result = MathArrays.checkEqualLength(a, b, abort);
        assertEquals(expResult, result);
    }

    //Test the method checkEqualLength with an empty array
    @Test
    public void testCheckEqualLengthEmpty() {
        double[] a = {};
        double[] b = {};
        boolean abort = false;
        boolean expResult = true;
        boolean result = MathArrays.checkEqualLength(a, b, abort);
        assertEquals(expResult, result);
    }

    //Test the method checkEqualLength with an empty array and abort = true
    @Test(expected = DimensionMismatchException.class)
    public void testCheckEqualLengthEmptyTrue() {
        double[] a = {};
        double[] b = {};
        boolean abort = true;
        boolean expResult = true;
        boolean result = MathArrays.checkEqualLength(a, b, abort);
        assertEquals(expResult, result);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static void checkEqualLength(double[] a,
                                        double[] b) {
        checkEqualLength(a, b, true);
    }

    use significant names that are related to the method name
 */

    //Test the method checkEqualLength with equal length arrays
    @Test
    public void testCheckEqualLengthEqualLength2() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {1.0, 2.0, 3.0};
        MathArrays.checkEqualLength(a, b);
    }

    //Test the method checkEqualLength with unequal length arrays and abort = false
    @Test(expected = DimensionMismatchException.class)
    public void testCheckEqualLengthUnequalLengthFalse2() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {1.0, 2.0};
        MathArrays.checkEqualLength(a, b);
    }

    //Test the method checkEqualLength with a null array
    @Test(expected = NullPointerException.class)
    public void testCheckEqualLengthNull2() {
        double[] a = null;
        double[] b = {1.0, 2.0};
        MathArrays.checkEqualLength(a, b);
    }

    //Test the method checkEqualLength with an empty array
    @Test
    public void testCheckEqualLengthEmpty2() {
        double[] a = {};
        double[] b = {};
        MathArrays.checkEqualLength(a, b);
    }

    //Test the method checkEqualLength with an empty array and abort = true
    @Test(expected = DimensionMismatchException.class)
    public void testCheckEqualLengthEmptyTrue2() {
        double[] a = {};
        double[] b = {};
        MathArrays.checkEqualLength(a, b);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static boolean checkEqualLength(int[] a,
                                           int[] b,
                                           boolean abort) {
        if (a.length == b.length) {
            return true;
        } else {
            if (abort) {
                throw new DimensionMismatchException(a.length, b.length);
            }
            return false;
        }
    }
    use significant names that are related to the method name
 */

    //Test the method checkEqualLength with equal length arrays
    @Test
    public void testCheckEqualLengthIntEqualLength() {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        boolean abort = false;
        boolean expResult = true;
        boolean result = MathArrays.checkEqualLength(a, b, abort);
        assertEquals(expResult, result);
    }

    //Test the method checkEqualLength with unequal length arrays and abort = false
    @Test
    public void testCheckEqualLengthIntUnequalLengthFalse() {
        int[] a = {1, 2, 3};
        int[] b = {1, 2};
        boolean abort = false;
        boolean expResult = false;
        boolean result = MathArrays.checkEqualLength(a, b, abort);
        assertEquals(expResult, result);
    }

    //Test the method checkEqualLength with unequal length arrays and abort = true
    @Test(expected = DimensionMismatchException.class)
    public void testCheckEqualLengthIntUnequalLengthTrue() {
        int[] a = {1, 2, 3};
        int[] b = {1, 2};
        boolean abort = true;
        boolean expResult = false;
        boolean result = MathArrays.checkEqualLength(a, b, abort);
        assertEquals(expResult, result);
    }

    //Test the method checkEqualLength with a null array
    @Test(expected = NullPointerException.class)
    public void testCheckEqualLengthIntNull() {
        int[] a = null;
        int[] b = {1, 2};
        boolean abort = true;
        boolean expResult = false;
        boolean result = MathArrays.checkEqualLength(a, b, abort);
        assertEquals(expResult, result);
    }

    //Test the method checkEqualLength with an empty array
    @Test
    public void testCheckEqualLengthIntEmpty() {
        int[] a = {};
        int[] b = {};
        boolean abort = false;
        boolean expResult = true;
        boolean result = MathArrays.checkEqualLength(a, b, abort);
        assertEquals(expResult, result);
    }

    //Test the method checkEqualLength with an empty array and abort = true
    @Test(expected = DimensionMismatchException.class)
    public void testCheckEqualLengthIntEmptyTrue() {
        int[] a = {};
        int[] b = {};
        boolean abort = true;
        boolean expResult = true;
        boolean result = MathArrays.checkEqualLength(a, b, abort);
        assertEquals(expResult, result);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static void checkEqualLength(int[] a,
                                        int[] b) {
        checkEqualLength(a, b, true);
    }

    use significant names that are related to the method name
 */

    //Test the method checkEqualLength with equal length arrays
    @Test
    public void testCheckEqualLengthIntEqualLength2() {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        MathArrays.checkEqualLength(a, b);
    }

    //Test the method checkEqualLength with unequal length arrays and abort = false
    @Test(expected = DimensionMismatchException.class)
    public void testCheckEqualLengthIntUnequalLengthFalse2() {
        int[] a = {1, 2, 3};
        int[] b = {1, 2};
        MathArrays.checkEqualLength(a, b);
    }

    //Test the method checkEqualLength with a null array
    @Test(expected = NullPointerException.class)
    public void testCheckEqualLengthIntNull2() {
        int[] a = null;
        int[] b = {1, 2};
        MathArrays.checkEqualLength(a, b);
    }

    //Test the method checkEqualLength with an empty array
    @Test
    public void testCheckEqualLengthIntEmpty2() {
        int[] a = {};
        int[] b = {};
        MathArrays.checkEqualLength(a, b);
    }

    //Test the method checkEqualLength with an empty array and abort = true
    @Test(expected = DimensionMismatchException.class)
    public void testCheckEqualLengthIntEmptyTrue2() {
        int[] a = {};
        int[] b = {};
        MathArrays.checkEqualLength(a, b);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static double[] ebeAdd(double[] a, double[] b) {
        checkEqualLength(a, b);

        final double[] result = a.clone();
        for (int i = 0; i < a.length; i++) {
            result[i] += b[i];
        }
        return result;
    }

    use significant names that are related to the method name
 */

    //Test the method ebeAdd with two positive arrays
    @Test
    public void testEbeAddPositive() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {4.0, 5.0, 6.0};
        double[] expResult = {5.0, 7.0, 9.0};
        double[] result = MathArrays.ebeAdd(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeAdd with two negative arrays
    @Test
    public void testEbeAddNegative() {
        double[] a = {-1.0, -2.0, -3.0};
        double[] b = {-4.0, -5.0, -6.0};
        double[] expResult = {-5.0, -7.0, -9.0};
        double[] result = MathArrays.ebeAdd(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeAdd with a positive and a negative array
    @Test
    public void testEbeAddPositiveNegative() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {-4.0, -5.0, -6.0};
        double[] expResult = {-3.0, -3.0, -3.0};
        double[] result = MathArrays.ebeAdd(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeAdd with two empty arrays
    @Test
    public void testEbeAddEmpty() {
        double[] a = {};
        double[] b = {};
        double[] expResult = {};
        double[] result = MathArrays.ebeAdd(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeAdd with two arrays of different lengths

    @Test(expected = DimensionMismatchException.class)
    public void testEbeAddDifferentLengths() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {4.0, 5.0};
        double[] result = MathArrays.ebeAdd(a, b);
    }

    //Test the method ebeAdd with a positive array and a NaN array
    @Test
    public void testEbeAddPositiveNaN() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {Double.NaN, Double.NaN, Double.NaN};
        double[] expResult = {Double.NaN, Double.NaN, Double.NaN};
        double[] result = MathArrays.ebeAdd(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeAdd with a positive array and a positive infinity array
    @Test
    public void testEbeAddPositiveInfinity() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
        double[] expResult = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
        double[] result = MathArrays.ebeAdd(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeAdd with a positive array and a negative infinity array
    @Test
    public void testEbeAddPositiveInfinityNegative() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY};
        double[] expResult = {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY};
        double[] result = MathArrays.ebeAdd(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeAdd with a positive array and a positive zero array
    @Test
    public void testEbeAddPositiveZero() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {0.0, 0.0, 0.0};
        double[] expResult = {1.0, 2.0, 3.0};
        double[] result = MathArrays.ebeAdd(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

//___________________________________________________________________________________________________________________

    //Test the method ebeSubtract with two positive arrays
    @Test
    public void testEbeSubtractPositive() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {4.0, 5.0, 6.0};
        double[] expResult = {-3.0, -3.0, -3.0};
        double[] result = MathArrays.ebeSubtract(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeSubtract with two negative arrays
    @Test
    public void testEbeSubtractNegative() {
        double[] a = {-1.0, -2.0, -3.0};
        double[] b = {-4.0, -5.0, -6.0};
        double[] expResult = {3.0, 3.0, 3.0};
        double[] result = MathArrays.ebeSubtract(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeSubtract with a positive and a negative array
    @Test
    public void testEbeSubtractPositiveNegative() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {-4.0, -5.0, -6.0};
        double[] expResult = {5.0, 7.0, 9.0};
        double[] result = MathArrays.ebeSubtract(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeSubtract with two empty arrays
    @Test
    public void testEbeSubtractEmpty() {
        double[] a = {};
        double[] b = {};
        double[] expResult = {};
        double[] result = MathArrays.ebeSubtract(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeSubtract with two arrays of different lengths

    @Test(expected = DimensionMismatchException.class)
    public void testEbeSubtractDifferentLengths() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {4.0, 5.0};
        double[] result = MathArrays.ebeSubtract(a, b);
    }

    //Test the method ebeSubtract with a positive array and a NaN array
    @Test
    public void testEbeSubtractPositiveNaN() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {Double.NaN, Double.NaN, Double.NaN};
        double[] expResult = {Double.NaN, Double.NaN, Double.NaN};
        double[] result = MathArrays.ebeSubtract(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeSubtract with a positive array and a positive infinity array
    @Test
    public void testEbeSubtractPositiveInfinity() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
        double[] expResult = {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY};
        double[] result = MathArrays.ebeSubtract(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

//___________________________________________________________________________________________________________________

    //Test the method ebeMultiply with two positive arrays
    @Test
    public void testEbeMultiplyPositive() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {4.0, 5.0, 6.0};
        double[] expResult = {4.0, 10.0, 18.0};
        double[] result = MathArrays.ebeMultiply(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeMultiply with two negative arrays
    @Test
    public void testEbeMultiplyNegative() {
        double[] a = {-1.0, -2.0, -3.0};
        double[] b = {-4.0, -5.0, -6.0};
        double[] expResult = {4.0, 10.0, 18.0};
        double[] result = MathArrays.ebeMultiply(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeMultiply with a positive and a negative array
    @Test
    public void testEbeMultiplyPositiveNegative() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {-4.0, -5.0, -6.0};
        double[] expResult = {-4.0, -10.0, -18.0};
        double[] result = MathArrays.ebeMultiply(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeMultiply with two empty arrays
    @Test
    public void testEbeMultiplyEmpty() {
        double[] a = {};
        double[] b = {};
        double[] expResult = {};
        double[] result = MathArrays.ebeMultiply(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeMultiply with two arrays of different lengths

    @Test(expected = DimensionMismatchException.class)
    public void testEbeMultiplyDifferentLengths() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {4.0, 5.0};
        double[] result = MathArrays.ebeMultiply(a, b);
    }

    //Test the method ebeMultiply with a positive array and a NaN array
    @Test
    public void testEbeMultiplyPositiveNaN() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {Double.NaN, Double.NaN, Double.NaN};
        double[] expResult = {Double.NaN, Double.NaN, Double.NaN};
        double[] result = MathArrays.ebeMultiply(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeMultiply with a positive array and a positive infinity array
    @Test
    public void testEbeMultiplyPositiveInfinity() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
        double[] expResult = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
        double[] result = MathArrays.ebeMultiply(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

//___________________________________________________________________________________________________________________

    //Test the method ebeDivide with two positive arrays
    @Test
    public void testEbeDividePositive() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {4.0, 5.0, 6.0};
        double[] expResult = {0.25, 0.4, 0.5};
        double[] result = MathArrays.ebeDivide(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeDivide with two negative arrays
    @Test
    public void testEbeDivideNegative() {
        double[] a = {-1.0, -2.0, -3.0};
        double[] b = {-4.0, -5.0, -6.0};
        double[] expResult = {0.25, 0.4, 0.5};
        double[] result = MathArrays.ebeDivide(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeDivide with a positive and a negative array
    @Test
    public void testEbeDividePositiveNegative() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {-4.0, -5.0, -6.0};
        double[] expResult = {-0.25, -0.4, -0.5};
        double[] result = MathArrays.ebeDivide(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeDivide with two empty arrays
    @Test
    public void testEbeDivideEmpty() {
        double[] a = {};
        double[] b = {};
        double[] expResult = {};
        double[] result = MathArrays.ebeDivide(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeDivide with two arrays of different lengths

    @Test(expected = DimensionMismatchException.class)
    public void testEbeDivideDifferentLengths() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {4.0, 5.0};
        double[] result = MathArrays.ebeDivide(a, b);
    }

    //Test the method ebeDivide with a positive array and a NaN array
    @Test
    public void testEbeDividePositiveNaN() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {Double.NaN, Double.NaN, Double.NaN};
        double[] expResult = {Double.NaN, Double.NaN, Double.NaN};
        double[] result = MathArrays.ebeDivide(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

    //Test the method ebeDivide with a positive array and a positive infinity array
    @Test
    public void testEbeDividePositiveInfinity() {
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
        double[] expResult = {0.0, 0.0, 0.0};
        double[] result = MathArrays.ebeDivide(a, b);
        assertArrayEquals(expResult, result, 0.0);
    }

//___________________________________________________________________________________________________________________
/*create a test suite for this method:

    public static double distance1(double[] p1, double[] p2) {
        checkEqualLength(p1, p2);
        double sum = 0;
        for (int i = 0; i < p1.length; i++) {
            sum += AccurateMath.abs(p1[i] - p2[i]);
        }
        return sum;
    }
    use significant names that are related to the method name
 */

    //Test the method distance1 with two positive arrays
    @Test
    public void testDistance1Positive() {
        double[] p1 = {1.0, 2.0, 3.0};
        double[] p2 = {4.0, 5.0, 6.0};
        double expResult = 9.0;
        double result = MathArrays.distance1(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distance1 with two negative arrays
    @Test
    public void testDistance1Negative() {
        double[] p1 = {-1.0, -2.0, -3.0};
        double[] p2 = {-4.0, -5.0, -6.0};
        double expResult = 9.0;
        double result = MathArrays.distance1(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distance1 with a positive and a negative array
    @Test
    public void testDistance1PositiveNegative() {
        double[] p1 = {1.0, 2.0, 3.0};
        double[] p2 = {-4.0, -5.0, -6.0};
        double expResult = 21.0;
        double result = MathArrays.distance1(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distance1 with two empty arrays
    @Test
    public void testDistance1Empty() {
        double[] p1 = {};
        double[] p2 = {};
        double expResult = 0.0;
        double result = MathArrays.distance1(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distance1 with two arrays of different lengths
    @Test(expected = DimensionMismatchException.class)
    public void testDistance1DifferentLengths() {
        double[] p1 = {1.0, 2.0, 3.0};
        double[] p2 = {4.0, 5.0};
        double result = MathArrays.distance1(p1, p2);
    }

    //Test the method distance1 with a NaN array
    @Test
    public void testDistance1NaN() {
        double[] p1 = {Double.NaN, Double.NaN, Double.NaN};
        double[] p2 = {Double.NaN, Double.NaN, Double.NaN};
        double expResult = Double.NaN;
        double result = MathArrays.distance1(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distance1 with a positive infinity array
    @Test
    public void testDistance1PositiveInfinity() {
        double[] p1 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
        double[] p2 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
        double expResult = Double.POSITIVE_INFINITY;
        double result = MathArrays.distance1(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static int distance1(int[] p1, int[] p2) {
        checkEqualLength(p1, p2);
        int sum = 0;
        for (int i = 0; i < p1.length; i++) {
            sum += AccurateMath.abs(p1[i] - p2[i]);
        }
        return sum;
    }
    use significant names that are related to the method name
 */

    //Test the method distance1 with two positive arrays
    @Test
    public void testDistance1IntPositive() {
        int[] p1 = {1, 2, 3};
        int[] p2 = {4, 5, 6};
        int expResult = 9;
        int result = MathArrays.distance1(p1, p2);
        assertEquals(expResult, result);
    }

    //Test the method distance1 with two negative arrays
    @Test
    public void testDistance1IntNegative() {
        int[] p1 = {-1, -2, -3};
        int[] p2 = {-4, -5, -6};
        int expResult = 9;
        int result = MathArrays.distance1(p1, p2);
        assertEquals(expResult, result);
    }

    //Test the method distance1 with a positive and a negative array
    @Test
    public void testDistance1IntPositiveNegative() {
        int[] p1 = {1, 2, 3};
        int[] p2 = {-4, -5, -6};
        int expResult = 21;
        int result = MathArrays.distance1(p1, p2);
        assertEquals(expResult, result);
    }

    //Test the method distance1 with two empty arrays
    @Test
    public void testDistance1IntEmpty() {
        int[] p1 = {};
        int[] p2 = {};
        int expResult = 0;
        int result = MathArrays.distance1(p1, p2);
        assertEquals(expResult, result);
    }

    //Test the method distance1 with two arrays of different lengths
    @Test(expected = DimensionMismatchException.class)
    public void testDistance1IntDifferentLengths() {
        int[] p1 = {1, 2, 3};
        int[] p2 = {4, 5};
        int result = MathArrays.distance1(p1, p2);
    }

    //Test the method distance1 with a NaN array
    @Test
    public void testDistance1IntNaN() {
        int[] p1 = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] p2 = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int expResult = 0;
        int result = MathArrays.distance1(p1, p2);
        assertEquals(expResult, result);
    }

//___________________________________________________________________________________________________________________

 /*create a test suite for this method:

    public static double distance(double[] p1, double[] p2) {
        checkEqualLength(p1, p2);
        double sum = 0;
        for (int i = 0; i < p1.length; i++) {
            final double dp = p1[i] - p2[i];
            sum += dp * dp;
        }
        return AccurateMath.sqrt(sum);
    }
    use significant names that are related to the method name
 */

    //Test the method distance with two positive arrays
    @Test
    public void testDistancePositive() {
        double[] p1 = {1.0, 2.0, 3.0};
        double[] p2 = {4.0, 5.0, 6.0};
        double expResult = 5.196152422706632;
        double result = MathArrays.distance(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distance with two negative arrays
    @Test
    public void testDistanceNegative() {
        double[] p1 = {-1.0, -2.0, -3.0};
        double[] p2 = {-4.0, -5.0, -6.0};
        double expResult = 5.196152422706632;
        double result = MathArrays.distance(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distance with a positive and a negative array
    @Test
    public void testDistancePositiveNegative() {
        double[] p1 = {1.0, 2.0, 3.0};
        double[] p2 = {-4.0, -5.0, -6.0};
        double expResult = 11.224972160321824;
        double result = MathArrays.distance(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distance with two empty arrays
    @Test
    public void testDistanceEmpty() {
        double[] p1 = {};
        double[] p2 = {};
        double expResult = 0.0;
        double result = MathArrays.distance(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distance with two arrays of different lengths
    @Test(expected = DimensionMismatchException.class)
    public void testDistanceDifferentLengths() {
        double[] p1 = {1.0, 2.0, 3.0};
        double[] p2 = {4.0, 5.0};
        double result = MathArrays.distance(p1, p2);
    }

    //Test the method distance with a NaN array
    @Test
    public void testDistanceNaN() {
        double[] p1 = {Double.NaN, Double.NaN, Double.NaN};
        double[] p2 = {Double.NaN, Double.NaN, Double.NaN};
        double expResult = Double.NaN;
        double result = MathArrays.distance(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distance with a positive infinity array
    @Test
    public void testDistancePositiveInfinity() {
        double[] p1 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
        double[] p2 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
        double expResult = Double.POSITIVE_INFINITY;
        double result = MathArrays.distance(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

//___________________________________________________________________________________________________________________

 /*create a test suite for this method:

public static double distance(int[] p1, int[] p2) {
        checkEqualLength(p1, p2);
        double sum = 0;
        for (int i = 0; i < p1.length; i++) {
            final double dp = (double) p1[i] - p2[i];
            sum += dp * dp;
        }
        return AccurateMath.sqrt(sum);
    }
    use significant names that are related to the method name
 */

    //Test the method distance with two positive arrays
    @Test
    public void testDistanceIntPositive() {
        int[] p1 = {1, 2, 3};
        int[] p2 = {4, 5, 6};
        double expResult = 5.196152422706632;
        double result = MathArrays.distance(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distance with two negative arrays
    @Test
    public void testDistanceIntNegative() {
        int[] p1 = {-1, -2, -3};
        int[] p2 = {-4, -5, -6};
        double expResult = 5.196152422706632;
        double result = MathArrays.distance(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distance with a positive and a negative array
    @Test
    public void testDistanceIntPositiveNegative() {
        int[] p1 = {1, 2, 3};
        int[] p2 = {-4, -5, -6};
        double expResult = 11.224972160321824;
        double result = MathArrays.distance(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distance with two empty arrays
    @Test
    public void testDistanceIntEmpty() {
        int[] p1 = {};
        int[] p2 = {};
        double expResult = 0.0;
        double result = MathArrays.distance(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distance with two arrays of different lengths
    @Test(expected = DimensionMismatchException.class)
    public void testDistanceIntDifferentLengths() {
        int[] p1 = {1, 2, 3};
        int[] p2 = {4, 5};
        double result = MathArrays.distance(p1, p2);
    }

    //Test the method distance with a NaN array
    @Test
    public void testDistanceIntNaN() {
        int[] p1 = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] p2 = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        double expResult = Double.POSITIVE_INFINITY;
        double result = MathArrays.distance(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static double distanceInf(double[] p1, double[] p2) {
        checkEqualLength(p1, p2);
        double max = 0;
        for (int i = 0; i < p1.length; i++) {
            max = AccurateMath.max(max, AccurateMath.abs(p1[i] - p2[i]));
        }
        return max;
    }
    use significant names that are related to the method name
 */

    //Test the method distanceInf with two positive arrays
    @Test
    public void testDistanceInfPositive() {
        double[] p1 = {1.0, 2.0, 3.0};
        double[] p2 = {4.0, 5.0, 6.0};
        double expResult = 3.0;
        double result = MathArrays.distanceInf(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distanceInf with two negative arrays
    @Test
    public void testDistanceInfNegative() {
        double[] p1 = {-1.0, -2.0, -3.0};
        double[] p2 = {-4.0, -5.0, -6.0};
        double expResult = 3.0;
        double result = MathArrays.distanceInf(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distanceInf with a positive and a negative array
    @Test
    public void testDistanceInfPositiveNegative() {
        double[] p1 = {1.0, 2.0, 3.0};
        double[] p2 = {-4.0, -5.0, -6.0};
        double expResult = 9.0;
        double result = MathArrays.distanceInf(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distanceInf with two empty arrays
    @Test
    public void testDistanceInfEmpty() {
        double[] p1 = {};
        double[] p2 = {};
        double expResult = 0.0;
        double result = MathArrays.distanceInf(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distanceInf with two arrays of different lengths
    @Test(expected = DimensionMismatchException.class)
    public void testDistanceInfDifferentLengths() {
        double[] p1 = {1.0, 2.0, 3.0};
        double[] p2 = {4.0, 5.0};
        double result = MathArrays.distanceInf(p1, p2);
    }

    //Test the method distanceInf with a NaN array
    @Test
    public void testDistanceInfNaN() {
        double[] p1 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
        double[] p2 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
        double expResult = Double.POSITIVE_INFINITY;
        double result = MathArrays.distanceInf(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static int distanceInf(int[] p1, int[] p2) {
        checkEqualLength(p1, p2);
        int max = 0;
        for (int i = 0; i < p1.length; i++) {
            max = AccurateMath.max(max, AccurateMath.abs(p1[i] - p2[i]));
        }
        return max;
    }
    use significant names that are related to the method name
 */

    //Test the method distanceInf with two positive arrays
    @Test
    public void testDistanceInfIntPositive() {
        int[] p1 = {1, 2, 3};
        int[] p2 = {4, 5, 6};
        int expResult = 3;
        int result = MathArrays.distanceInf(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distanceInf with two negative arrays
    @Test
    public void testDistanceInfIntNegative() {
        int[] p1 = {-1, -2, -3};
        int[] p2 = {-4, -5, -6};
        int expResult = 3;
        int result = MathArrays.distanceInf(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distanceInf with a positive and a negative array
    @Test
    public void testDistanceInfIntPositiveNegative() {
        int[] p1 = {1, 2, 3};
        int[] p2 = {-4, -5, -6};
        int expResult = 9;
        int result = MathArrays.distanceInf(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distanceInf with two empty arrays
    @Test
    public void testDistanceInfIntEmpty() {
        int[] p1 = {};
        int[] p2 = {};
        int expResult = 0;
        int result = MathArrays.distanceInf(p1, p2);
        assertEquals(expResult, result, 0.0);
    }

    //Test the method distanceInf with two arrays of different lengths
    @Test(expected = DimensionMismatchException.class)
    public void testDistanceInfIntDifferentLengths() {
        int[] p1 = {1, 2, 3};
        int[] p2 = {4, 5};
        int result = MathArrays.distanceInf(p1, p2);
    }

    //Test the method distanceInf with a NaN array
    @Test
    public void testDistanceInfIntNaN() {
        int[] p1 = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] p2 = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int expResult = Integer.MAX_VALUE;
        int result = MathArrays.distanceInf(p1, p2);
        assertEquals(expResult, result, 0.0);
    }
//___________________________________________________________________________________________________________________

/*create a test suite for this method:

public static boolean checkOrder(double[] val, OrderDirection dir,
                                     boolean strict, boolean abort) {
        double previous = val[0];
        final int max = val.length;

        int index;
        ITEM:
        for (index = 1; index < max; index++) {
            switch (dir) {
            case INCREASING:
                if (strict) {
                    if (val[index] <= previous) {
                        break ITEM;
                    }
                } else {
                    if (val[index] < previous) {
                        break ITEM;
                    }
                }
                break;
            case DECREASING:
                if (strict) {
                    if (val[index] >= previous) {
                        break ITEM;
                    }
                } else {
                    if (val[index] > previous) {
                        break ITEM;
                    }
                }
                break;
            default:
                // Should never happen.
                throw new MathInternalError();
            }

            previous = val[index];
        }

        if (index == max) {
            // Loop completed.
            return true;
        }

        // Loop early exit means wrong ordering.
        if (abort) {
            throw new NonMonotonicSequenceException(val[index],
                                                    previous,
                                                    index,
                                                    dir == OrderDirection.INCREASING,
                                                    strict);
        } else {
            return false;
        }
    }
    use significant names that are related to the method name
 */

    //Test the method checkOrder with an increasing array
    @Test
    public void testCheckOrderIncreasing() {
        double[] val = {1.0, 2.0, 3.0};
        OrderDirection dir = OrderDirection.INCREASING;
        boolean strict = false;
        boolean abort = false;
        boolean expResult = true;
        boolean result = MathArrays.checkOrder(val, dir, strict, abort);
        assertEquals(expResult, result);
    }

    //Test the method checkOrder with a decreasing array
    @Test
    public void testCheckOrderDecreasing() {
        double[] val = {3.0, 2.0, 1.0};
        OrderDirection dir = OrderDirection.DECREASING;
        boolean strict = false;
        boolean abort = false;
        boolean expResult = true;
        boolean result = MathArrays.checkOrder(val, dir, strict, abort);
        assertEquals(expResult, result);
    }

    //Test the method checkOrder with an increasing array and strict = true
    @Test
    public void testCheckOrderIncreasingStrict() {
        double[] val = {1.0, 2.0, 3.0};
        OrderDirection dir = OrderDirection.INCREASING;
        boolean strict = true;
        boolean abort = false;
        boolean expResult = true;
        boolean result = MathArrays.checkOrder(val, dir, strict, abort);
        assertEquals(expResult, result);
    }

    //Test the method checkOrder with a decreasing array and strict = true
    @Test
    public void testCheckOrderDecreasingStrict() {
        double[] val = {3.0, 2.0, 1.0};
        OrderDirection dir = OrderDirection.DECREASING;
        boolean strict = true;
        boolean abort = false;
        boolean expResult = true;
        boolean result = MathArrays.checkOrder(val, dir, strict, abort);
        assertEquals(expResult, result);
    }

    //Test the method checkOrder with an increasing array and abort = true
    @Test
    public void testCheckOrderIncreasingAbort() {
        double[] val = {1.0, 2.0, 3.0};
        OrderDirection dir = OrderDirection.INCREASING;
        boolean strict = false;
        boolean abort = true;
        boolean expResult = true;
        boolean result = MathArrays.checkOrder(val, dir, strict, abort);
        assertEquals(expResult, result);
    }

    //Test the method checkOrder with a decreasing array and abort = true
    @Test
    public void testCheckOrderDecreasingAbort() {
        double[] val = {3.0, 2.0, 1.0};
        OrderDirection dir = OrderDirection.DECREASING;
        boolean strict = false;
        boolean abort = true;
        boolean expResult = true;
        boolean result = MathArrays.checkOrder(val, dir, strict, abort);
        assertEquals(expResult, result);
    }

    //Test the method checkOrder with an increasing array and strict = true and abort = true
    @Test
    public void testCheckOrderIncreasingStrictAbort() {
        double[] val = {1.0, 2.0, 3.0};
        OrderDirection dir = OrderDirection.INCREASING;
        boolean strict = true;
        boolean abort = true;
        boolean expResult = true;
        boolean result = MathArrays.checkOrder(val, dir, strict, abort);
        assertEquals(expResult, result);
    }

    //Test the method checkOrder with a decreasing array and strict = true and abort = true
    @Test
    public void testCheckOrderDecreasingStrictAbort() {
        double[] val = {3.0, 2.0, 1.0};
        OrderDirection dir = OrderDirection.DECREASING;
        boolean strict = true;
        boolean abort = true;
        boolean expResult = true;
        boolean result = MathArrays.checkOrder(val, dir, strict, abort);
        assertEquals(expResult, result);
    }

    //Test the method checkOrder with an increasing array and strict = true and abort = true
    @Test(expected = NonMonotonicSequenceException.class)
    public void testCheckOrderIncreasingStrictAbortException() {
        double[] val = {1.0, 2.0, 1.0};
        OrderDirection dir = OrderDirection.INCREASING;
        boolean strict = true;
        boolean abort = true;
        boolean expResult = true;
        boolean result = MathArrays.checkOrder(val, dir, strict, abort);
        assertEquals(expResult, result);
    }

    //Test the method checkOrder with a decreasing array and strict = true and abort = true
    @Test(expected = NonMonotonicSequenceException.class)
    public void testCheckOrderDecreasingStrictAbortException() {
        double[] val = {3.0, 2.0, 3.0};
        OrderDirection dir = OrderDirection.DECREASING;
        boolean strict = true;
        boolean abort = true;
        boolean expResult = true;
        boolean result = MathArrays.checkOrder(val, dir, strict, abort);
        assertEquals(expResult, result);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static void checkOrder(double[] val, OrderDirection dir, boolean strict) {
        checkOrder(val, dir, strict, true);
    }
    use significant names that are related to the method name
 */

    //Test the method checkOrder with an increasing array
    @Test
    public void testCheckOrderIncreasing2() {
        double[] val = {1.0, 2.0, 3.0};
        OrderDirection dir = OrderDirection.INCREASING;
        boolean strict = false;
        boolean expResult = true;
        MathArrays.checkOrder(val, dir, strict);
    }

    //Test the method checkOrder with a decreasing array
    @Test
    public void testCheckOrderDecreasing2() {
        double[] val = {3.0, 2.0, 1.0};
        OrderDirection dir = OrderDirection.DECREASING;
        boolean strict = false;
        boolean expResult = true;
        MathArrays.checkOrder(val, dir, strict);
    }

    //Test the method checkOrder with an increasing array and strict = true
    @Test
    public void testCheckOrderIncreasingStrict2() {
        double[] val = {1.0, 2.0, 3.0};
        OrderDirection dir = OrderDirection.INCREASING;
        boolean strict = true;
        boolean expResult = true;
        MathArrays.checkOrder(val, dir, strict);
    }

    //Test the method checkOrder with a decreasing array and strict = true
    @Test
    public void testCheckOrderDecreasingStrict2() {
        double[] val = {3.0, 2.0, 1.0};
        OrderDirection dir = OrderDirection.DECREASING;
        boolean strict = true;
        boolean expResult = true;
        MathArrays.checkOrder(val, dir, strict);
    }

    //Test the method checkOrder with an increasing array and strict = true
    @Test(expected = NonMonotonicSequenceException.class)
    public void testCheckOrderIncreasingStrictFalse2() {
        double[] val = {1.0, 2.0, 1.0};
        OrderDirection dir = OrderDirection.INCREASING;
        boolean strict = true;
        boolean expResult = true;
        MathArrays.checkOrder(val, dir, strict);
    }

    //Test the method checkOrder with a decreasing array and strict = true
    @Test(expected = NonMonotonicSequenceException.class)
    public void testCheckOrderDecreasingStrictFalse2() {
        double[] val = {3.0, 2.0, 3.0};
        OrderDirection dir = OrderDirection.DECREASING;
        boolean strict = true;
        boolean expResult = true;
        MathArrays.checkOrder(val, dir, strict);
    }

    //Test the method checkOrder with an increasing array and strict = false
    @Test
    public void testCheckOrderIncreasingFalse2() {
        double[] val = {1.0, 2.0, 1.0};
        OrderDirection dir = OrderDirection.INCREASING;
        boolean strict = false;
        boolean expResult = true;
        MathArrays.checkOrder(val, dir, strict);
    }

    //Test the method checkOrder with a decreasing array and strict = false
    @Test
    public void testCheckOrderDecreasingFalse2() {
        double[] val = {3.0, 2.0, 3.0};
        OrderDirection dir = OrderDirection.DECREASING;
        boolean strict = false;
        boolean expResult = true;
        MathArrays.checkOrder(val, dir, strict);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static void checkOrder(double[] val) {
        checkOrder(val, OrderDirection.INCREASING, true);
    }
    use significant names that are related to the method name
 */

    //Test the method checkOrder with an increasing array
    @Test
    public void testCheckOrderIncreasing3() {
        double[] val = {1.0, 2.0, 3.0};
        MathArrays.checkOrder(val);
    }

    //Test the method checkOrder with a decreasing array
    @Test(expected = NonMonotonicSequenceException.class)
    public void testCheckOrderDecreasing3() {
        double[] val = {3.0, 2.0, 1.0};
        MathArrays.checkOrder(val);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

public static  <T extends Comparable<? super T>> boolean isMonotonic(T[] val,
                                      OrderDirection dir,
                                      boolean strict) {
        T previous = val[0];
        final int max = val.length;
        for (int i = 1; i < max; i++) {
            final int comp;
            switch (dir) {
            case INCREASING:
                comp = previous.compareTo(val[i]);
                if (strict) {
                    if (comp >= 0) {
                        return false;
                    }
                } else {
                    if (comp > 0) {
                        return false;
                    }
                }
                break;
            case DECREASING:
                comp = val[i].compareTo(previous);
                if (strict) {
                    if (comp >= 0) {
                        return false;
                    }
                } else {
                    if (comp > 0) {
                        return false;
                    }
                }
                break;
            default:
                // Should never happen.
                throw new MathInternalError();
            }

            previous = val[i];
        }
        return true;
    }
    use significant names that are related to the method name
 */

    //Test the method isMonotonic with an increasing array
    @Test
    public void testIsMonotonicIncreasing() {
        Double[] val = {1.0, 2.0, 3.0};
        OrderDirection dir = OrderDirection.INCREASING;
        boolean strict = false;
        boolean expResult = true;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }

    //Test the method isMonotonic with a decreasing array
    @Test
    public void testIsMonotonicDecreasing() {
        Double[] val = {3.0, 2.0, 1.0};
        OrderDirection dir = OrderDirection.DECREASING;
        boolean strict = false;
        boolean expResult = true;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }

    //Test the method isMonotonic with an increasing array and strict = true
    @Test
    public void testIsMonotonicIncreasingStrict() {
        Double[] val = {1.0, 2.0, 3.0};
        OrderDirection dir = OrderDirection.INCREASING;
        boolean strict = true;
        boolean expResult = true;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }

    //Test the method isMonotonic with a decreasing array and strict = true
    @Test
    public void testIsMonotonicDecreasingStrict() {
        Double[] val = {3.0, 2.0, 1.0};
        OrderDirection dir = OrderDirection.DECREASING;
        boolean strict = true;
        boolean expResult = true;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }

    //Test the method isMonotonic with an increasing array and strict = true
    @Test
    public void testIsMonotonicIncreasingStrictFalse() {
        Double[] val = {1.0, 2.0, 1.0};
        OrderDirection dir = OrderDirection.INCREASING;
        boolean strict = true;
        boolean expResult = false;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }

    //Test the method isMonotonic with a decreasing array and strict = true
    @Test
    public void testIsMonotonicDecreasingStrictFalse() {
        Double[] val = {3.0, 2.0, 3.0};
        OrderDirection dir = OrderDirection.DECREASING;
        boolean strict = true;
        boolean expResult = false;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }

    //Test the method isMonotonic with an increasing array and strict = false
    @Test
    public void testIsMonotonicIncreasingFalse() {
        Double[] val = {1.0, 2.0, 1.0};
        OrderDirection dir = OrderDirection.INCREASING;
        boolean strict = false;
        boolean expResult = false;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }

    //Test the method isMonotonic with a decreasing array and strict = false
    @Test
    public void testIsMonotonicDecreasingFalse() {
        Double[] val = {3.0, 2.0, 3.0};
        OrderDirection dir = OrderDirection.DECREASING;
        boolean strict = false;
        boolean expResult = false;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }

    //Test the method isMonotonic with an increasing array and strict = false
    @Test
    public void testIsMonotonicIncreasingFalse2() {
        Double[] val = {1.0, 1.0, 1.0};
        OrderDirection dir = OrderDirection.INCREASING;
        boolean strict = false;
        boolean expResult = true;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }

    //Test the method isMonotonic with a decreasing array and strict = false
    @Test
    public void testIsMonotonicDecreasingFalse2() {
        Double[] val = {3.0, 3.0, 3.0};
        OrderDirection dir = OrderDirection.DECREASING;
        boolean strict = false;
        boolean expResult = true;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }

    //Test the method isMonotonic with an increasing array and strict = false
    @Test
    public void testIsMonotonicIncreasingFalse3() {
        Double[] val = {1.0, 1.0, 2.0};
        OrderDirection dir = OrderDirection.INCREASING;
        boolean strict = false;
        boolean expResult = true;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }

    //Test the method isMonotonic with a decreasing array and strict = false
    @Test
    public void testIsMonotonicDecreasingFalse3() {
        Double[] val = {3.0, 3.0, 2.0};
        OrderDirection dir = OrderDirection.DECREASING;
        boolean strict = false;
        boolean expResult = true;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }
//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static boolean isMonotonic(double[] val, OrderDirection dir, boolean strict) {
        return checkOrder(val, dir, strict, false);
    }
    use significant names that are related to the method name
 */

    //Test the method isMonotonic with an increasing array
    @Test
    public void testIsMonotonicIncreasing2() {
        double[] val = {1.0, 2.0, 3.0};
        OrderDirection dir = OrderDirection.INCREASING;
        boolean strict = false;
        boolean expResult = true;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }

    //Test the method isMonotonic with a decreasing array
    @Test
    public void testIsMonotonicDecreasing2() {
        double[] val = {3.0, 2.0, 1.0};
        OrderDirection dir = OrderDirection.DECREASING;
        boolean strict = false;
        boolean expResult = true;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }

    //Test the method isMonotonic with an increasing array and strict = true
    @Test
    public void testIsMonotonicIncreasingStrict2() {
        double[] val = {1.0, 2.0, 3.0};
        OrderDirection dir = OrderDirection.INCREASING;
        boolean strict = true;
        boolean expResult = true;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }

    //Test the method isMonotonic with a decreasing array and strict = true
    @Test
    public void testIsMonotonicDecreasingStrict2() {
        double[] val = {3.0, 2.0, 1.0};
        OrderDirection dir = OrderDirection.DECREASING;
        boolean strict = true;
        boolean expResult = true;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }

    //Test the method isMonotonic with an increasing array and strict = true
    @Test
    public void testIsMonotonicIncreasingStrictFalse2() {
        double[] val = {1.0, 2.0, 1.0};
        OrderDirection dir = OrderDirection.INCREASING;
        boolean strict = true;
        boolean expResult = false;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }

    //Test the method isMonotonic with a decreasing array and strict = true
    @Test
    public void testIsMonotonicDecreasingStrictFalse2() {
        double[] val = {3.0, 2.0, 3.0};
        OrderDirection dir = OrderDirection.DECREASING;
        boolean strict = true;
        boolean expResult = false;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }

    //Test the method isMonotonic with an increasing array and strict = false
    @Test
    public void testIsMonotonicIncreasingFalse22() {
        double[] val = {1.0, 2.0, 1.0};
        OrderDirection dir = OrderDirection.INCREASING;
        boolean strict = false;
        boolean expResult = false;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }

    //Test the method isMonotonic with a decreasing array and strict = false
    @Test
    public void testIsMonotonicDecreasingFalse22() {
        double[] val = {3.0, 2.0, 3.0};
        OrderDirection dir = OrderDirection.DECREASING;
        boolean strict = false;
        boolean expResult = false;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }

    //Test the method isMonotonic with an increasing array and strict = false
    @Test
    public void testIsMonotonicIncreasingFalse23() {
        double[] val = {1.0, 1.0, 1.0};
        OrderDirection dir = OrderDirection.INCREASING;
        boolean strict = false;
        boolean expResult = true;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }

    //Test the method isMonotonic with a decreasing array and strict = false
    @Test
    public void testIsMonotonicDecreasingFalse23() {
        double[] val = {3.0, 3.0, 3.0};
        OrderDirection dir = OrderDirection.DECREASING;
        boolean strict = false;
        boolean expResult = true;
        boolean result = MathArrays.isMonotonic(val, dir, strict);
        assertEquals(expResult, result);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static void checkRectangular(final long[][] in) {
        NullArgumentException.check(in);
        for (int i = 1; i < in.length; i++) {
            if (in[i].length != in[0].length) {
                throw new DimensionMismatchException(
                        LocalizedFormats.DIFFERENT_ROWS_LENGTHS,
                        in[i].length, in[0].length);
            }
        }
    }
    use significant names that are related to the method name
 */

    //Test the method checkRectangular with a rectangular matrix
    @Test
    public void testCheckRectangular() {
        long[][] in = {{1, 2, 3}, {1, 2, 3}};
        MathArrays.checkRectangular(in);
    }

    //Test the method checkRectangular with a non-rectangular matrix
    @Test(expected = DimensionMismatchException.class)
    public void testCheckRectangularNonRectangular() {
        long[][] in = {{1, 2, 3}, {1, 2}};
        MathArrays.checkRectangular(in);
    }

    //Test the method checkRectangular with a null matrix
    @Test(expected = NullArgumentException.class)
    public void testCheckRectangularNull() {
        long[][] in = null;
        MathArrays.checkRectangular(in);
    }

    //Test the method checkRectangular with an empty matrix
    @Test(expected = NullArgumentException.class)
    public void testCheckRectangularEmpty() {
        long[][] in = {};
        MathArrays.checkRectangular(in);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

 public static void checkPositive(final double[] in) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] <= 0) {
                throw new NotStrictlyPositiveException(in[i]);
            }
        }
    }
    use significant names that are related to the method name
 */

    //Test the method checkPositive with a positive array
    @Test
    public void testCheckPositive() {
        double[] in = {1, 2, 3};
        MathArrays.checkPositive(in);
    }

    //Test the method checkPositive with a negative array
    @Test(expected = NotStrictlyPositiveException.class)
    public void testCheckPositiveNegative() {
        double[] in = {1, -2, 3};
        MathArrays.checkPositive(in);
    }

    //Test the method checkPositive with a null array
    @Test(expected = NullArgumentException.class)
    public void testCheckPositiveNull() {
        double[] in = null;
        MathArrays.checkPositive(in);
    }

    //Test the method checkPositive with an empty array
    @Test(expected = NullArgumentException.class)
    public void testCheckPositiveEmpty() {
        double[] in = {};
        MathArrays.checkPositive(in);
    }

    //Test the method checkPositive with a zero array
    @Test(expected = NotStrictlyPositiveException.class)
    public void testCheckPositiveZero() {
        double[] in = {0, 0, 0};
        MathArrays.checkPositive(in);
    }

    //Test the method checkPositive with a zero array
    @Test(expected = NotStrictlyPositiveException.class)
    public void testCheckPositiveZero2() {
        double[] in = {1, 0, 3};
        MathArrays.checkPositive(in);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static void checkNotNaN(final double[] in) {
        for (int i = 0; i < in.length; i++) {
            if (Double.isNaN(in[i])) {
                throw new NotANumberException();
            }
        }
    }
    use significant names that are related to the method name
 */

    //Test the method checkNotNaN with a valid array
    @Test
    public void testCheckNotNaN() {
        double[] in = {1, 2, 3};
        MathArrays.checkNotNaN(in);
    }

    //Test the method checkNotNaN with a NaN array
    @Test(expected = NotANumberException.class)
    public void testCheckNotNaNNaN() {
        double[] in = {1, Double.NaN, 3};
        MathArrays.checkNotNaN(in);
    }

    //Test the method checkNotNaN with a null array
    @Test(expected = NullArgumentException.class)
    public void testCheckNotNaNNull() {
        double[] in = null;
        MathArrays.checkNotNaN(in);
    }

    //Test the method checkNotNaN with an empty array
    @Test(expected = NullArgumentException.class)
    public void testCheckNotNaNEmpty() {
        double[] in = {};
        MathArrays.checkNotNaN(in);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static void checkNonNegative(final long[] in) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] < 0) {
                throw new NotPositiveException(in[i]);
            }
        }
    }
    use significant names that are related to the method name
 */

    //Test the method checkNonNegative with a valid array
    @Test
    public void testCheckNonNegative() {
        long[] in = {1, 2, 3};
        MathArrays.checkNonNegative(in);
    }

    //Test the method checkNonNegative with a negative array
    @Test(expected = NotPositiveException.class)
    public void testCheckNonNegativeNegative() {
        long[] in = {1, -2, 3};
        MathArrays.checkNonNegative(in);
    }

    //Test the method checkNonNegative with a null array
    @Test(expected = NullArgumentException.class)
    public void testCheckNonNegativeNull() {
        long[] in = null;
        MathArrays.checkNonNegative(in);
    }

    //Test the method checkNonNegative with an empty array
    @Test(expected = NullArgumentException.class)
    public void testCheckNonNegativeEmpty() {
        long[] in = {};
        MathArrays.checkNonNegative(in);
    }

    //Test the method checkNonNegative with a zero array
    @Test
    public void testCheckNonNegativeZero() {
        long[] in = {0, 0, 0};
        MathArrays.checkNonNegative(in);
    }

    //Test the method checkNonNegative with a zero array
    @Test(expected = NotPositiveException.class)
    public void testCheckNonNegativeZero2() {
        long[] in = {1, 0, 3};
        MathArrays.checkNonNegative(in);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static void checkNonNegative(final long[][] in) {
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[i].length; j++) {
                if (in[i][j] < 0) {
                    throw new NotPositiveException(in[i][j]);
                }
            }
        }
    }
    use significant names that are related to the method name
 */

    //Test the method checkNonNegative with a valid matrix
    @Test
    public void testCheckNonNegativeMatrix() {
        long[][] in = {{1, 2, 3}, {1, 2, 3}};
        MathArrays.checkNonNegative(in);
    }

    //Test the method checkNonNegative with a negative matrix
    @Test(expected = NotPositiveException.class)
    public void testCheckNonNegativeMatrixNegative() {
        long[][] in = {{1, 2, 3}, {1, -2, 3}};
        MathArrays.checkNonNegative(in);
    }

    //Test the method checkNonNegative with a null matrix
    @Test(expected = NullArgumentException.class)
    public void testCheckNonNegativeMatrixNull() {
        long[][] in = null;
        MathArrays.checkNonNegative(in);
    }

    //Test the method checkNonNegative with an empty matrix
    @Test(expected = NullArgumentException.class)
    public void testCheckNonNegativeMatrixEmpty() {
        long[][] in = {};
        MathArrays.checkNonNegative(in);
    }

    //Test the method checkNonNegative with a zero matrix
    @Test
    public void testCheckNonNegativeMatrixZero() {
        long[][] in = {{0, 0, 0}, {0, 0, 0}};
        MathArrays.checkNonNegative(in);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static boolean equals(float[] x, float[] y) {
        if (x == null || y == null) {
            return (x == null) == (y == null);
        }
        if (x.length != y.length) {
            return false;
        }
        for (int i = 0; i < x.length; ++i) {
            if (!Precision.equals(x[i], y[i])) {
                return false;
            }
        }
        return true;
    }
    use significant names that are related to the method name
 */

    //Test the method equals with two valid arrays
    @Test
    public void testEquals() {
        float[] x = {1, 2, 3};
        float[] y = {1, 2, 3};
        assertTrue(MathArrays.equals(x, y));
    }

    //Test the method equals with two different arrays
    @Test
    public void testEqualsDifferent() {
        float[] x = {1, 2, 3};
        float[] y = {1, 2, 4};
        assertFalse(MathArrays.equals(x, y));
    }

    //Test the method equals with a null array
    @Test
    public void testEqualsNull() {
        float[] x = {1, 2, 3};
        float[] y = null;
        assertFalse(MathArrays.equals(x, y));
    }

    //Test the method equals with two null arrays
    @Test
    public void testEqualsNull2() {
        float[] x = null;
        float[] y = null;
        assertTrue(MathArrays.equals(x, y));
    }

    //Test the method equals with two empty arrays
    @Test
    public void testEqualsEmpty() {
        float[] x = {};
        float[] y = {};
        assertTrue(MathArrays.equals(x, y));
    }

    //Test the method equals with two empty arrays
    @Test
    public void testEqualsEmpty2() {
        float[] x = {1, 2, 3};
        float[] y = {};
        assertFalse(MathArrays.equals(x, y));
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static boolean equalsIncludingNaN(float[] x, float[] y) {
        if (x == null || y == null) {
            return (x == null) == (y == null);
        }
        final int len = x.length;
        if (y.length != len) {
            return false;
        }
        for (int i = 0; i < len; ++i) {
            if (Float.floatToIntBits(x[i]) != Float.floatToIntBits(y[i])) {
                return false;
            }
        }
        return true;
    }
    use significant names that are related to the method name
 */

    //Test the method equalsIncludingNaN with two valid arrays
    @Test
    public void testEqualsIncludingNaN() {
        float[] x = {1, 2, 3};
        float[] y = {1, 2, 3};
        assertTrue(MathArrays.equalsIncludingNaN(x, y));
    }

    //Test the method equalsIncludingNaN with two different arrays
    @Test
    public void testEqualsIncludingNaNDifferent() {
        float[] x = {1, 2, 3};
        float[] y = {1, 2, 4};
        assertFalse(MathArrays.equalsIncludingNaN(x, y));
    }

    //Test the method equalsIncludingNaN with a null array
    @Test
    public void testEqualsIncludingNaNNull() {
        float[] x = {1, 2, 3};
        float[] y = null;
        assertFalse(MathArrays.equalsIncludingNaN(x, y));
    }

    //Test the method equalsIncludingNaN with two null arrays
    @Test
    public void testEqualsIncludingNaNNull2() {
        float[] x = null;
        float[] y = null;
        assertTrue(MathArrays.equalsIncludingNaN(x, y));
    }

    //Test the method equalsIncludingNaN with two empty arrays
    @Test
    public void testEqualsIncludingNaNEmpty() {
        float[] x = {};
        float[] y = {};
        assertTrue(MathArrays.equalsIncludingNaN(x, y));
    }

    //Test the method equalsIncludingNaN with two empty arrays
    @Test
    public void testEqualsIncludingNaNEmpty2() {
        float[] x = {1, 2, 3};
        float[] y = {};
        assertFalse(MathArrays.equalsIncludingNaN(x, y));
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static boolean equals(double[] x, double[] y) {
        if (x == null || y == null) {
            return (x == null) == (y == null);
        }
        if (x.length != y.length) {
            return false;
        }
        for (int i = 0; i < x.length; ++i) {
            if (!Precision.equals(x[i], y[i])) {
                return false;
            }
        }
        return true;
    }
    use significant names that are related to the method name
 */

    //Test the method equals with two valid arrays
    @Test
    public void testEqualsDouble() {
        double[] x = {1, 2, 3};
        double[] y = {1, 2, 3};
        assertTrue(MathArrays.equals(x, y));
    }

    //Test the method equals with two different arrays
    @Test
    public void testEqualsDoubleDifferent() {
        double[] x = {1, 2, 3};
        double[] y = {1, 2, 4};
        assertFalse(MathArrays.equals(x, y));
    }

    //Test the method equals with a null array
    @Test
    public void testEqualsDoubleNull() {
        double[] x = {1, 2, 3};
        double[] y = null;
        assertFalse(MathArrays.equals(x, y));
    }

    //Test the method equals with two null arrays
    @Test
    public void testEqualsDoubleNull2() {
        double[] x = null;
        double[] y = null;
        assertTrue(MathArrays.equals(x, y));
    }

    //Test the method equals with two empty arrays
    @Test
    public void testEqualsDoubleEmpty() {
        double[] x = {};
        double[] y = {};
        assertTrue(MathArrays.equals(x, y));
    }

    //Test the method equals with two empty arrays
    @Test
    public void testEqualsDoubleEmpty2() {
        double[] x = {1, 2, 3};
        double[] y = {};
        assertFalse(MathArrays.equals(x, y));
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static boolean equalsIncludingNaN(double[] x, double[] y) {
        if (x == null || y == null) {
            return (x == null) == (y == null);
        }
        if (x.length != y.length) {
            return false;
        }
        for (int i = 0; i < x.length; ++i) {
            if (!Precision.equalsIncludingNaN(x[i], y[i])) {
                return false;
            }
        }
        return true;
    }
    use significant names that are related to the method name
 */

    //Test the method equalsIncludingNaN with two valid arrays
    @Test
    public void testEqualsIncludingNaNDouble() {
        double[] x = {1, 2, 3};
        double[] y = {1, 2, 3};
        assertTrue(MathArrays.equalsIncludingNaN(x, y));
    }

    //Test the method equalsIncludingNaN with two different arrays
    @Test
    public void testEqualsIncludingNaNDoubleDifferent() {
        double[] x = {1, 2, 3};
        double[] y = {1, 2, 4};
        assertFalse(MathArrays.equalsIncludingNaN(x, y));
    }

    //Test the method equalsIncludingNaN with a null array
    @Test
    public void testEqualsIncludingNaNDoubleNull() {
        double[] x = {1, 2, 3};
        double[] y = null;
        assertFalse(MathArrays.equalsIncludingNaN(x, y));
    }

    //Test the method equalsIncludingNaN with two null arrays
    @Test
    public void testEqualsIncludingNaNDoubleNull2() {
        double[] x = null;
        double[] y = null;
        assertTrue(MathArrays.equalsIncludingNaN(x, y));
    }

    //Test the method equalsIncludingNaN with two empty arrays
    @Test
    public void testEqualsIncludingNaNDoubleEmpty() {
        double[] x = {};
        double[] y = {};
        assertTrue(MathArrays.equalsIncludingNaN(x, y));
    }

    //Test the method equalsIncludingNaN with two empty arrays
    @Test
    public void testEqualsIncludingNaNDoubleEmpty2() {
        double[] x = {1, 2, 3};
        double[] y = {};
        assertFalse(MathArrays.equalsIncludingNaN(x, y));
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static double[] normalizeArray(double[] values, double normalizedSum) {
        if (Double.isInfinite(normalizedSum)) {
            throw new MathIllegalArgumentException(LocalizedFormats.NORMALIZE_INFINITE);
        }
        if (Double.isNaN(normalizedSum)) {
            throw new MathIllegalArgumentException(LocalizedFormats.NORMALIZE_NAN);
        }
        double sum = 0d;
        final int len = values.length;
        double[] out = new double[len];
        for (int i = 0; i < len; i++) {
            if (Double.isInfinite(values[i])) {
                throw new MathIllegalArgumentException(LocalizedFormats.INFINITE_ARRAY_ELEMENT, values[i], i);
            }
            if (!Double.isNaN(values[i])) {
                sum += values[i];
            }
        }
        if (sum == 0) {
            throw new MathArithmeticException(LocalizedFormats.ARRAY_SUMS_TO_ZERO);
        }
        final double scale = normalizedSum / sum;
        for (int i = 0; i < len; i++) {
            if (Double.isNaN(values[i])) {
                out[i] = Double.NaN;
            } else {
                out[i] = values[i] * scale;
            }
        }
        return out;
    }
    use significant names that are related to the method name
 */

    //Test the method normalizeArray with a valid array and a valid normalized sum
    @Test
    public void testNormalizeArray() {
        double[] values = {1, 2, 3};
        double normalizedSum = 6;
        MathArrays.normalizeArray(values, normalizedSum);
    }

    //Test the method normalizeArray with a valid array and an infinite normalized sum
    @Test(expected = MathIllegalArgumentException.class)
    public void testNormalizeArrayInfinite() {
        double[] values = {1, 2, 3};
        double normalizedSum = Double.POSITIVE_INFINITY;
        MathArrays.normalizeArray(values, normalizedSum);
    }

    //Test the method normalizeArray with a valid array and a NaN normalized sum
    @Test(expected = MathIllegalArgumentException.class)
    public void testNormalizeArrayNaN() {
        double[] values = {1, 2, 3};
        double normalizedSum = Double.NaN;
        MathArrays.normalizeArray(values, normalizedSum);
    }

    //Test the method normalizeArray with a valid array and an infinite element
    @Test(expected = MathIllegalArgumentException.class)
    public void testNormalizeArrayInfiniteElement() {
        double[] values = {1, 2, Double.POSITIVE_INFINITY};
        double normalizedSum = 6;
        MathArrays.normalizeArray(values, normalizedSum);
    }

    //Test the method normalizeArray with a valid array and a NaN element
    @Test
    public void testNormalizeArrayNaNElement() {
        double[] values = {1, 2, Double.NaN};
        double normalizedSum = 6;
        MathArrays.normalizeArray(values, normalizedSum);
    }

    //Test the method normalizeArray with a valid array and a zero sum
    @Test(expected = MathArithmeticException.class)
    public void testNormalizeArrayZeroSum() {
        double[] values = {1, 2, 3};
        double normalizedSum = 0;
        MathArrays.normalizeArray(values, normalizedSum);
    }

    //Test the method normalizeArray with a null array and a valid normalized sum
    @Test(expected = NullArgumentException.class)
    public void testNormalizeArrayNull() {
        double[] values = null;
        double normalizedSum = 6;
        MathArrays.normalizeArray(values, normalizedSum);
    }

    //Test the method normalizeArray with an empty array and a valid normalized sum
    @Test(expected = NullArgumentException.class)
    public void testNormalizeArrayEmpty() {
        double[] values = {};
        double normalizedSum = 6;
        MathArrays.normalizeArray(values, normalizedSum);
    }

    //Test the method normalizeArray with a valid array and a negative normalized sum
    @Test
    public void testNormalizeArrayNegative() {
        double[] values = {1, 2, 3};
        double normalizedSum = -6;
        MathArrays.normalizeArray(values, normalizedSum);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static <T> T[] buildArray(final Field<T> field, final int length) {
        @SuppressWarnings("unchecked") // OK because field must be correct class
        T[] array = (T[]) Array.newInstance(field.getRuntimeClass(), length);
        Arrays.fill(array, field.getZero());
        return array;
    }
    use significant names that are related to the method name
 */

    //Test the method buildArray with a valid field and a valid length
    @Test
    public void testBuildArray() {
        final Field field = new Field() {
            @Override
            public Object getZero() {
                return 0;
            }

            @Override
            public Object getOne() {
                return 1;
            }

            @Override
            public Class<?> getRuntimeClass() {
                return Integer.class;
            }
        };
        int length = 5;
        MathArrays.buildArray(field, length);
    }

    //Test the method buildArray with a null field and a valid length
    @Test(expected = NullPointerException.class)
    public void testBuildArrayNullField() {
        final Field field = null;
        int length = 5;
        MathArrays.buildArray(field, length);
    }

    //Test the method buildArray with a valid field and a negative length
    @Test(expected = NegativeArraySizeException.class)
    public void testBuildArrayNegativeLength() {
        final Field field = new Field() {
            @Override
            public Object getZero() {
                return 0;
            }

            @Override
            public Object getOne() {
                return 1;
            }

            @Override
            public Class<?> getRuntimeClass() {
                return Integer.class;
            }
        };
        int length = -5;
        MathArrays.buildArray(field, length);
    }

    //Test the method buildArray with a valid field and a zero length
    @Test(expected = NegativeArraySizeException.class)
    public void testBuildArrayZeroLength() {
        final Field field = new Field() {
            @Override
            public Object getZero() {
                return 0;
            }

            @Override
            public Object getOne() {
                return 1;
            }

            @Override
            public Class<?> getRuntimeClass() {
                return Integer.class;
            }
        };
        int length = 0;
        MathArrays.buildArray(field, length);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    @SuppressWarnings("unchecked")
    public static <T> T[][] buildArray(final Field<T> field, final int rows, final int columns) {
        final T[][] array;
        if (columns < 0) {
            T[] dummyRow = buildArray(field, 0);
            array = (T[][]) Array.newInstance(dummyRow.getClass(), rows);
        } else {
            array = (T[][]) Array.newInstance(field.getRuntimeClass(),
                                              rows, columns);
            for (int i = 0; i < rows; ++i) {
                Arrays.fill(array[i], field.getZero());
            }
        }
        return array;
    }
    use significant names that are related to the method name
 */

    //Test the method buildArray with a valid field and a valid rows and columns
    @Test
    public void testBuildArray2() {
        final Field field = new Field() {
            @Override
            public Object getZero() {
                return 0;
            }

            @Override
            public Object getOne() {
                return 1;
            }

            @Override
            public Class<?> getRuntimeClass() {
                return Integer.class;
            }
        };
        int rows = 5;
        int columns = 5;
        MathArrays.buildArray(field, rows, columns);
    }

    //Test the method buildArray with a valid field and a valid rows and negative columns
    @Test
    public void testBuildArray2NegativeColumns() {
        final Field field = new Field() {
            @Override
            public Object getZero() {
                return 0;
            }

            @Override
            public Object getOne() {
                return 1;
            }

            @Override
            public Class<?> getRuntimeClass() {
                return Integer.class;
            }
        };
        int rows = 5;
        int columns = -5;
        MathArrays.buildArray(field, rows, columns);
    }

    //Test the method buildArray with a valid field and a valid rows and zero columns
    @Test
    public void testBuildArray2ZeroColumns() {
        final Field field = new Field() {
            @Override
            public Object getZero() {
                return 0;
            }

            @Override
            public Object getOne() {
                return 1;
            }

            @Override
            public Class<?> getRuntimeClass() {
                return Integer.class;
            }
        };
        int rows = 5;
        int columns = 0;
        MathArrays.buildArray(field, rows, columns);
    }

    //Test the method buildArray with a valid field and a negative rows and columns
    @Test(expected = NegativeArraySizeException.class)
    public void testBuildArray2NegativeRowsAndColumns() {
        final Field field = new Field() {
            @Override
            public Object getZero() {
                return 0;
            }

            @Override
            public Object getOne() {
                return 1;
            }

            @Override
            public Class<?> getRuntimeClass() {
                return Integer.class;
            }
        };
        int rows = -5;
        int columns = -5;
        MathArrays.buildArray(field, rows, columns);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

public static double[] convolve(double[] x, double[] h) {
        NullArgumentException.check(x);
        NullArgumentException.check(h);

        final int xLen = x.length;
        final int hLen = h.length;

        if (xLen == 0 || hLen == 0) {
            throw new NoDataException();
        }

        // initialize the output array
        final int totalLength = xLen + hLen - 1;
        final double[] y = new double[totalLength];

        // straightforward implementation of the convolution sum
        for (int n = 0; n < totalLength; n++) {
            double yn = 0;
            int k = AccurateMath.max(0, n + 1 - xLen);
            int j = n - k;
            while (k < hLen && j >= 0) {
                yn += x[j--] * h[k++];
            }
            y[n] = yn;
        }

        return y;
    }
    use significant names that are related to the method name
 */

    //Test the method convolve with a valid x and h array
    @Test
    public void testConvolve() {
        double[] x = {1, 2, 3};
        double[] h = {1, 2, 3};
        MathArrays.convolve(x, h);
    }

    //Test the method convolve with a null x array
    @Test(expected = NullArgumentException.class)
    public void testConvolveNullX() {
        double[] x = null;
        double[] h = {1, 2, 3};
        MathArrays.convolve(x, h);
    }

    //Test the method convolve with a null h array
    @Test(expected = NullArgumentException.class)
    public void testConvolveNullH() {
        double[] x = {1, 2, 3};
        double[] h = null;
        MathArrays.convolve(x, h);
    }

    //Test the method convolve with a empty x array
    @Test(expected = NoDataException.class)
    public void testConvolveEmptyX() {
        double[] x = {};
        double[] h = {1, 2, 3};
        MathArrays.convolve(x, h);
    }

    //Test the method convolve with a empty h array
    @Test(expected = NoDataException.class)
    public void testConvolveEmptyH() {
        double[] x = {1, 2, 3};
        double[] h = {};
        MathArrays.convolve(x, h);
    }

    //Test the method convolve with a empty x and h array
    @Test(expected = NoDataException.class)
    public void testConvolveEmptyXAndH() {
        double[] x = {};
        double[] h = {};
        MathArrays.convolve(x, h);
    }

    //Test the method convolve with a valid x and h array
    @Test
    public void testConvolveNegative() {
        double[] x = {-1, -2, -3};
        double[] h = {1, 2, 3};
        MathArrays.convolve(x, h);
    }

    //Test the method convolve with a valid x and h array
    @Test
    public void testConvolveZero() {
        double[] x = {0, 0, 0};
        double[] h = {1, 2, 3};
        MathArrays.convolve(x, h);
    }

    //Test the method convolve with a valid x and h array
    @Test
    public void testConvolveZero2() {
        double[] x = {1, 2, 3};
        double[] h = {0, 0, 0};
        MathArrays.convolve(x, h);
    }

    //Test the method convolve with a valid x and h array
    @Test
    public void testConvolveZero3() {
        double[] x = {0, 0, 0};
        double[] h = {0, 0, 0};
        MathArrays.convolve(x, h);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static int[] sequence(int size,
                                 int start,
                                 int stride) {
        final int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = start + i * stride;
        }
        return a;
    }
    use significant names that are related to the method name
 */

    //Test the method sequence with a valid size, start and stride
    @Test
    public void testSequence() {
        int size = 5;
        int start = 5;
        int stride = 5;
        MathArrays.sequence(size, start, stride);
    }

    //Test the method sequence with a valid size, start and negative stride
    @Test
    public void testSequenceNegativeStride() {
        int size = 5;
        int start = 5;
        int stride = -5;
        MathArrays.sequence(size, start, stride);
    }

    //Test the method sequence with a valid size, start and zero stride
    @Test
    public void testSequenceZeroStride() {
        int size = 5;
        int start = 5;
        int stride = 0;
        MathArrays.sequence(size, start, stride);
    }

    //Test the method sequence with a valid size, negative start and stride
    @Test
    public void testSequenceNegativeStartAndStride() {
        int size = 5;
        int start = -5;
        int stride = -5;
        MathArrays.sequence(size, start, stride);
    }

    //Test the method sequence with a valid size, negative start and zero stride
    @Test
    public void testSequenceNegativeStartAndZeroStride() {
        int size = 5;
        int start = -5;
        int stride = 0;
        MathArrays.sequence(size, start, stride);
    }

    //Test the method sequence with a valid size, zero start and stride
    @Test
    public void testSequenceZeroStartAndStride() {
        int size = 5;
        int start = 0;
        int stride = 5;
        MathArrays.sequence(size, start, stride);
    }

    //Test the method sequence with a valid size, zero start and zero stride
    @Test
    public void testSequenceZeroStartAndZeroStride() {
        int size = 5;
        int start = 0;
        int stride = 0;
        MathArrays.sequence(size, start, stride);
    }

    //Test the method sequence with a valid size, zero start and negative stride
    @Test
    public void testSequenceZeroStartAndNegativeStride() {
        int size = 5;
        int start = 0;
        int stride = -5;
        MathArrays.sequence(size, start, stride);
    }

    //Test the method sequence with a valid size, negative start and positive stride
    @Test
    public void testSequenceNegativeStartAndPositiveStride() {
        int size = 5;
        int start = -5;
        int stride = 5;
        MathArrays.sequence(size, start, stride);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

public static int[] natural(int n) {
        return sequence(n, 0, 1);
    }
    use significant names that are related to the method name
 */

    //Test the method natural with a valid n
    @Test
    public void testNatural() {
        int n = 5;
        MathArrays.natural(n);
    }

    //Test the method natural with a valid n
    @Test
    public void testNaturalZero() {
        int n = 0;
        MathArrays.natural(n);
    }

    //Test the method natural with a negative n
    @Test(expected = NotPositiveException.class)
    public void testNaturalNegative() {
        int n = -5;
        MathArrays.natural(n);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static boolean verifyValues(final double[] values, final int begin,
                                       final int length, final boolean allowEmpty) {

        if (values == null) {
            throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY);
        }

        if (begin < 0) {
            throw new NotPositiveException(LocalizedFormats.START_POSITION, Integer.valueOf(begin));
        }

        if (length < 0) {
            throw new NotPositiveException(LocalizedFormats.LENGTH, Integer.valueOf(length));
        }

        if (begin + length > values.length) {
            throw new NumberIsTooLargeException(LocalizedFormats.SUBARRAY_ENDS_AFTER_ARRAY_END,
                    Integer.valueOf(begin + length), Integer.valueOf(values.length), true);
        }

        return !(length == 0 && !allowEmpty);
    }
    use significant names that are related to the method name
 */

    //Test the method verifyValues with a valid values, begin, length and allowEmpty
    @Test
    public void testVerifyValues() {
        double[] values = {1, 2, 3};
        int begin = 0;
        int length = 3;
        boolean allowEmpty = true;
        MathArrays.verifyValues(values, begin, length, allowEmpty);
    }

    //Test the method verifyValues with a valid values, begin, length and negative allowEmpty
    @Test
    public void testVerifyValuesNegativeAllowEmpty() {
        double[] values = {1, 2, 3};
        int begin = 0;
        int length = 3;
        boolean allowEmpty = false;
        MathArrays.verifyValues(values, begin, length, allowEmpty);
    }

    //Test the method verifyValues with a valid values, begin, length and allowEmpty
    @Test
    public void testVerifyValuesAllowEmpty() {
        double[] values = {1, 2, 3};
        int begin = 0;
        int length = 0;
        boolean allowEmpty = true;
        MathArrays.verifyValues(values, begin, length, allowEmpty);
    }

    //Test the method verifyValues with a valid values, begin, length and negative allowEmpty
    @Test(expected = NoDataException.class)
    public void testVerifyValuesNegativeAllowEmptyAndLength() {
        double[] values = {1, 2, 3};
        int begin = 0;
        int length = 0;
        boolean allowEmpty = false;
        MathArrays.verifyValues(values, begin, length, allowEmpty);
    }

    //Test the method verifyValues with a null values, begin, length and allowEmpty
    @Test(expected = NullArgumentException.class)
    public void testVerifyValuesNullValues() {
        double[] values = null;
        int begin = 0;
        int length = 3;
        boolean allowEmpty = true;
        MathArrays.verifyValues(values, begin, length, allowEmpty);
    }

    //Test the method verifyValues with a valid values, negative begin, length and allowEmpty
    @Test(expected = NotPositiveException.class)
    public void testVerifyValuesNegativeBegin() {
        double[] values = {1, 2, 3};
        int begin = -1;
        int length = 3;
        boolean allowEmpty = true;
        MathArrays.verifyValues(values, begin, length, allowEmpty);
    }

    //Test the method verifyValues with a valid values, begin, negative length and allowEmpty
    @Test(expected = NotPositiveException.class)
    public void testVerifyValuesNegativeLength() {
        double[] values = {1, 2, 3};
        int begin = 0;
        int length = -3;
        boolean allowEmpty = true;
        MathArrays.verifyValues(values, begin, length, allowEmpty);
    }

    //Test the method verifyValues with a valid values, begin, length and allowEmpty
    @Test(expected = NumberIsTooLargeException.class)
    public void testVerifyValuesNumberIsTooLargeException() {
        double[] values = {1, 2, 3};
        int begin = 0;
        int length = 4;
        boolean allowEmpty = true;
        MathArrays.verifyValues(values, begin, length, allowEmpty);
    }

    //Test the method verifyValues with a null values, begin, length and allowEmpty
    @Test(expected = NoDataException.class)
    public void testVerifyValuesEmptyValues() {
        double[] values = {};
        int begin = 0;
        int length = 3;
        boolean allowEmpty = true;
        MathArrays.verifyValues(values, begin, length, allowEmpty);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static boolean verifyValues(final double[] values, final int begin, final int length) {
        return verifyValues(values, begin, length, false);
    }

    use significant names that are related to the method name
 */

    //Test the method verifyValues with a valid values, begin and length
    @Test
    public void testVerifyValues2() {
        double[] values = {1, 2, 3};
        int begin = 0;
        int length = 3;
        MathArrays.verifyValues(values, begin, length);
    }

    //Test the method verifyValues with a valid values, begin and negative length
    @Test(expected = NotPositiveException.class)
    public void testVerifyValues2NegativeLength() {
        double[] values = {1, 2, 3};
        int begin = 0;
        int length = -3;
        MathArrays.verifyValues(values, begin, length);
    }

    //Test the method verifyValues with a valid values, negative begin and length
    @Test(expected = NotPositiveException.class)
    public void testVerifyValues2NegativeBegin() {
        double[] values = {1, 2, 3};
        int begin = -1;
        int length = 3;
        MathArrays.verifyValues(values, begin, length);
    }

    //Test the method verifyValues with a null values, begin and length
    @Test(expected = NullArgumentException.class)
    public void testVerifyValues2NullValues() {
        double[] values = null;
        int begin = 0;
        int length = 3;
        MathArrays.verifyValues(values, begin, length);
    }

    //Test the method verifyValues with a null values, begin and length
    @Test(expected = NoDataException.class)
    public void testVerifyValues2EmptyValues() {
        double[] values = {};
        int begin = 0;
        int length = 3;
        MathArrays.verifyValues(values, begin, length);
    }

    //Test the method verifyValues with a valid values, begin and length
    @Test
    public void testVerifyValues2ZeroLength() {
        double[] values = {1, 2, 3};
        int begin = 0;
        int length = 0;
        MathArrays.verifyValues(values, begin, length);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static boolean verifyValues(final double[] values, final double[] weights,
                                       final int begin, final int length, final boolean allowEmpty) {

        if (weights == null || values == null) {
            throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY);
        }

        checkEqualLength(weights, values);

        if (length != 0) {
            boolean containsPositiveWeight = false;
            for (int i = begin; i < begin + length; i++) {
                final double weight = weights[i];
                if (Double.isNaN(weight)) {
                    throw new MathIllegalArgumentException(LocalizedFormats.NAN_ELEMENT_AT_INDEX, Integer.valueOf(i));
                }
                if (Double.isInfinite(weight)) {
                    throw new MathIllegalArgumentException(LocalizedFormats.INFINITE_ARRAY_ELEMENT,
                        Double.valueOf(weight), Integer.valueOf(i));
                }
                if (weight < 0) {
                    throw new MathIllegalArgumentException(LocalizedFormats.NEGATIVE_ELEMENT_AT_INDEX,
                        Integer.valueOf(i), Double.valueOf(weight));
                }
                if (!containsPositiveWeight && weight > 0.0) {
                    containsPositiveWeight = true;
                }
            }

            if (!containsPositiveWeight) {
                throw new MathIllegalArgumentException(LocalizedFormats.WEIGHT_AT_LEAST_ONE_NON_ZERO);
            }
        }

        return verifyValues(values, begin, length, allowEmpty);
    }
    use significant names that are related to the method name
 */

    //Test the method verifyValues with a valid values, weights, begin, length and allowEmpty
    @Test
    public void testVerifyValuesWithWeights() {
        double[] values = {1, 2, 3};
        double[] weights = {1, 2, 3};
        int begin = 0;
        int length = 3;
        boolean allowEmpty = true;
        MathArrays.verifyValues(values, weights, begin, length, allowEmpty);
    }

    //Test the method verifyValues with a valid values, weights, begin, length and negative allowEmpty
    @Test
    public void testVerifyValuesWithWeightsNegativeAllowEmpty() {
        double[] values = {1, 2, 3};
        double[] weights = {1, 2, 3};
        int begin = 0;
        int length = 3;
        boolean allowEmpty = false;
        MathArrays.verifyValues(values, weights, begin, length, allowEmpty);
    }

    //Test the method verifyValues with a valid values, weights, begin, length and allowEmpty
    @Test
    public void testVerifyValuesWithWeightsAllowEmpty() {
        double[] values = {1, 2, 3};
        double[] weights = {1, 2, 3};
        int begin = 0;
        int length = 0;
        boolean allowEmpty = true;
        MathArrays.verifyValues(values, weights, begin, length, allowEmpty);
    }

    //Test the method verifyValues with a valid values, weights, begin, length and negative allowEmpty
    @Test(expected = NoDataException.class)
    public void testVerifyValuesWithWeightsNegativeAllowEmptyAndLength() {
        double[] values = {1, 2, 3};
        double[] weights = {1, 2, 3};
        int begin = 0;
        int length = 0;
        boolean allowEmpty = false;
        MathArrays.verifyValues(values, weights, begin, length, allowEmpty);
    }

    //Test the method verifyValues with a null values, weights, begin, length and allowEmpty
    @Test(expected = NullArgumentException.class)
    public void testVerifyValuesWithWeightsNullValues() {
        double[] values = null;
        double[] weights = {1, 2, 3};
        int begin = 0;
        int length = 3;
        boolean allowEmpty = true;
        MathArrays.verifyValues(values, weights, begin, length, allowEmpty);
    }

    //Test the method verifyValues with a null weights, values, begin, length and allowEmpty
    @Test(expected = NullArgumentException.class)
    public void testVerifyValuesWithWeightsNullWeights() {
        double[] values = {1, 2, 3};
        double[] weights = null;
        int begin = 0;
        int length = 3;
        boolean allowEmpty = true;
        MathArrays.verifyValues(values, weights, begin, length, allowEmpty);
    }

    //Test the method verifyValues with a valid values, weights, negative begin, length and allowEmpty
    @Test(expected = NotPositiveException.class)
    public void testVerifyValuesWithWeightsNegativeBegin() {
        double[] values = {1, 2, 3};
        double[] weights = {1, 2, 3};
        int begin = -1;
        int length = 3;
        boolean allowEmpty = true;
        MathArrays.verifyValues(values, weights, begin, length, allowEmpty);
    }

    //Test the method verifyValues with a valid values, weights, begin, negative length and allowEmpty
    @Test(expected = NotPositiveException.class)
    public void testVerifyValuesWithWeightsNegativeLength() {
        double[] values = {1, 2, 3};
        double[] weights = {1, 2, 3};
        int begin = 0;
        int length = -3;
        boolean allowEmpty = true;
        MathArrays.verifyValues(values, weights, begin, length, allowEmpty);
    }

    //Test the method verifyValues with a valid values, weights, begin, length and allowEmpty
    @Test(expected = MathIllegalArgumentException.class)
    public void testVerifyValuesWithWeightsNegative() {
        double[] values = {1, 2, 3};
        double[] weights = {1, -2, 3};
        int begin = 0;
        int length = 3;
        boolean allowEmpty = true;
        MathArrays.verifyValues(values, weights, begin, length, allowEmpty);
    }

    //Test the method verifyValues with a valid values, weights, begin, length and allowEmpty
    @Test(expected = MathIllegalArgumentException.class)
    public void testVerifyValuesWithWeightsZero() {
        double[] values = {1, 2, 3};
        double[] weights = {1, 0, 3};
        int begin = 0;
        int length = 3;
        boolean allowEmpty = true;
        MathArrays.verifyValues(values, weights, begin, length, allowEmpty);
    }

    //Test the method verifyValues with a valid values, weights, begin, length and allowEmpty
    @Test(expected = MathIllegalArgumentException.class)
    public void testVerifyValuesWithWeightsAllZero() {
        double[] values = {1, 2, 3};
        double[] weights = {0, 0, 0};
        int begin = 0;
        int length = 3;
        boolean allowEmpty = true;
        MathArrays.verifyValues(values, weights, begin, length, allowEmpty);
    }

    //Test the method verifyValues with a valid values, weights, begin, length and allowEmpty
    @Test(expected = MathIllegalArgumentException.class)
    public void testVerifyValuesWithWeightsAllZero2() {
        double[] values = {0, 0, 0};
        double[] weights = {1, 2, 3};
        int begin = 0;
        int length = 3;
        boolean allowEmpty = true;
        MathArrays.verifyValues(values, weights, begin, length, allowEmpty);
    }

    //Test the method verifyValues with a valid values, weights, begin, length and allowEmpty
    @Test(expected = MathIllegalArgumentException.class)
    public void testVerifyValuesWithWeightsAllZero3() {
        double[] values = {0, 0, 0};
        double[] weights = {0, 0, 0};
        int begin = 0;
        int length = 3;
        boolean allowEmpty = true;
        MathArrays.verifyValues(values, weights, begin, length, false);
    }

    //Test the method verifyValues with a valid values, weights, begin, length and allowEmpty
    @Test(expected = NumberIsTooLargeException.class)
    public void testVerifyValuesWithWeightsNumberIsTooLargeException() {
        double[] values = {1, 2, 3};
        double[] weights = {1, 2, 3};
        int begin = 0;
        int length = 4;
        boolean allowEmpty = true;
        MathArrays.verifyValues(values, weights, begin, length, allowEmpty);
    }

    //Test the method verifyValues with a valid values, NaN weights, begin, length and allowEmpty
    @Test(expected = MathIllegalArgumentException.class)
    public void testVerifyValuesWithWeightsNaNWeights() {
        double[] values = {1, 2, 3};
        double[] weights = {1, Double.NaN, 3};
        int begin = 0;
        int length = 3;
        boolean allowEmpty = true;
        MathArrays.verifyValues(values, weights, begin, length);
    }

    //Test the method verifyValues with a valid values, infinite weights, begin, length and allowEmpty
    @Test(expected = MathIllegalArgumentException.class)
    public void testVerifyValuesWithWeightsInfiniteWeights() {
        double[] values = {1, 2, 3};
        double[] weights = {1, Double.POSITIVE_INFINITY, 3};
        int begin = 0;
        int length = 3;
        boolean allowEmpty = true;
        MathArrays.verifyValues(values, weights, begin, length);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static boolean verifyValues(
        final double[] values,
        final double[] weights,
        final int begin,
        final int length) {
        return verifyValues(values, weights, begin, length, false);
    }
    use significant names that are related to the method name
 */

    //Test the method verifyValues with a valid values, weights, begin and length
    @Test
    public void testVerifyValues2WithWeights() {
        double[] values = {1, 2, 3};
        double[] weights = {1, 2, 3};
        int begin = 0;
        int length = 3;
        MathArrays.verifyValues(values, weights, begin, length);
    }

    //Test the method verifyValues with a valid values, weights, begin and negative length
    @Test(expected = NotPositiveException.class)
    public void testVerifyValues2WithWeightsNegativeLength() {
        double[] values = {1, 2, 3};
        double[] weights = {1, 2, 3};
        int begin = 0;
        int length = -3;
        MathArrays.verifyValues(values, weights, begin, length);
    }

    //Test the method verifyValues with a valid values, weights, negative begin and length
    @Test(expected = NotPositiveException.class)
    public void testVerifyValues2WithWeightsNegativeBegin() {
        double[] values = {1, 2, 3};
        double[] weights = {1, 2, 3};
        int begin = -1;
        int length = 3;
        MathArrays.verifyValues(values, weights, begin, length);
    }

    //Test the method verifyValues with a null values, weights, begin and length
    @Test(expected = NullArgumentException.class)
    public void testVerifyValues2WithWeightsNullValues() {
        double[] values = null;
        double[] weights = {1, 2, 3};
        int begin = 0;
        int length = 3;
        MathArrays.verifyValues(values, weights, begin, length);
    }

    //Test the method verifyValues with a null weights, values, begin and length
    @Test(expected = NullArgumentException.class)
    public void testVerifyValues2WithWeightsNullWeights() {
        double[] values = {1, 2, 3};
        double[] weights = null;
        int begin = 0;
        int length = 3;
        MathArrays.verifyValues(values, weights, begin, length);
    }

    //Test the method verifyValues with a valid values, weights, begin and length
    @Test(expected = NumberIsTooLargeException.class)
    public void testVerifyValues2WithWeightsNumberIsTooLargeException() {
        double[] values = {1, 2, 3};
        double[] weights = {1, 2, 3};
        int begin = 0;
        int length = 4;
        MathArrays.verifyValues(values, weights, begin, length);
    }

    //Test the method verifyValues with a valid values, weights, begin and length
    @Test(expected = MathIllegalArgumentException.class)
    public void testVerifyValues2WithWeightsAllZero() {
        double[] values = {1, 2, 3};
        double[] weights = {0, 0, 0};
        int begin = 0;
        int length = 3;
        MathArrays.verifyValues(values, weights, begin, length);
    }

    //Test the method verifyValues with a valid values, weights, begin and length
    @Test(expected = MathIllegalArgumentException.class)
    public void testVerifyValues2WithWeightsNaNWeights() {
        double[] values = {1, 2, 3};
        double[] weights = {1, Double.NaN, 3};
        int begin = 0;
        int length = 3;
        MathArrays.verifyValues(values, weights, begin, length);
    }

    //Test the method verifyValues with a valid values, weights, begin and length
    @Test(expected = MathIllegalArgumentException.class)
    public void testVerifyValues2WithWeightsInfiniteWeights() {
        double[] values = {1, 2, 3};
        double[] weights = {1, Double.POSITIVE_INFINITY, 3};
        int begin = 0;
        int length = 3;
        MathArrays.verifyValues(values, weights, begin, length);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static double[] concatenate(double[]... x) {
        int combinedLength = 0;
        for (double[] a : x) {
            combinedLength += a.length;
        }
        int offset = 0;
        int curLength = 0;
        final double[] combined = new double[combinedLength];
        for (int i = 0; i < x.length; i++) {
            curLength = x[i].length;
            System.arraycopy(x[i], 0, combined, offset, curLength);
            offset += curLength;
        }
        return combined;
    }
    use significant names that are related to the method name
 */

    //Test the method concatenate with a valid x
    @Test
    public void testConcatenate() {
        double[] x = {1, 2, 3};
        double[] y = {4, 5, 6};
        double[] z = {7, 8, 9};
        double[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double[] result = MathArrays.concatenate(x, y, z);
        assertArrayEquals(expected, result, 0.0);
    }

    //Test the method concatenate with a null x
    @Test(expected = NullArgumentException.class)
    public void testConcatenateNullX() {
        double[] x = null;
        double[] y = {4, 5, 6};
        double[] z = {7, 8, 9};
        MathArrays.concatenate(x, y, z);
    }

    //Test the method concatenate with a null y
    @Test(expected = NullArgumentException.class)
    public void testConcatenateNullY() {
        double[] x = {1, 2, 3};
        double[] y = null;
        double[] z = {7, 8, 9};
        MathArrays.concatenate(x, y, z);
    }

    //Test the method concatenate with a null z
    @Test(expected = NullArgumentException.class)
    public void testConcatenateNullZ() {
        double[] x = {1, 2, 3};
        double[] y = {4, 5, 6};
        double[] z = null;
        MathArrays.concatenate(x, y, z);
    }

    //Test the method concatenate with a null x, y and z
    @Test(expected = NullArgumentException.class)
    public void testConcatenateNullXYZ() {
        double[] x = null;
        double[] y = null;
        double[] z = null;
        MathArrays.concatenate(x, y, z);
    }

    //Test the method concatenate with an empty x
    @Test
    public void testConcatenateEmptyX() {
        double[] x = {};
        double[] y = {4, 5, 6};
        double[] z = {7, 8, 9};
        double[] expected = {4, 5, 6, 7, 8, 9};
        double[] result = MathArrays.concatenate(x, y, z);
        assertArrayEquals(expected, result, 0.0);
    }

    //Test the method concatenate with an empty y
    @Test
    public void testConcatenateEmptyY() {
        double[] x = {1, 2, 3};
        double[] y = {};
        double[] z = {7, 8, 9};
        double[] expected = {1, 2, 3, 7, 8, 9};
        double[] result = MathArrays.concatenate(x, y, z);
        assertArrayEquals(expected, result, 0.0);
    }

    //Test the method concatenate with an empty z
    @Test
    public void testConcatenateEmptyZ() {
        double[] x = {1, 2, 3};
        double[] y = {4, 5, 6};
        double[] z = {};
        double[] expected = {1, 2, 3, 4, 5, 6};
        double[] result = MathArrays.concatenate(x, y, z);
        assertArrayEquals(expected, result, 0.0);
    }

    //Test the method concatenate with an empty x, y and z
    @Test
    public void testConcatenateEmptyXYZ() {
        double[] x = {};
        double[] y = {};
        double[] z = {};
        double[] expected = {};
        double[] result = MathArrays.concatenate(x, y, z);
        assertArrayEquals(expected, result, 0.0);
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    public static double[] unique(double[] data) {
        TreeSet<Double> values = new TreeSet<>();
        for (int i = 0; i < data.length; i++) {
            values.add(data[i]);
        }
        final int count = values.size();
        final double[] out = new double[count];
        Iterator<Double> iterator = values.descendingIterator();
        int i = 0;
        while (iterator.hasNext()) {
            out[i++] = iterator.next();
        }
        return out;
    }
    use significant names that are related to the method name
 */

    //Test the method unique with a valid data
    @Test
    public void testUnique() {
        double[] data = {1, 2, 3, 2, 1};
        double[] expected = {3, 2, 1};
        double[] result = MathArrays.unique(data);
        assertArrayEquals(expected, result, 0.0);
    }

    //Test the method unique with a null data
    @Test(expected = NullArgumentException.class)
    public void testUniqueNull() {
        double[] data = null;
        MathArrays.unique(data);
    }

    //Test the method unique with an empty data
    @Test
    public void testUniqueEmpty() {
        double[] data = {};
        double[] expected = {};
        double[] result = MathArrays.unique(data);
        assertArrayEquals(expected, result, 0.0);
    }

    //Test the method unique with a data with only one element
    @Test
    public void testUniqueOneElement() {
        double[] data = {1};
        double[] expected = {1};
        double[] result = MathArrays.unique(data);
        assertArrayEquals(expected, result, 0.0);
    }

    //Test the method unique with a data with only two elements
    @Test
    public void testUniqueTwoElements() {
        double[] data = {1, 2};
        double[] expected = {2, 1};
        double[] result = MathArrays.unique(data);
        assertArrayEquals(expected, result, 0.0);
    }

    //Test the method unique with a data with only duplicate elements
    @Test
    public void testUniqueDuplicateElements() {
        double[] data = {1, 1, 1, 1};
        double[] expected = {1};
        double[] result = MathArrays.unique(data);
        assertArrayEquals(expected, result, 0.0);
    }

    //Test the method unique with a data with only duplicate elements
    @Test
    public void testUniqueDuplicateElements2() {
        double[] data = {1, 1, 1, 1, 2, 2, 2, 2};
        double[] expected = {2, 1};
        double[] result = MathArrays.unique(data);
        assertArrayEquals(expected, result, 0.0);
    }
}