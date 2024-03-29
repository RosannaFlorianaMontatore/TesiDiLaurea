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
package org.apache.commons.numbers.gamma;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link ErfDifference}.
 */
class ErfDifferenceTest {
    /**
     * Test the implementation of ErfDifference.value(double, double) for consistency
     * with results obtained from Erf.value(double) and Erfc.value(double).
     */
    @Test
    void testTwoArgumentErf() {
        final double[] xi = new double[] {-2, -1, -0.9, -0.1, 0, 0.1, 0.9, 1, 2};
        for (double x1 : xi) {
            for (double x2 : xi) {
                double a = ErfDifference.value(x1, x2);
                double b = Erf.value(x2) - Erf.value(x1);
                double c = Erfc.value(x1) - Erfc.value(x2);
                Assertions.assertEquals(a, b, 1e-15);
                Assertions.assertEquals(a, c, 1e-15);
            }
        }
    }

    /**
     * Assert the critical value for the ErfDifference.
     * This test will fail if the Erf implementation is changed
     * and the ErfDifference assumptions are invalidated.
     */
    @Test
    void assertCriticalValue() {
        // Value copied from the ErfDifference class.
        // This was identified by a binary search.
        final double x = 0.47693627620446993;
        Assertions.assertEquals(0.5, Erf.value(x));
        Assertions.assertTrue(Erf.value(Math.nextUp(x)) > 0.5);
        Assertions.assertEquals(0.5, Erfc.value(x));
        Assertions.assertTrue(Erfc.value(Math.nextUp(x)) < 0.5);
    }
}
