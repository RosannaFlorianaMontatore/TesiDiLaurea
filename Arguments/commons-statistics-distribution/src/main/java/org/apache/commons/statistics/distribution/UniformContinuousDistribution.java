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

import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.sampling.distribution.ContinuousUniformSampler;

/**
 * Implementation of the uniform distribution.
 *
 * <p>The probability density function of \( X \) is:
 *
 * <p>\[ f(x; a, b) = \frac{1}{b-a} \]
 *
 * <p>for \( -\infty \lt a \lt b \lt \infty \) and
 * \( x \in [a, b] \).
 *
 * @see <a href="https://en.wikipedia.org/wiki/Uniform_distribution_(continuous)">
 * Uniform distribution (Wikipedia)</a>
 * @see <a href="https://mathworld.wolfram.com/UniformDistribution.html">
 * Uniform distribution (MathWorld)</a>
 */
public final class UniformContinuousDistribution extends AbstractContinuousDistribution {
    /** Lower bound of this distribution (inclusive). */
    private final double lower;
    /** Upper bound of this distribution (exclusive). */
    private final double upper;
    /** Range between the upper and lower bound of this distribution (cached for computations). */
    private final double upperMinusLower;
    /** Cache of the density. */
    private final double pdf;
    /** Cache of the log density. */
    private final double logPdf;

    /**
     * @param lower Lower bound of this distribution (inclusive).
     * @param upper Upper bound of this distribution (inclusive).
     */
    private UniformContinuousDistribution(double lower,
                                          double upper) {
        this.lower = lower;
        this.upper = upper;
        upperMinusLower = upper - lower;
        pdf = 1.0 / upperMinusLower;
        logPdf = -Math.log(upperMinusLower);
    }

    /**
     * Creates a uniform continuous distribution.
     *
     * @param lower Lower bound of this distribution (inclusive).
     * @param upper Upper bound of this distribution (inclusive).
     * @return the distribution
     * @throws IllegalArgumentException if {@code lower >= upper} or the range between the bounds
     * is not finite
     */
    public static UniformContinuousDistribution of(double lower,
                                                   double upper) {
        if (lower >= upper) {
            throw new DistributionException(DistributionException.INVALID_RANGE_LOW_GTE_HIGH,
                                            lower, upper);
        }
        if (!Double.isFinite(upper - lower)) {
            throw new DistributionException("Range %s is not finite", upper - lower);
        }
        return new UniformContinuousDistribution(lower, upper);
    }

    /** {@inheritDoc} */
    @Override
    public double density(double x) {
        if (x < lower ||
            x > upper) {
            return 0;
        }
        return pdf;
    }

    /** {@inheritDoc} */
    @Override
    public double probability(double x0,
                              double x1) {
        if (x0 > x1) {
            throw new DistributionException(DistributionException.INVALID_RANGE_LOW_GT_HIGH, x0, x1);
        }
        if (x0 >= upper || x1 <= lower) {
            // (x0, x1] does not overlap [lower, upper]
            return 0;
        }

        // x0 < upper
        // x1 >= lower

        // Find the range between x0 and x1 that is within [lower, upper].
        final double l = Math.max(lower, x0);
        final double u = Math.min(upper, x1);

        return (u - l) / upperMinusLower;
    }

    /** {@inheritDoc} */
    @Override
    public double logDensity(double x) {
        if (x < lower ||
            x > upper) {
            return Double.NEGATIVE_INFINITY;
        }
        return logPdf;
    }

    /** {@inheritDoc} */
    @Override
    public double cumulativeProbability(double x)  {
        if (x <= lower) {
            return 0;
        }
        if (x >= upper) {
            return 1;
        }
        return (x - lower) / upperMinusLower;
    }

    /** {@inheritDoc} */
    @Override
    public double survivalProbability(double x) {
        if (x <= lower) {
            return 1;
        }
        if (x >= upper) {
            return 0;
        }
        return (upper - x) / upperMinusLower;
    }

    /** {@inheritDoc} */
    @Override
    public double inverseCumulativeProbability(double p) {
        ArgumentUtils.checkProbability(p);
        // Avoid floating-point error for lower + p * (upper - lower) when p == 1.
        return p == 1 ? upper : p * upperMinusLower + lower;
    }

    /** {@inheritDoc} */
    @Override
    public double inverseSurvivalProbability(double p) {
        ArgumentUtils.checkProbability(p);
        // Avoid floating-point error for upper - p * (upper - lower) when p == 1.
        return p == 1 ? lower : upper - p * upperMinusLower;
    }

    /**
     * {@inheritDoc}
     *
     * <p>For lower bound \( a \) and upper bound \( b \), the mean is \( \frac{1}{2} (a + b) \).
     */
    @Override
    public double getMean() {
        // Avoid overflow
        return 0.5 * lower + 0.5 * upper;
    }

    /**
     * {@inheritDoc}
     *
     * <p>For lower bound \( a \) and upper bound \( b \), the variance is \( \frac{1}{12} (b - a)^2 \).
     */
    @Override
    public double getVariance() {
        return upperMinusLower * upperMinusLower / 12;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The lower bound of the support is equal to the lower bound parameter
     * of the distribution.
     */
    @Override
    public double getSupportLowerBound() {
        return lower;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The upper bound of the support is equal to the upper bound parameter
     * of the distribution.
     */
    @Override
    public double getSupportUpperBound() {
        return upper;
    }

    /** {@inheritDoc} */
    @Override
    public ContinuousDistribution.Sampler createSampler(final UniformRandomProvider rng) {
        // Uniform distribution sampler.
        return ContinuousUniformSampler.of(rng, lower, upper)::sample;
    }
}
