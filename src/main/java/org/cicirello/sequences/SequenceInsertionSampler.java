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

import org.cicirello.math.rand.RandomSampler;
import org.cicirello.util.ArrayMinimumLengthEnforcer;
import java.util.random.RandomGenerator;

/**
 * <p>SequenceInsertionSampler is a class of utility methods for 
 * efficiently generating random samples of array elements, without replacement.</p>
 *
 * <p>The methods of this class implement the insertion sampling algorithm described in:</p>
 * <p>Vincent A. Cicirello. 2022. <a href="https://www.cicirello.org/publications/applsci-12-05506.pdf">Cycle 
 * Mutation: Evolving Permutations via Cycle Induction</a>, <i>Applied Sciences</i>, 12(11), Article 5506 (June 2022). 
 * doi:<a href="https://doi.org/10.3390/app12115506">10.3390/app12115506</a></p>
 *
 * <p>The runtime of the sample methods is O(k<sup>2</sup>)
 * and generates O(k) random numbers. Thus, it is a better 
 * choice than both SequenceReservoirSampler and SequencePoolSampler when k<sup>2</sup> &lt; n.
 * Just like SequenceReservoirSampler, SequenceInsertionSampler only requires O(1) extra space,
 * while SequencePoolSampler requires O(n) extra space.</p>
 *
 * @author <a href=https://www.cicirello.org/ target=_top>Vincent A. Cicirello</a>, 
 * <a href=https://www.cicirello.org/ target=_top>https://www.cicirello.org/</a> 
 */
public final class SequenceInsertionSampler extends AbstractSequenceSampler {
	
	/**
	 * Class of static utility methods so prevent instantiation
	 * with a private constructor.
	 */
	private SequenceInsertionSampler() {};
	
	/**
	 * <p>Generates a random sample of k elements, without replacement, from a
	 * given source array.  All n choose k combinations are equally
	 * likely, where n is the length of the source array.</p>  
	 *
	 * @param source The source array to sample.
	 * @param k The number of random samples (must be no greater than source.length).
	 * @param target An array to hold the result.  If target is null or target.length is less than k, 
	 * then this method will construct a new array for the result.
	 * @param r The source of randomness.
	 *
	 * @return An array containing the random sample.
	 * @throws IllegalArgumentException if k &gt; source.length
	 * @throws NegativeArraySizeException if k &lt; 0
	 */
	public static int[] sample(int[] source, int k, int[] target, RandomGenerator r) {
		validateK(k, source.length);
		target = RandomSampler.sampleInsertion(source.length, k, target, r);
		for (int i = 0; i < k; i++) {
			target[i] = source[target[i]];
		}
		return target;
	}
	
	/**
	 * <p>Generates a random sample of k elements, without replacement, from a
	 * given source array.  All n choose k combinations are equally
	 * likely, where n is the length of the source array.</p>  
	 *
	 * @param source The source array to sample.
	 * @param k The number of random samples (must be no greater than source.length).
	 * @param target An array to hold the result.  If target is null or target.length is less than k, 
	 * then this method will construct a new array for the result.
	 * @param r The source of randomness.
	 *
	 * @return An array containing the random sample.
	 * @throws IllegalArgumentException if k &gt; source.length
	 * @throws NegativeArraySizeException if k &lt; 0
	 */
	public static long[] sample(long[] source, int k, long[] target, RandomGenerator r) {
		validateK(k, source.length);
		target = ArrayMinimumLengthEnforcer.enforce(target, k);
		int[] indexes = RandomSampler.sampleInsertion(source.length, k, null, r);
		for (int i = 0; i < k; i++) {
			target[i] = source[indexes[i]];
		}
		return target;
	}
	
	/**
	 * <p>Generates a random sample of k elements, without replacement, from a
	 * given source array.  All n choose k combinations are equally
	 * likely, where n is the length of the source array.</p>  
	 *
	 * @param source The source array to sample.
	 * @param k The number of random samples (must be no greater than source.length).
	 * @param target An array to hold the result.  If target is null or target.length is less than k, 
	 * then this method will construct a new array for the result.
	 * @param r The source of randomness.
	 *
	 * @return An array containing the random sample.
	 * @throws IllegalArgumentException if k &gt; source.length
	 * @throws NegativeArraySizeException if k &lt; 0
	 */
	public static short[] sample(short[] source, int k, short[] target, RandomGenerator r) {
		validateK(k, source.length);
		target = ArrayMinimumLengthEnforcer.enforce(target, k);
		int[] indexes = RandomSampler.sampleInsertion(source.length, k, null, r);
		for (int i = 0; i < k; i++) {
			target[i] = source[indexes[i]];
		}
		return target;
	}
	
	/**
	 * <p>Generates a random sample of k elements, without replacement, from a
	 * given source array.  All n choose k combinations are equally
	 * likely, where n is the length of the source array.</p>  
	 *
	 * @param source The source array to sample.
	 * @param k The number of random samples (must be no greater than source.length).
	 * @param target An array to hold the result.  If target is null or target.length is less than k, 
	 * then this method will construct a new array for the result.
	 * @param r The source of randomness.
	 *
	 * @return An array containing the random sample.
	 * @throws IllegalArgumentException if k &gt; source.length
	 * @throws NegativeArraySizeException if k &lt; 0
	 */
	public static byte[] sample(byte[] source, int k, byte[] target, RandomGenerator r) {
		validateK(k, source.length);
		target = ArrayMinimumLengthEnforcer.enforce(target, k);
		int[] indexes = RandomSampler.sampleInsertion(source.length, k, null, r);
		for (int i = 0; i < k; i++) {
			target[i] = source[indexes[i]];
		}
		return target;
	}
	
	/**
	 * <p>Generates a random sample of k elements, without replacement, from a
	 * given source array.  All n choose k combinations are equally
	 * likely, where n is the length of the source array.</p>  
	 *
	 * @param source The source array to sample.
	 * @param k The number of random samples (must be no greater than source.length).
	 * @param target An array to hold the result.  If target is null or target.length is less than k, 
	 * then this method will construct a new array for the result.
	 * @param r The source of randomness.
	 *
	 * @return An array containing the random sample.
	 * @throws IllegalArgumentException if k &gt; source.length
	 * @throws NegativeArraySizeException if k &lt; 0
	 */
	public static char[] sample(char[] source, int k, char[] target, RandomGenerator r) {
		validateK(k, source.length);
		target = ArrayMinimumLengthEnforcer.enforce(target, k);
		int[] indexes = RandomSampler.sampleInsertion(source.length, k, null, r);
		for (int i = 0; i < k; i++) {
			target[i] = source[indexes[i]];
		}
		return target;
	}
	
	/**
	 * <p>Generates a random sample of k chars, without replacement, from a
	 * given source String.  All n choose k combinations are equally
	 * likely, where n is the length of the source String.</p>  
	 *
	 * @param source The source to sample.
	 * @param k The number of random samples (must be no greater than source.length()).
	 * @param target An array to hold the result.  If target is null or target.length is less than k, 
	 * then this method will construct a new array for the result.
	 * @param r The source of randomness.
	 *
	 * @return An array containing the random sample.
	 * @throws IllegalArgumentException if k &gt; source.length()
	 * @throws NegativeArraySizeException if k &lt; 0
	 */
	public static char[] sample(String source, int k, char[] target, RandomGenerator r) {
		return sample(source.toCharArray(), k, target, r);
	}
	
	/**
	 * <p>Generates a random sample of k elements, without replacement, from a
	 * given source array.  All n choose k combinations are equally
	 * likely, where n is the length of the source array.</p>  
	 *
	 * @param source The source array to sample.
	 * @param k The number of random samples (must be no greater than source.length).
	 * @param target An array to hold the result.  If target is null or target.length is less than k, 
	 * then this method will construct a new array for the result.
	 * @param r The source of randomness.
	 *
	 * @return An array containing the random sample.
	 * @throws IllegalArgumentException if k &gt; source.length
	 * @throws NegativeArraySizeException if k &lt; 0
	 */
	public static double[] sample(double[] source, int k, double[] target, RandomGenerator r) {
		validateK(k, source.length);
		target = ArrayMinimumLengthEnforcer.enforce(target, k);
		int[] indexes = RandomSampler.sampleInsertion(source.length, k, null, r);
		for (int i = 0; i < k; i++) {
			target[i] = source[indexes[i]];
		}
		return target;
	}
	
	/**
	 * <p>Generates a random sample of k elements, without replacement, from a
	 * given source array.  All n choose k combinations are equally
	 * likely, where n is the length of the source array.</p>  
	 *
	 * @param source The source array to sample.
	 * @param k The number of random samples (must be no greater than source.length).
	 * @param target An array to hold the result.  If target is null or target.length is less than k, 
	 * then this method will construct a new array for the result.
	 * @param r The source of randomness.
	 *
	 * @return An array containing the random sample.
	 * @throws IllegalArgumentException if k &gt; source.length
	 * @throws NegativeArraySizeException if k &lt; 0
	 */
	public static float[] sample(float[] source, int k, float[] target, RandomGenerator r) {
		validateK(k, source.length);
		target = ArrayMinimumLengthEnforcer.enforce(target, k);
		int[] indexes = RandomSampler.sampleInsertion(source.length, k, null, r);
		for (int i = 0; i < k; i++) {
			target[i] = source[indexes[i]];
		}
		return target;
	}
	
	/**
	 * <p>Generates a random sample of k elements, without replacement, from a
	 * given source array.  All n choose k combinations are equally
	 * likely, where n is the length of the source array.</p>  
	 *
	 * @param source The source array to sample.
	 * @param k The number of random samples (must be no greater than source.length).
	 * @param target An array to hold the result.  If target is null or target.length is less than k, 
	 * then this method will construct a new array for the result.
	 * @param r The source of randomness.
	 *
	 * @param <T> The type of array elements.
	 * @return An array containing the random sample.
	 * @throws IllegalArgumentException if k &gt; source.length
	 * @throws NegativeArraySizeException if k &lt; 0
	 */
	public static <T> T[] sample(T[] source, int k, T[] target, RandomGenerator r) {
		validateK(k, source.length);
		target = allocateIfNecessary(source, k, target);
		int[] indexes = RandomSampler.sampleInsertion(source.length, k, null, r);
		for (int i = 0; i < k; i++) {
			target[i] = source[indexes[i]];
		}
		return target;
	}
}
