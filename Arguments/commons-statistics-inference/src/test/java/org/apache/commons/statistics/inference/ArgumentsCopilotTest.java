package org.apache.commons.statistics.inference;

import java.util.EnumSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArgumentsCopilotTest {

    public ArgumentsCopilotTest() {
    }

/*create a test suite for this method:

    static void checkSignificance(double alpha) {
        if (alpha > 0 && alpha <= 0.5) {
            return;
        }
        // Not in (0, 0.5], or NaN
        throw new InferenceException(InferenceException.INVALID_SIGNIFICANCE, alpha);
    }

    use significant names that are related to the method name
 */

    @Test
    public void testCheckSignificance() {
        // alpha > 0 && alpha <= 0.5
        Arguments.checkSignificance(0.1);
        Arguments.checkSignificance(0.5);
        // alpha <= 0
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkSignificance(0.0);
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkSignificance(-0.1);
        });
        // alpha > 0.5
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkSignificance(0.6);
        });
        // alpha = NaN
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkSignificance(Double.NaN);
        });
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    static int checkNonNegative(int v) {
        if (v < 0) {
            throw new InferenceException(InferenceException.NEGATIVE, v);
        }
        return v;
    }

    use significant names that are related to the method name
 */

    @Test
    public void testCheckNonNegative() {
        // v >= 0
        Assertions.assertEquals(0, Arguments.checkNonNegative(0));
        Assertions.assertEquals(1, Arguments.checkNonNegative(1));
        // v < 0
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkNonNegative(-1);
        });
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    static void checkNonNegative(double v) {
        if (v >= 0) {
            return;
        }
        // Negative, or NaN
        throw new InferenceException(InferenceException.NEGATIVE, v);
    }

    use significant names that are related to the method name
 */

    @Test
    public void testCheckNonNegative1() {
        // v >= 0
        Arguments.checkNonNegative(0.0);
        Arguments.checkNonNegative(1.0);
        // v < 0
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkNonNegative(-1.0);
        });
        // v = NaN
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkNonNegative(Double.NaN);
        });
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    static void checkNonNegative(long[] values) {
        for (final long v : values) {
            if (v < 0) {
                throw new InferenceException(InferenceException.NEGATIVE, v);
            }
        }
    }

    use significant names that are related to the method name
 */

    @Test
    public void testCheckNonNegative2() {
        // v >= 0
        Arguments.checkNonNegative(new long[]{0});
        Arguments.checkNonNegative(new long[]{1});
        Arguments.checkNonNegative(new long[]{0, 1});
        Arguments.checkNonNegative(new long[]{1, 1});
        // v < 0
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkNonNegative(new long[]{-1});
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkNonNegative(new long[]{-1, 1});
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkNonNegative(new long[]{1, -1});
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkNonNegative(new long[]{-1, -1});
        });
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    static void checkNonNegative(long[][] values) {
        for (final long[] v : values) {
            checkNonNegative(v);
        }
    }

    use significant names that are related to the method name
 */

    @Test
    public void testCheckNonNegative3() {
        // v >= 0
        Arguments.checkNonNegative(new long[][]{{0}});
        Arguments.checkNonNegative(new long[][]{{1}});
        Arguments.checkNonNegative(new long[][]{{0, 1}});
        Arguments.checkNonNegative(new long[][]{{1, 1}});
        Arguments.checkNonNegative(new long[][]{{0}, {0}});
        Arguments.checkNonNegative(new long[][]{{1}, {1}});
        Arguments.checkNonNegative(new long[][]{{0}, {1}});
        Arguments.checkNonNegative(new long[][]{{1}, {1}});
        // v < 0
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkNonNegative(new long[][]{{-1}});
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkNonNegative(new long[][]{{-1, 1}});
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkNonNegative(new long[][]{{1, -1}});
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkNonNegative(new long[][]{{-1, -1}});
        });
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    static int checkStrictlyPositive(int v) {
        if (v <= 0) {
            throw new InferenceException(InferenceException.NOT_STRICTLY_POSITIVE, v);
        }
        return v;
    }

    use significant names that are related to the method name
 */

    @Test
    public void testCheckStrictlyPositive() {
        // v > 0
        Assertions.assertEquals(1, Arguments.checkStrictlyPositive(1));
        // v <= 0
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkStrictlyPositive(0);
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkStrictlyPositive(-1);
        });
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    static double checkStrictlyPositive(double v) {
        if (v > 0) {
            return v;
        }
        // not positive or NaN
        throw new InferenceException(InferenceException.NOT_STRICTLY_POSITIVE, v);
    }

    use significant names that are related to the method name
 */

    @Test
    public void testCheckStrictlyPositive1() {
        // v > 0
        Arguments.checkStrictlyPositive(1.0);
        // v <= 0
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkStrictlyPositive(0.0);
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkStrictlyPositive(-1.0);
        });
        // v = NaN
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkStrictlyPositive(Double.NaN);
        });
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    static void checkStrictlyPositive(double[] values) {
        for (final double v : values) {
            // Logic negation detects NaN
            if (!(v > 0)) {
                throw new InferenceException(InferenceException.NOT_STRICTLY_POSITIVE, v);
            }
        }
    }

    use significant names that are related to the method name
 */

    @Test
    public void testCheckStrictlyPositive2() {
        // v > 0
        Arguments.checkStrictlyPositive(new double[]{1.0});
        Arguments.checkStrictlyPositive(new double[]{1.0, 1.0});
        // v <= 0
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkStrictlyPositive(new double[]{0.0});
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkStrictlyPositive(new double[]{0.0, 0.0});
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkStrictlyPositive(new double[]{-1.0});
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkStrictlyPositive(new double[]{-1.0, -1.0});
        });
        // v = NaN
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkStrictlyPositive(new double[]{Double.NaN});
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkStrictlyPositive(new double[]{Double.NaN, Double.NaN});
        });
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    static double checkFinite(double v) {
        if (!Double.isFinite(v)) {
            throw new InferenceException("Non-finite input value: " + v);
        }
        return v;
    }

    use significant names that are related to the method name
 */

    @Test
    public void testCheckFinite() {
        // v is finite
        Arguments.checkFinite(1.0);
        // v is infinite
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkFinite(Double.POSITIVE_INFINITY);
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkFinite(Double.NEGATIVE_INFINITY);
        });
        // v is NaN
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkFinite(Double.NaN);
        });
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    static void checkNonNaN(double[] values) {
        for (final double v : values) {
            if (Double.isNaN(v)) {
                throw new InferenceException("NaN input value");
            }
        }
    }

    use significant names that are related to the method name
 */

    @Test
    public void testCheckNonNaN() {
        // v is not NaN
        Arguments.checkNonNaN(new double[]{1.0});
        Arguments.checkNonNaN(new double[]{1.0, 1.0});
        // v is NaN
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkNonNaN(new double[]{Double.NaN});
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkNonNaN(new double[]{1.0, Double.NaN});
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkNonNaN(new double[]{Double.NaN, 1.0});
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkNonNaN(new double[]{Double.NaN, Double.NaN});
        });
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    static void checkRectangular(long[][] array) {
        final int first = array[0].length;
        for (int i = 1; i < array.length; i++) {
            if (array[i].length != first) {
                throw new InferenceException(InferenceException.NOT_RECTANGULAR, array[i].length, first);
            }
        }
    }

    use significant names that are related to the method name
 */

    @Test
    public void testCheckRectangular() {
        // is rectangular
        Arguments.checkRectangular(new long[][]{{0}});
        Arguments.checkRectangular(new long[][]{{0, 0}});
        Arguments.checkRectangular(new long[][]{{0}, {0}});
        Arguments.checkRectangular(new long[][]{{0, 0}, {0, 0}});
        // is not rectangular
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkRectangular(new long[][]{{0}, {0, 0}});
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkRectangular(new long[][]{{0, 0}, {0}});
        });
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    static void checkValuesRequiredSize(int size, int required) {
        if (size < required) {
            throw new InferenceException(InferenceException.VALUES_REQUIRED, size, required);
        }
    }

    use significant names that are related to the method name
 */

    @Test
    public void testCheckValuesRequiredSize() {
        // size >= required
        Arguments.checkValuesRequiredSize(1, 1);
        Arguments.checkValuesRequiredSize(2, 1);
        Arguments.checkValuesRequiredSize(2, 2);
        // size < required
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkValuesRequiredSize(1, 2);
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkValuesRequiredSize(0, 1);
        });
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    static void checkCategoriesRequiredSize(int size, int required) {
        if (size < required) {
            throw new InferenceException(InferenceException.CATEGORIES_REQUIRED, size, required);
        }
    }

    use significant names that are related to the method name
 */

    @Test
    public void testCheckCategoriesRequiredSize() {
        // size >= required
        Arguments.checkCategoriesRequiredSize(1, 1);
        Arguments.checkCategoriesRequiredSize(2, 1);
        Arguments.checkCategoriesRequiredSize(2, 2);
        // size < required
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkCategoriesRequiredSize(1, 2);
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkCategoriesRequiredSize(0, 1);
        });
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    static void checkValuesSizeMatch(int size1, int size2) {
        if (size1 != size2) {
            throw new InferenceException(InferenceException.VALUES_MISMATCH, size1, size2);
        }
    }

    use significant names that are related to the method name
 */

    @Test
    public void testCheckValuesSizeMatch() {
        // size1 == size2
        Arguments.checkValuesSizeMatch(1, 1);
        Arguments.checkValuesSizeMatch(2, 2);
        // size1 != size2
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkValuesSizeMatch(1, 2);
        });
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    static <E extends Enum<E>> E checkOption(E v, EnumSet<E> allowed) {
        if (!allowed.contains(v)) {
            throw new InferenceException("Invalid option: " + v);
        }
        return v;
    }

    use significant names that are related to the method name
 */

    @Test
    public void testCheckOption() {
        // valid option
        EnumSet<Enum> allowed = EnumSet.of(Enum.ONE, Enum.TWO);
        Arguments.checkOption(Enum.ONE, allowed);
        Arguments.checkOption(Enum.TWO, allowed);
        // invalid option
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkOption(Enum.THREE, allowed);
        });
    }

    private enum Enum {
        ONE, TWO, THREE
    }

//___________________________________________________________________________________________________________________

/*create a test suite for this method:

    static void checkTable(int[][] table) {
        if (table.length != TWO || table[0].length != TWO || table[1].length != TWO) {
            throw new InferenceException("Require a 2-by-2 contingency table");
        }
        // Must all be positive
        final int a = table[0][0];
        final int b = table[0][1];
        final int c = table[1][0];
        final int d = table[1][1];
        // Bitwise OR combines the sign bit from all values
        Arguments.checkNonNegative(a | b | c | d);
        // Sum must be an integer
        final long sum = (long) a + b + c + d;
        if (sum > Integer.MAX_VALUE) {
            throw new InferenceException(InferenceException.X_GT_Y, sum, Integer.MAX_VALUE);
        }
        Arguments.checkStrictlyPositive((int) sum);
    }
}

    use significant names that are related to the method name
 */

    @Test
    public void testCheckTable() {
        // valid table
        Arguments.checkTable(new int[][]{{1, 1}, {1, 1}});
        // invalid table
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkTable(new int[][]{{1, 1}, {1}});
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkTable(new int[][]{{1, 1}, {1, 1}, {1, 1}});
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkTable(new int[][]{{1, 1}, {1, 1}, {1, 1}});
        });
        // not all positive
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkTable(new int[][]{{-1, 1}, {1, 1}});
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkTable(new int[][]{{1, -1}, {1, 1}});
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkTable(new int[][]{{1, 1}, {-1, 1}});
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkTable(new int[][]{{1, 1}, {1, -1}});
        });
        // sum not an integer
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkTable(new int[][]{{2147483647, 1}, {1, 1}});
        });
        Assertions.assertThrows(InferenceException.class, () -> {
            Arguments.checkTable(new int[][]{{1, 2147483647}, {1, 1}});
        });
    }
}