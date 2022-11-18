/*
 * JavaPermutationTools: A Java library for computation on permutations and sequences
 * Copyright 2005-2022 Vincent A. Cicirello, <https://www.cicirello.org/>.
 *
 * This file is part of JavaPermutationTools (https://jpt.cicirello.org/).
 *
 * JavaPermutationTools is free software: you can
 * redistribute it and/or modify it under the terms of the GNU
 * General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * JavaPermutationTools is distributed in the hope
 * that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JavaPermutationTools.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.cicirello.sequences;

import java.util.concurrent.ThreadLocalRandom;
import org.cicirello.math.rand.RandomVariates;

/**
 * An implementation of the SequenceSampler interface is used for generating random samples of array
 * elements, without replacement.
 *
 * @author <a href=https://www.cicirello.org/ target=_top>Vincent A. Cicirello</a>, <a
 *     href=https://www.cicirello.org/ target=_top>https://www.cicirello.org/</a>
 */
public interface SequenceSampler {

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   */
  int[] nextSample(int[] source, int k, int[] target);

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   */
  short[] nextSample(short[] source, int k, short[] target);

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   */
  long[] nextSample(long[] source, int k, long[] target);

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   */
  byte[] nextSample(byte[] source, int k, byte[] target);

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   */
  char[] nextSample(char[] source, int k, char[] target);

  /**
   * Generates a random sample of k elements, without replacement, from a given source String. All n
   * choose k combinations are equally likely, where n is the length of the source String.
   *
   * @param source The source String to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   */
  char[] nextSample(String source, int k, char[] target);

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   */
  double[] nextSample(double[] source, int k, double[] target);

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   */
  float[] nextSample(float[] source, int k, float[] target);

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * @param <T> The type of array elements.
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   */
  <T> T[] nextSample(T[] source, int k, T[] target);

  /**
   * Generates a random sample, without replacement, from a given source array with a specified
   * probability of an element's inclusion in the sample.
   *
   * <p>This method chooses among the {@link SequencePoolSampler}, {@link SequenceReservoirSampler},
   * and {@link SequenceInsertionSampler} classes based on the values of n and p.
   *
   * <p>This approach combining reservoir sampling, pool sampling, and insertion sampling was
   * described in: Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @param source The array from which to sample.
   * @param p The probability that element is included in the sample. The expected sample size is
   *     source.length * p.
   * @return An array containing the sample, whose sample size is simply the length of the array.
   */
  public static byte[] sample(byte[] source, double p) {
    return sample(source, RandomVariates.nextBinomial(source.length, p), null);
  }

  /**
   * Generates a random sample, without replacement, from a given source array with a specified
   * probability of an element's inclusion in the sample.
   *
   * <p>This method chooses among the {@link SequencePoolSampler}, {@link SequenceReservoirSampler},
   * and {@link SequenceInsertionSampler} classes based on the values of n and p.
   *
   * <p>This approach combining reservoir sampling, pool sampling, and insertion sampling was
   * described in: Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @param source The array from which to sample.
   * @param p The probability that element is included in the sample. The expected sample size is
   *     source.length * p.
   * @return An array containing the sample, whose sample size is simply the length of the array.
   */
  public static char[] sample(char[] source, double p) {
    return sample(source, RandomVariates.nextBinomial(source.length, p), null);
  }

  /**
   * Generates a random sample, without replacement, from a given source array with a specified
   * probability of an element's inclusion in the sample.
   *
   * <p>This method chooses among the {@link SequencePoolSampler}, {@link SequenceReservoirSampler},
   * and {@link SequenceInsertionSampler} classes based on the values of n and p.
   *
   * <p>This approach combining reservoir sampling, pool sampling, and insertion sampling was
   * described in: Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @param source The array from which to sample.
   * @param p The probability that element is included in the sample. The expected sample size is
   *     source.length * p.
   * @return An array containing the sample, whose sample size is simply the length of the array.
   */
  public static double[] sample(double[] source, double p) {
    return sample(source, RandomVariates.nextBinomial(source.length, p), null);
  }

  /**
   * Generates a random sample, without replacement, from a given source array with a specified
   * probability of an element's inclusion in the sample.
   *
   * <p>This method chooses among the {@link SequencePoolSampler}, {@link SequenceReservoirSampler},
   * and {@link SequenceInsertionSampler} classes based on the values of n and p.
   *
   * <p>This approach combining reservoir sampling, pool sampling, and insertion sampling was
   * described in: Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @param source The array from which to sample.
   * @param p The probability that element is included in the sample. The expected sample size is
   *     source.length * p.
   * @return An array containing the sample, whose sample size is simply the length of the array.
   */
  public static float[] sample(float[] source, double p) {
    return sample(source, RandomVariates.nextBinomial(source.length, p), null);
  }

  /**
   * Generates a random sample, without replacement, from a given source array with a specified
   * probability of an element's inclusion in the sample.
   *
   * <p>This method chooses among the {@link SequencePoolSampler}, {@link SequenceReservoirSampler},
   * and {@link SequenceInsertionSampler} classes based on the values of n and p.
   *
   * <p>This approach combining reservoir sampling, pool sampling, and insertion sampling was
   * described in: Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @param source The array from which to sample.
   * @param p The probability that element is included in the sample. The expected sample size is
   *     source.length * p.
   * @return An array containing the sample, whose sample size is simply the length of the array.
   */
  public static int[] sample(int[] source, double p) {
    return sample(source, RandomVariates.nextBinomial(source.length, p), null);
  }

  /**
   * Generates a random sample, without replacement, from a given source array with a specified
   * probability of an element's inclusion in the sample.
   *
   * <p>This method chooses among the {@link SequencePoolSampler}, {@link SequenceReservoirSampler},
   * and {@link SequenceInsertionSampler} classes based on the values of n and p.
   *
   * <p>This approach combining reservoir sampling, pool sampling, and insertion sampling was
   * described in: Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @param source The array from which to sample.
   * @param p The probability that element is included in the sample. The expected sample size is
   *     source.length * p.
   * @return An array containing the sample, whose sample size is simply the length of the array.
   */
  public static long[] sample(long[] source, double p) {
    return sample(source, RandomVariates.nextBinomial(source.length, p), null);
  }

  /**
   * Generates a random sample, without replacement, from a given source array with a specified
   * probability of an element's inclusion in the sample.
   *
   * <p>This method chooses among the {@link SequencePoolSampler}, {@link SequenceReservoirSampler},
   * and {@link SequenceInsertionSampler} classes based on the values of n and p.
   *
   * <p>This approach combining reservoir sampling, pool sampling, and insertion sampling was
   * described in: Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @param source The array from which to sample.
   * @param p The probability that element is included in the sample. The expected sample size is
   *     source.length * p.
   * @return An array containing the sample, whose sample size is simply the length of the array.
   */
  public static short[] sample(short[] source, double p) {
    return sample(source, RandomVariates.nextBinomial(source.length, p), null);
  }

  /**
   * Generates a random sample, without replacement, from a given String with a specified
   * probability of a character's inclusion in the sample.
   *
   * <p>This method chooses among the {@link SequencePoolSampler}, {@link SequenceReservoirSampler},
   * and {@link SequenceInsertionSampler} classes based on the values of n and p.
   *
   * <p>This approach combining reservoir sampling, pool sampling, and insertion sampling was
   * described in: Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @param source The String from which to sample.
   * @param p The probability that a character is included in the sample. The expected sample size
   *     is source.length() * p.
   * @return An array containing the sample, whose sample size is simply the length of the array.
   */
  public static char[] sample(String source, double p) {
    return sample(source, RandomVariates.nextBinomial(source.length(), p), null);
  }

  /**
   * Generates a random sample, without replacement, from a given source array with a specified
   * probability of an element's inclusion in the sample.
   *
   * <p>This method chooses among the {@link SequencePoolSampler}, {@link SequenceReservoirSampler},
   * and {@link SequenceInsertionSampler} classes based on the values of n and p.
   *
   * <p>This approach combining reservoir sampling, pool sampling, and insertion sampling was
   * described in: Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @param source The array from which to sample.
   * @param p The probability that element is included in the sample. The expected sample size is
   *     source.length * p.
   * @param <T> The type of array elements.
   * @return An array containing the sample, whose sample size is simply the length of the array.
   */
  public static <T> T[] sample(T[] source, double p) {
    return sample(source, RandomVariates.nextBinomial(source.length, p), null);
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This method chooses among the {@link SequencePoolSampler}, {@link SequenceReservoirSampler},
   * and {@link SequenceInsertionSampler} classes based on the values of n and k.
   *
   * <p>This approach combining reservoir sampling, pool sampling, and insertion sampling was
   * described in: Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>The runtime is O(min(n, k<sup>2</sup>)) and it generates O(min(k, n-k)) random numbers.
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  public static int[] sample(int[] source, int k, int[] target) {
    return SequenceCompositeSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This method chooses among the {@link SequencePoolSampler}, {@link SequenceReservoirSampler},
   * and {@link SequenceInsertionSampler} classes based on the values of n and k.
   *
   * <p>This approach combining reservoir sampling, pool sampling, and insertion sampling was
   * described in: Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>The runtime is O(min(n, k<sup>2</sup>)) and it generates O(min(k, n-k)) random numbers.
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  public static long[] sample(long[] source, int k, long[] target) {
    return SequenceCompositeSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This method chooses among the {@link SequencePoolSampler}, {@link SequenceReservoirSampler},
   * and {@link SequenceInsertionSampler} classes based on the values of n and k.
   *
   * <p>This approach combining reservoir sampling, pool sampling, and insertion sampling was
   * described in: Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>The runtime is O(min(n, k<sup>2</sup>)) and it generates O(min(k, n-k)) random numbers.
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  public static short[] sample(short[] source, int k, short[] target) {
    return SequenceCompositeSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This method chooses among the {@link SequencePoolSampler}, {@link SequenceReservoirSampler},
   * and {@link SequenceInsertionSampler} classes based on the values of n and k.
   *
   * <p>This approach combining reservoir sampling, pool sampling, and insertion sampling was
   * described in: Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>The runtime is O(min(n, k<sup>2</sup>)) and it generates O(min(k, n-k)) random numbers.
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  public static byte[] sample(byte[] source, int k, byte[] target) {
    return SequenceCompositeSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This method chooses among the {@link SequencePoolSampler}, {@link SequenceReservoirSampler},
   * and {@link SequenceInsertionSampler} classes based on the values of n and k.
   *
   * <p>This approach combining reservoir sampling, pool sampling, and insertion sampling was
   * described in: Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>The runtime is O(min(n, k<sup>2</sup>)) and it generates O(min(k, n-k)) random numbers.
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  public static char[] sample(char[] source, int k, char[] target) {
    return SequenceCompositeSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k chars, without replacement, from a given source String. All n
   * choose k combinations are equally likely, where n is the length of the source String.
   *
   * <p>This method chooses among the {@link SequencePoolSampler}, {@link SequenceReservoirSampler},
   * and {@link SequenceInsertionSampler} classes based on the values of n and k.
   *
   * <p>This approach combining reservoir sampling, pool sampling, and insertion sampling was
   * described in: Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>The runtime is O(min(n, k<sup>2</sup>)) and it generates O(min(k, n-k)) random numbers.
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length()).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length()
   * @throws NegativeArraySizeException if k &lt; 0
   */
  public static char[] sample(String source, int k, char[] target) {
    return SequenceCompositeSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This method chooses among the {@link SequencePoolSampler}, {@link SequenceReservoirSampler},
   * and {@link SequenceInsertionSampler} classes based on the values of n and k.
   *
   * <p>This approach combining reservoir sampling, pool sampling, and insertion sampling was
   * described in: Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>The runtime is O(min(n, k<sup>2</sup>)) and it generates O(min(k, n-k)) random numbers.
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  public static double[] sample(double[] source, int k, double[] target) {
    return SequenceCompositeSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This method chooses among the {@link SequencePoolSampler}, {@link SequenceReservoirSampler},
   * and {@link SequenceInsertionSampler} classes based on the values of n and k.
   *
   * <p>This approach combining reservoir sampling, pool sampling, and insertion sampling was
   * described in: Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>The runtime is O(min(n, k<sup>2</sup>)) and it generates O(min(k, n-k)) random numbers.
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  public static float[] sample(float[] source, int k, float[] target) {
    return SequenceCompositeSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This method chooses among the {@link SequencePoolSampler}, {@link SequenceReservoirSampler},
   * and {@link SequenceInsertionSampler} classes based on the values of n and k.
   *
   * <p>This approach combining reservoir sampling, pool sampling, and insertion sampling was
   * described in: Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>The runtime is O(min(n, k<sup>2</sup>)) and it generates O(min(k, n-k)) random numbers.
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @param <T> The type of array elements.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  public static <T> T[] sample(T[] source, int k, T[] target) {
    return SequenceCompositeSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This implements the algorithm SELECT of S. Goodman and S. Hedetniemi, as described in: J
   * Ernvall, O Nevalainen, "An Algorithm for Unbiased Random Sampling," The Computer Journal,
   * 25(1):45-47, 1982.
   *
   * <p>The runtime is O(n) and it generates O(k) random numbers. Thus, it is a better choice than
   * sampleReservoir when k &lt; n-k. However, this uses O(n) extra space, whereas the reservoir
   * algorithm uses no extra space.
   *
   * <p>This method is safe to use with threads, as it uses ThreadLocalRandom as the underlying
   * source of randomness.
   *
   * @deprecated This method is deprecated, and replaced by the {@link SequencePoolSampler} class.
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  @Deprecated
  public static int[] samplePool(int[] source, int k, int[] target) {
    return SequencePoolSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This implements the algorithm SELECT of S. Goodman and S. Hedetniemi, as described in: J
   * Ernvall, O Nevalainen, "An Algorithm for Unbiased Random Sampling," The Computer Journal,
   * 25(1):45-47, 1982.
   *
   * <p>The runtime is O(n) and it generates O(k) random numbers. Thus, it is a better choice than
   * sampleReservoir when k &lt; n-k. However, this uses O(n) extra space, whereas the reservoir
   * algorithm uses no extra space.
   *
   * <p>This method is safe to use with threads, as it uses ThreadLocalRandom as the underlying
   * source of randomness.
   *
   * @deprecated This method is deprecated, and replaced by the {@link SequencePoolSampler} class.
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  @Deprecated
  public static long[] samplePool(long[] source, int k, long[] target) {
    return SequencePoolSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This implements the algorithm SELECT of S. Goodman and S. Hedetniemi, as described in: J
   * Ernvall, O Nevalainen, "An Algorithm for Unbiased Random Sampling," The Computer Journal,
   * 25(1):45-47, 1982.
   *
   * <p>The runtime is O(n) and it generates O(k) random numbers. Thus, it is a better choice than
   * sampleReservoir when k &lt; n-k. However, this uses O(n) extra space, whereas the reservoir
   * algorithm uses no extra space.
   *
   * <p>This method is safe to use with threads, as it uses ThreadLocalRandom as the underlying
   * source of randomness.
   *
   * @deprecated This method is deprecated, and replaced by the {@link SequencePoolSampler} class.
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  @Deprecated
  public static short[] samplePool(short[] source, int k, short[] target) {
    return SequencePoolSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This implements the algorithm SELECT of S. Goodman and S. Hedetniemi, as described in: J
   * Ernvall, O Nevalainen, "An Algorithm for Unbiased Random Sampling," The Computer Journal,
   * 25(1):45-47, 1982.
   *
   * <p>The runtime is O(n) and it generates O(k) random numbers. Thus, it is a better choice than
   * sampleReservoir when k &lt; n-k. However, this uses O(n) extra space, whereas the reservoir
   * algorithm uses no extra space.
   *
   * <p>This method is safe to use with threads, as it uses ThreadLocalRandom as the underlying
   * source of randomness.
   *
   * @deprecated This method is deprecated, and replaced by the {@link SequencePoolSampler} class.
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  @Deprecated
  public static byte[] samplePool(byte[] source, int k, byte[] target) {
    return SequencePoolSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This implements the algorithm SELECT of S. Goodman and S. Hedetniemi, as described in: J
   * Ernvall, O Nevalainen, "An Algorithm for Unbiased Random Sampling," The Computer Journal,
   * 25(1):45-47, 1982.
   *
   * <p>The runtime is O(n) and it generates O(k) random numbers. Thus, it is a better choice than
   * sampleReservoir when k &lt; n-k. However, this uses O(n) extra space, whereas the reservoir
   * algorithm uses no extra space.
   *
   * <p>This method is safe to use with threads, as it uses ThreadLocalRandom as the underlying
   * source of randomness.
   *
   * @deprecated This method is deprecated, and replaced by the {@link SequencePoolSampler} class.
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  @Deprecated
  public static char[] samplePool(char[] source, int k, char[] target) {
    return SequencePoolSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k chars, without replacement, from a given source String. All n
   * choose k combinations are equally likely, where n is the length of the source String.
   *
   * <p>This implements the algorithm SELECT of S. Goodman and S. Hedetniemi, as described in: J
   * Ernvall, O Nevalainen, "An Algorithm for Unbiased Random Sampling," The Computer Journal,
   * 25(1):45-47, 1982.
   *
   * <p>The runtime is O(n) and it generates O(k) random numbers. Thus, it is a better choice than
   * sampleReservoir when k &lt; n-k. However, this uses O(n) extra space, whereas the reservoir
   * algorithm uses no extra space.
   *
   * <p>This method is safe to use with threads, as it uses ThreadLocalRandom as the underlying
   * source of randomness.
   *
   * @deprecated This method is deprecated, and replaced by the {@link SequencePoolSampler} class.
   * @param source The source to sample.
   * @param k The number of random samples (must be no greater than source.length()).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length()
   * @throws NegativeArraySizeException if k &lt; 0
   */
  @Deprecated
  public static char[] samplePool(String source, int k, char[] target) {
    return SequencePoolSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This implements the algorithm SELECT of S. Goodman and S. Hedetniemi, as described in: J
   * Ernvall, O Nevalainen, "An Algorithm for Unbiased Random Sampling," The Computer Journal,
   * 25(1):45-47, 1982.
   *
   * <p>The runtime is O(n) and it generates O(k) random numbers. Thus, it is a better choice than
   * sampleReservoir when k &lt; n-k. However, this uses O(n) extra space, whereas the reservoir
   * algorithm uses no extra space.
   *
   * <p>This method is safe to use with threads, as it uses ThreadLocalRandom as the underlying
   * source of randomness.
   *
   * @deprecated This method is deprecated, and replaced by the {@link SequencePoolSampler} class.
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  @Deprecated
  public static double[] samplePool(double[] source, int k, double[] target) {
    return SequencePoolSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This implements the algorithm SELECT of S. Goodman and S. Hedetniemi, as described in: J
   * Ernvall, O Nevalainen, "An Algorithm for Unbiased Random Sampling," The Computer Journal,
   * 25(1):45-47, 1982.
   *
   * <p>The runtime is O(n) and it generates O(k) random numbers. Thus, it is a better choice than
   * sampleReservoir when k &lt; n-k. However, this uses O(n) extra space, whereas the reservoir
   * algorithm uses no extra space.
   *
   * <p>This method is safe to use with threads, as it uses ThreadLocalRandom as the underlying
   * source of randomness.
   *
   * @deprecated This method is deprecated, and replaced by the {@link SequencePoolSampler} class.
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  @Deprecated
  public static float[] samplePool(float[] source, int k, float[] target) {
    return SequencePoolSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This implements the algorithm SELECT of S. Goodman and S. Hedetniemi, as described in: J
   * Ernvall, O Nevalainen, "An Algorithm for Unbiased Random Sampling," The Computer Journal,
   * 25(1):45-47, 1982.
   *
   * <p>The runtime is O(n) and it generates O(k) random numbers. Thus, it is a better choice than
   * sampleReservoir when k &lt; n-k. However, this uses O(n) extra space, whereas the reservoir
   * algorithm uses no extra space.
   *
   * <p>This method is safe to use with threads, as it uses ThreadLocalRandom as the underlying
   * source of randomness.
   *
   * @deprecated This method is deprecated, and replaced by the {@link SequencePoolSampler} class.
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @param <T> The type of array elements.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  @Deprecated
  public static <T> T[] samplePool(T[] source, int k, T[] target) {
    return SequencePoolSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This implements the insertion sampling algorithm described in:
   *
   * <p>Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>The runtime is O(k<sup>2</sup>) and it generates O(k) random numbers. Thus, it is a better
   * choice than both sampleReservoir and samplePool when k<sup>2</sup> &lt; n. Just like
   * sampleReservoir, the sampleInsertion method only requires O(1) extra space, while samplePool
   * requires O(n) extra space.
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @deprecated This method is deprecated, and replaced by the {@link SequenceInsertionSampler}
   *     class.
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  @Deprecated
  public static int[] sampleInsertion(int[] source, int k, int[] target) {
    return SequenceInsertionSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This implements the insertion sampling algorithm described in:
   *
   * <p>Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>The runtime is O(k<sup>2</sup>) and it generates O(k) random numbers. Thus, it is a better
   * choice than both sampleReservoir and samplePool when k<sup>2</sup> &lt; n. Just like
   * sampleReservoir, the sampleInsertion method only requires O(1) extra space, while samplePool
   * requires O(n) extra space.
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @deprecated This method is deprecated, and replaced by the {@link SequenceInsertionSampler}
   *     class.
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  @Deprecated
  public static long[] sampleInsertion(long[] source, int k, long[] target) {
    return SequenceInsertionSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This implements the insertion sampling algorithm described in:
   *
   * <p>Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>The runtime is O(k<sup>2</sup>) and it generates O(k) random numbers. Thus, it is a better
   * choice than both sampleReservoir and samplePool when k<sup>2</sup> &lt; n. Just like
   * sampleReservoir, the sampleInsertion method only requires O(1) extra space, while samplePool
   * requires O(n) extra space.
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @deprecated This method is deprecated, and replaced by the {@link SequenceInsertionSampler}
   *     class.
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  @Deprecated
  public static short[] sampleInsertion(short[] source, int k, short[] target) {
    return SequenceInsertionSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This implements the insertion sampling algorithm described in:
   *
   * <p>Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>The runtime is O(k<sup>2</sup>) and it generates O(k) random numbers. Thus, it is a better
   * choice than both sampleReservoir and samplePool when k<sup>2</sup> &lt; n. Just like
   * sampleReservoir, the sampleInsertion method only requires O(1) extra space, while samplePool
   * requires O(n) extra space.
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @deprecated This method is deprecated, and replaced by the {@link SequenceInsertionSampler}
   *     class.
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  @Deprecated
  public static byte[] sampleInsertion(byte[] source, int k, byte[] target) {
    return SequenceInsertionSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This implements the insertion sampling algorithm described in:
   *
   * <p>Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>The runtime is O(k<sup>2</sup>) and it generates O(k) random numbers. Thus, it is a better
   * choice than both sampleReservoir and samplePool when k<sup>2</sup> &lt; n. Just like
   * sampleReservoir, the sampleInsertion method only requires O(1) extra space, while samplePool
   * requires O(n) extra space.
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @deprecated This method is deprecated, and replaced by the {@link SequenceInsertionSampler}
   *     class.
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  @Deprecated
  public static char[] sampleInsertion(char[] source, int k, char[] target) {
    return SequenceInsertionSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k chars, without replacement, from a given source String. All n
   * choose k combinations are equally likely, where n is the length of the source String.
   *
   * <p>This implements the insertion sampling algorithm described in:
   *
   * <p>Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>The runtime is O(k<sup>2</sup>) and it generates O(k) random numbers. Thus, it is a better
   * choice than both sampleReservoir and samplePool when k<sup>2</sup> &lt; n. Just like
   * sampleReservoir, the sampleInsertion method only requires O(1) extra space, while samplePool
   * requires O(n) extra space.
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @deprecated This method is deprecated, and replaced by the {@link SequenceInsertionSampler}
   *     class.
   * @param source The source to sample.
   * @param k The number of random samples (must be no greater than source.length()).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length()
   * @throws NegativeArraySizeException if k &lt; 0
   */
  @Deprecated
  public static char[] sampleInsertion(String source, int k, char[] target) {
    return SequenceInsertionSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This implements the insertion sampling algorithm described in:
   *
   * <p>Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>The runtime is O(k<sup>2</sup>) and it generates O(k) random numbers. Thus, it is a better
   * choice than both sampleReservoir and samplePool when k<sup>2</sup> &lt; n. Just like
   * sampleReservoir, the sampleInsertion method only requires O(1) extra space, while samplePool
   * requires O(n) extra space.
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @deprecated This method is deprecated, and replaced by the {@link SequenceInsertionSampler}
   *     class.
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  @Deprecated
  public static double[] sampleInsertion(double[] source, int k, double[] target) {
    return SequenceInsertionSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This implements the insertion sampling algorithm described in:
   *
   * <p>Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>The runtime is O(k<sup>2</sup>) and it generates O(k) random numbers. Thus, it is a better
   * choice than both sampleReservoir and samplePool when k<sup>2</sup> &lt; n. Just like
   * sampleReservoir, the sampleInsertion method only requires O(1) extra space, while samplePool
   * requires O(n) extra space.
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @deprecated This method is deprecated, and replaced by the {@link SequenceInsertionSampler}
   *     class.
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  @Deprecated
  public static float[] sampleInsertion(float[] source, int k, float[] target) {
    return SequenceInsertionSampler.sample(source, k, target, ThreadLocalRandom.current());
  }

  /**
   * Generates a random sample of k elements, without replacement, from a given source array. All n
   * choose k combinations are equally likely, where n is the length of the source array.
   *
   * <p>This implements the insertion sampling algorithm described in:
   *
   * <p>Vincent A. Cicirello. 2022. <a
   * href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle Mutation: Evolving
   * Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June
   * 2022). doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a>
   *
   * <p>The runtime is O(k<sup>2</sup>) and it generates O(k) random numbers. Thus, it is a better
   * choice than both sampleReservoir and samplePool when k<sup>2</sup> &lt; n. Just like
   * sampleReservoir, the sampleInsertion method only requires O(1) extra space, while samplePool
   * requires O(n) extra space.
   *
   * <p>This method uses ThreadLocalRandom as the pseudorandom number generator, and is thus safe,
   * and efficient (i.e., non-blocking), for use with threads.
   *
   * @deprecated This method is deprecated, and replaced by the {@link SequenceInsertionSampler}
   *     class.
   * @param source The source array to sample.
   * @param k The number of random samples (must be no greater than source.length).
   * @param target An array to hold the result. If target is null or target.length is less than k,
   *     then this method will construct a new array for the result.
   * @param <T> The type of array elements.
   * @return An array containing the random sample.
   * @throws IllegalArgumentException if k &gt; source.length
   * @throws NegativeArraySizeException if k &lt; 0
   */
  @Deprecated
  public static <T> T[] sampleInsertion(T[] source, int k, T[] target) {
    return SequenceInsertionSampler.sample(source, k, target, ThreadLocalRandom.current());
  }
}
