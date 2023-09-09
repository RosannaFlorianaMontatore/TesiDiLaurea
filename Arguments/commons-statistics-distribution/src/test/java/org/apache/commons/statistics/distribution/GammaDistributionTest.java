/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.statistics.distribution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.apache.commons.numbers.gamma.LanczosApproximation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Test cases for {@link GammaDistribution}.
 * Extends {@link BaseContinuousDistributionTest}. See javadoc of that class for details.
 */
class GammaDistributionTest extends BaseContinuousDistributionTest {
    private static final double HALF_LOG_2_PI = 0.5 * Math.log(2.0 * Math.PI);

    @Override
    ContinuousDistribution makeDistribution(Object... parameters) {
        final double shape = (Double) parameters[0];
        final double scale = (Double) parameters[1];
        return GammaDistribution.of(shape, scale);
    }

    @Override
    Object[][] makeInvalidParameters() {
        return new Object[][] {
            {0.0, 1.0},
            {-0.1, 1.0},
            {1.0, 0.0},
            {1.0, -0.1},
        };
    }

    @Override
    String[] getParameterNames() {
        return new String[] {"Shape", "Scale"};
    }

    @Override
    protected double getRelativeTolerance() {
        // Tolerance is 8.881784197001252E-16
        return 4 * RELATIVE_EPS;
    }

    //-------------------- Additional test cases -------------------------------

    @ParameterizedTest
    @MethodSource
    void testAdditionalMoments(double shape, double scale, double mean, double variance) {
        final GammaDistribution dist = GammaDistribution.of(shape, scale);
        testMoments(dist, mean, variance, DoubleTolerances.equals());
    }

    static Stream<Arguments> testAdditionalMoments() {
        return Stream.of(
            Arguments.of(1, 2, 2, 4),
            Arguments.of(1.1, 4.2, 1.1 * 4.2, 1.1 * 4.2 * 4.2),
            // scipy.stats.gamma(shape, scale=scale).stats()
            Arguments.of(0.5, 10, 5, 50),
            Arguments.of(0.5, 7.5, 3.75, 28.125),
            Arguments.of(0.25, 10, 2.5, 25)
        );
    }

    @ParameterizedTest
    @CsvSource({
        "4.0, 2.0, -1.0, 0.0",
        "4.0, 2.0, 15.501, 0.94989465156755404",
        "4.0, 1.0, 0.504, 0.0018026739713985257",
        "1.0, 2.0, 10.011, 0.99329900998454213",
        "2.0, 2.0, 5.000, 0.71270250481635422",
    })
    void testAdditionalCumulativeProbability(double a, double b, double x, double expected) {
        final GammaDistribution dist = GammaDistribution.of(a, b);
        final double actual = dist.cumulativeProbability(x);
        Assertions.assertEquals(expected, actual, expected * 1e-15, () -> "probability for " + x);
    }

    @ParameterizedTest
    @CsvSource({
        "4.0, 2.0, 0.94989465156755404, 15.501",
        "4.0, 1.0, 0.0018026739713985257, 0.504",
        "1.0, 2.0, 0.99329900998454213, 10.011",
        "2.0, 2.0, 0.71270250481635422, 5.0",
    })
    void testAdditionalInverseCumulativeProbability(double a, double b, double p, double expected) {
        final GammaDistribution dist = GammaDistribution.of(a, b);
        final double actual = dist.inverseCumulativeProbability(p);
        Assertions.assertEquals(expected, actual, expected * 5e-15, () -> "critical value for " + p);
    }

    @ParameterizedTest
    @MethodSource
    void testAdditionalDensity(double alpha, double rate, double[] x, double[] expected) {
        final GammaDistribution dist = GammaDistribution.of(alpha, 1 / rate);
        testDensity(dist, x, expected, createRelTolerance(1e-9));
    }

    static Stream<Arguments> testAdditionalDensity() {
        final double[] x = {-0.1, 1e-6, 0.5, 1, 2, 5};
        final double[] x1 = new double[]{1e-100, 1e-10, 1e-5, 0.1};
        return Stream.of(
            // R2.5: print(dgamma((x, shape=1, rate=1), digits=10)
            Arguments.of(1, 1, x, new double[]{0.000000000000, 0.999999000001, 0.606530659713, 0.367879441171, 0.135335283237, 0.006737946999}),
            // R2.5: print(dgamma((x, shape=2, rate=1), digits=10)
            Arguments.of(2, 1, x, new double[]{0.000000000000, 0.000000999999, 0.303265329856, 0.367879441171, 0.270670566473, 0.033689734995}),
            // R2.5: print(dgamma((x, shape=4, rate=1), digits=10)
            Arguments.of(4, 1, x, new double[]{0.000000000e+00, 1.666665000e-19, 1.263605541e-02, 6.131324020e-02, 1.804470443e-01, 1.403738958e-01}),
            // R2.5: print(dgamma((x, shape=4, rate=10), digits=10)
            Arguments.of(4, 10, x, new double[]{0.000000000e+00, 1.666650000e-15, 1.403738958e+00, 7.566654960e-02, 2.748204830e-05, 4.018228850e-17}),
            // R2.5: print(dgamma((x, shape=.1, rate=10), digits=10)
            Arguments.of(0.1, 10, x, new double[]{0.000000000e+00, 3.323953832e+04, 1.663849010e-03, 6.007786726e-06, 1.461647647e-10, 5.996008322e-24}),
            // R2.5: print(dgamma((x, shape=.1, rate=20), digits=10)
            Arguments.of(0.1, 20, x, new double[]{0.000000000e+00, 3.562489883e+04, 1.201557345e-05, 2.923295295e-10, 3.228910843e-19, 1.239484589e-45}),
            // R2.5: print(dgamma((x, shape=.1, rate=4), digits=10)
            Arguments.of(0.1, 4, x, new double[]{0.000000000e+00, 3.032938388e+04, 3.049322494e-02, 2.211502311e-03, 2.170613371e-05, 5.846590589e-11}),
            // R2.5: print(dgamma((x, shape=.1, rate=1), digits=10)
            Arguments.of(0.1, 1, x, new double[]{0.000000000e+00, 2.640334143e+04, 1.189704437e-01, 3.866916944e-02, 7.623306235e-03, 1.663849010e-04}),
            // To force overflow condition
            // R2.5: print(dgamma((x, shape=1000, rate=100), digits=10)
            Arguments.of(1000, 100, x, new double[]{0.000000000e+00, 0.000000000e+00, 0.000000000e+00, 0.000000000e+00, 0.000000000e+00, 3.304830256e-84}),

            // Test a shape far below 1.
            // Support for very small shape parameters was fixed in STATISTICS-39.
            // R2.5: print(dgamma((x1, shape=0.05, rate=1), digits=20)
            Arguments.of(0.05, 1, x1,
                new double[] {
                    5.1360843263583843333e+93, 1.6241724724359893799e+08,
                    2.8882035841935007738e+03, 4.1419294512123655538e-01
                })
        );
    }

    @ParameterizedTest
    @MethodSource
    void testAdditionalLogDensity(double alpha, double rate, double[] x, double[] expected) {
        final GammaDistribution dist = GammaDistribution.of(alpha, 1 / rate);
        testLogDensity(dist, x, expected, createRelTolerance(1e-9));
    }

    static Stream<Arguments> testAdditionalLogDensity() {
        final double[] x = {-0.1, 1e-6, 0.5, 1, 2, 5};
        final double[] x1 = {1e-315, 1e-320, 1e-323};
        final double inf = Double.POSITIVE_INFINITY;
        return Stream.of(
            // R2.5: print(dgamma((x, shape=1, rate=1, log=TRUE), digits=10)
            Arguments.of(1, 1, x, new double[]{-inf, -1e-06, -5e-01, -1e+00, -2e+00, -5e+00}),
            // R2.5: print(dgamma((x, shape=2, rate=1, log=TRUE), digits=10)
            Arguments.of(2, 1, x, new double[]{-inf, -13.815511558, -1.193147181, -1.000000000, -1.306852819, -3.390562088}),
            // R2.5: print(dgamma((x, shape=4, rate=1, log=TRUE), digits=10)
            Arguments.of(4, 1, x, new double[]{-inf, -43.238292143, -4.371201011, -2.791759469, -1.712317928, -1.963445732}),
            // R2.5: print(dgamma((x, shape=4, rate=10, log=TRUE), digits=10)
            Arguments.of(4, 10, x, new double[]{-inf, -34.0279607711, 0.3391393611, -2.5814190973, -10.5019775556, -37.7531053599}),
            // R2.5: print(dgamma((x, shape=.1, rate=10, log=TRUE), digits=10)
            Arguments.of(0.1, 10, x, new double[]{-inf, 10.41149536, -6.39862168, -12.02245414, -22.64628660, -53.47094826}),
            // R2.5: print(dgamma((x, shape=.1, rate=20, log=TRUE), digits=10)
            Arguments.of(0.1, 20, x, new double[]{-inf, 10.48080008, -11.32930696, -21.95313942, -42.57697189, -103.40163355}),
            // R2.5: print(dgamma((x, shape=.1, rate=4, log=TRUE), digits=10)
            Arguments.of(0.1, 4, x, new double[]{-inf, 10.319872287, -3.490250753, -6.114083216, -10.737915678, -23.562577337}),
            // R2.5: print(dgamma((x, shape=.1, rate=1, log=TRUE), digits=10)
            Arguments.of(0.1, 1, x, new double[]{-inf, 10.181245850, -2.128880189, -3.252712652, -4.876545114, -8.701206773}),
            // To force overflow condition to pdf=zero
            // R2.5: print(dgamma((x, shape=1000, rate=100, log=TRUE), digits=10)
            Arguments.of(1000, 100, x, new double[]{-inf, -15101.7453846, -2042.5042706, -1400.0502372, -807.5962038, -192.2217627}),
            // To force overflow condition to pdf=infinity
            // scipy.stats gamma(1e-2).logpdf(x1)
            Arguments.of(0.01, 1, x1,
                new double[]{713.46168137365419, 724.85948860402209, 731.70997561537104})
        );
    }

    private static double logGamma(double x) {
        /*
         * This is a copy of
         * double Gamma.logGamma(double)
         * prior to MATH-849
         */
        if (Double.isNaN(x) || x <= 0.0) {
            return Double.NaN;
        }
        final double sum = LanczosApproximation.value(x);
        final double tmp = x + LanczosApproximation.g() + .5;
        return ((x + .5) * Math.log(tmp)) - tmp +
            HALF_LOG_2_PI + Math.log(sum / x);
    }

    private static double density(double x,
                                  double shape,
                                  double scale) {
        /*
         * This is a copy of
         * double GammaDistribution.density(double)
         * prior to MATH-753.
         */
        if (x < 0) {
            return 0;
        }
        return Math.pow(x / scale, shape - 1) / scale *
               Math.exp(-x / scale) / Math.exp(logGamma(shape));
    }

    /**
     * MATH-753: large values of x or shape parameter cause density(double) to
     * overflow. Reference data is generated with the Maxima script
     * gamma-distribution.mac, which can be found in
     * src/test/resources/org/apache/commons/statistics/distribution.
     *
     * @param shape Shape of gamma distribution (scale is assumed to be 1)
     * @param meanNoOF Allowed mean ULP error when the computed value does not overflow using the old method
     * @param sdNoOF Allowed SD ULP error when the computed value does not overflow using the old method
     * @param meanOF Allowed mean ULP error when the computed value overflows using the old method
     * @param sdOF Allowed SD ULP error when the computed value overflows using the old method
     * @param resourceName Resource name containing a pair of comma separated values for the
     * random variable x and the expected value of the gamma distribution: x, gamma(x; shape, scale=1)
     */
    @ParameterizedTest
    @MethodSource
    void testMath753(double shape,
                     double meanNoOF, double sdNoOF,
                     double meanOF, double sdOF,
                     String resourceName) {
        final GammaDistribution dist = GammaDistribution.of(shape, 1.0);
        final SummaryStatistics statOld = new SummaryStatistics();
        // statNewNoOF = No overflow of old function
        // statNewOF   = Overflow of old function
        final SummaryStatistics statNewNoOF = new SummaryStatistics();
        final SummaryStatistics statNewOF = new SummaryStatistics();

        final InputStream resourceAsStream = this.getClass().getResourceAsStream(resourceName);
        Assertions.assertNotNull(resourceAsStream, () -> "Could not find resource " + resourceName);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(resourceAsStream))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                if (line.startsWith("#")) {
                    continue;
                }
                final String[] tokens = line.split(", ");
                Assertions.assertEquals(2, tokens.length, "expected two floating-point values");
                final double x = Double.parseDouble(tokens[0]);
                final String msg = "x = " + x + ", shape = " + shape +
                                   ", scale = 1.0";
                final double expected = Double.parseDouble(tokens[1]);
                final double ulp = Math.ulp(expected);
                final double actualOld = density(x, shape, 1.0);
                final double actualNew = dist.density(x);
                final double errOld = Math.abs((actualOld - expected) / ulp);
                final double errNew = Math.abs((actualNew - expected) / ulp);

                if (!Double.isFinite(actualOld)) {
                    Assertions.assertTrue(Double.isFinite(actualNew), msg);
                    statNewOF.addValue(errNew);
                } else {
                    statOld.addValue(errOld);
                    statNewNoOF.addValue(errNew);
                }
            }
            if (statOld.getN() != 0) {
                /*
                 * If no overflow occurs, check that new implementation is
                 * better than old one.
                 */
                final StringBuilder sb = new StringBuilder("shape = ");
                sb.append(shape);
                sb.append(", scale = 1.0\n");
                sb.append("Old implementation\n");
                sb.append("------------------\n");
                sb.append(statOld.toString());
                sb.append("New implementation\n");
                sb.append("------------------\n");
                sb.append(statNewNoOF.toString());
                final String msg = sb.toString();

                final double oldMin = statOld.getMin();
                final double newMin = statNewNoOF.getMin();
                Assertions.assertTrue(newMin <= oldMin, msg);

                final double oldMax = statOld.getMax();
                final double newMax = statNewNoOF.getMax();
                Assertions.assertTrue(newMax <= oldMax, msg);

                final double oldMean = statOld.getMean();
                final double newMean = statNewNoOF.getMean();
                Assertions.assertTrue(newMean <= oldMean, msg);

                final double oldSd = statOld.getStandardDeviation();
                final double newSd = statNewNoOF.getStandardDeviation();
                Assertions.assertTrue(newSd <= oldSd, msg);

                Assertions.assertTrue(newMean <= meanNoOF, msg);
                Assertions.assertTrue(newSd <= sdNoOF, msg);
            }
            if (statNewOF.getN() != 0) {
                final double newMean = statNewOF.getMean();
                final double newSd = statNewOF.getStandardDeviation();

                final StringBuilder sb = new StringBuilder("shape = ");
                sb.append(shape);
                sb.append(", scale = 1.0");
                sb.append(", max. mean error (ulps) = ");
                sb.append(meanOF);
                sb.append(", actual mean error (ulps) = ");
                sb.append(newMean);
                sb.append(", max. sd of error (ulps) = ");
                sb.append(sdOF);
                sb.append(", actual sd of error (ulps) = ");
                sb.append(newSd);
                final String msg = sb.toString();

                Assertions.assertTrue(newMean <= meanOF, msg);
                Assertions.assertTrue(newSd <= sdOF, msg);
            }
        } catch (final IOException e) {
            Assertions.fail(e);
        }
    }

    static Stream<Arguments> testMath753() {
        return Stream.of(
            Arguments.of(0.25, 1.0, 1.0, 0.0, 0.0, "gamma-distribution-shape-0.25.csv"),
            Arguments.of(0.5, 1.0, 1.0, 0.0, 0.0, "gamma-distribution-shape-0.5.csv"),
            Arguments.of(0.75, 1.0, 1.0, 0.0, 0.0, "gamma-distribution-shape-0.75.csv"),
            Arguments.of(1.0, 1.0, 0.5, 0.0, 0.0, "gamma-distribution-shape-1.csv"),
            Arguments.of(8.0, 1.0, 1.0, 0.0, 0.0, "gamma-distribution-shape-8.csv"),
            Arguments.of(10.0, 1.0, 1.0, 0.0, 0.0, "gamma-distribution-shape-10.csv"),
            Arguments.of(100.0, 2.0, 1.0, 0.0, 0.0, "gamma-distribution-shape-100.csv"),
            Arguments.of(142.0, 1.5, 1.0, 40.0, 40.0, "gamma-distribution-shape-142.csv"),
            Arguments.of(1000.0, 1.0, 1.0, 160.0, 200.0, "gamma-distribution-shape-1000.csv")
        );
    }
}
