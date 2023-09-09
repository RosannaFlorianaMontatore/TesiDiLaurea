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

import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * Test cases for {@link ExponentialDistribution}.
 * Extends {@link BaseContinuousDistributionTest}. See javadoc of that class for details.
 */
class ExponentialDistributionTest extends BaseContinuousDistributionTest {
    @Override
    ContinuousDistribution makeDistribution(Object... parameters) {
        final double mean = (Double) parameters[0];
        return ExponentialDistribution.of(mean);
    }

    @Override
    Object[][] makeInvalidParameters() {
        return new Object[][] {
            {0.0},
            {-0.1}
        };
    }

    @Override
    String[] getParameterNames() {
        return new String[] {"Mean"};
    }

    @Override
    protected double getRelativeTolerance() {
        // Tolerance is 8.881784197001252E-16
        return 4 * RELATIVE_EPS;
    }

    //------------ Additional tests -------------------------------------------

    @Test
    void testProbabilityRange() {
        final double actual = ExponentialDistribution.of(5).probability(0.25, 0.75);
        TestUtils.assertEquals(0.0905214480756562, actual, DoubleTolerances.ulps(1));
    }

    @Test
    void testAdditionalDensity() {
        final ExponentialDistribution d1 = ExponentialDistribution.of(1);
        Assertions.assertEquals(0.0, d1.density(-1e-9));
        Assertions.assertEquals(1.0, d1.density(0.0));
        Assertions.assertEquals(0.0, d1.density(1000.0));
        Assertions.assertEquals(Math.exp(-1), d1.density(1.0));
        Assertions.assertEquals(Math.exp(-2), d1.density(2.0));

        final ExponentialDistribution d2 = ExponentialDistribution.of(3);
        Assertions.assertEquals(1 / 3.0, d2.density(0.0));

        // computed using R 3.4.0: print(dexp(1, rate=1/3), digits=20)
        Assertions.assertEquals(0.23884377019126309949, d2.density(1.0), 1e-15);

        // computed using R 3.4.0: print(dexp(2, rate=1/3), digits=20)
        Assertions.assertEquals(0.17113903967753066326, d2.density(2.0), 1e-15);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "exppdf.csv")
    void testPDF(double mean, double x, BigDecimal expected) {
        final double e = expected.doubleValue();
        final double a = ExponentialDistribution.of(mean).density(x);
        // Require high precision.
        // This has max error of 3 ulp if using exp(logDensity(x)).
        Assertions.assertEquals(e, a, 2 * Math.ulp(e),
            () -> "ULP error: " + expected.subtract(new BigDecimal(a)).doubleValue() / Math.ulp(e));
    }
}
