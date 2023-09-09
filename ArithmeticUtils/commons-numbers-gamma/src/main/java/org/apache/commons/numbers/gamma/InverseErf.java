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

/**
 * Inverse of the <a href="http://mathworld.wolfram.com/Erf.html">error function</a>.
 */
public final class InverseErf {
    /** Private constructor. */
    private InverseErf() {
        // intentionally empty.
    }

    /**
     * Returns the inverse error function.
     *
     * <p>Special cases:
     * <ul>
     * <li>If the argument is 0, then the result is 0.
     * <li>If the argument is 1, then the result is positive infinity.
     * <li>If the argument is -1, then the result is negative infinity.
     * <li>If the argument is outside the interval {@code [-1, 1]}, then the result is nan.
     * <li>If the argument is nan, then the result is nan.
     * </ul>
     *
     * @param x Value (in {@code [-1, 1]})
     * @return t such that {@code x =} {@link Erf#value(double) Erf.value(t)}.
     */
    public static double value(final double x) {
        return BoostErf.erfInv(x);
    }
}
