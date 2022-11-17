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
package org.cicirello.sequences.distance;

import java.util.Arrays;
import java.util.List;

/**
 * Internal class for use by relabeling phase for computing Kendall Tau Sequence Distance.
 *
 * @author <a href=https://www.cicirello.org/ target=_top>Vincent A. Cicirello</a>, <a
 *     href=https://www.cicirello.org/ target=_top>https://www.cicirello.org/</a>
 */
final class RelabelBySorting extends AbstractRelabelBySorting implements KendallTauRelabeler {

  @Override
  public int relabel(int[] s1, int[] s2, int[][] relabeling) {
    int[] c1 = s1.clone();
    Arrays.sort(c1);
    int[] labels = new int[c1.length];
    int current = labels[0] = 0;
    for (int i = 1; i < labels.length; i++) {
      if (c1[i] != c1[i - 1]) current++;
      labels[i] = current;
    }

    for (int i = 0; i < relabeling.length; i++) {
      int j = Arrays.binarySearch(c1, s1[i]);
      relabeling[i][0] = labels[j];
      j = Arrays.binarySearch(c1, s2[i]);
      validateElementIndex(j);
      relabeling[i][1] = labels[j];
    }
    return current + 1;
  }

  @Override
  public int relabel(long[] s1, long[] s2, int[][] relabeling) {
    long[] c1 = s1.clone();
    Arrays.sort(c1);
    int[] labels = new int[c1.length];
    int current = labels[0] = 0;
    for (int i = 1; i < labels.length; i++) {
      if (c1[i] != c1[i - 1]) current++;
      labels[i] = current;
    }

    for (int i = 0; i < relabeling.length; i++) {
      int j = Arrays.binarySearch(c1, s1[i]);
      relabeling[i][0] = labels[j];
      j = Arrays.binarySearch(c1, s2[i]);
      validateElementIndex(j);
      relabeling[i][1] = labels[j];
    }
    return current + 1;
  }

  @Override
  public int relabel(short[] s1, short[] s2, int[][] relabeling) {
    short[] c1 = s1.clone();
    Arrays.sort(c1);
    int[] labels = new int[c1.length];
    int current = labels[0] = 0;
    for (int i = 1; i < labels.length; i++) {
      if (c1[i] != c1[i - 1]) current++;
      labels[i] = current;
    }

    for (int i = 0; i < relabeling.length; i++) {
      int j = Arrays.binarySearch(c1, s1[i]);
      relabeling[i][0] = labels[j];
      j = Arrays.binarySearch(c1, s2[i]);
      validateElementIndex(j);
      relabeling[i][1] = labels[j];
    }
    return current + 1;
  }

  @Override
  public int relabel(byte[] s1, byte[] s2, int[][] relabeling) {
    byte[] c1 = s1.clone();
    Arrays.sort(c1);
    int[] labels = new int[c1.length];
    int current = labels[0] = 0;
    for (int i = 1; i < labels.length; i++) {
      if (c1[i] != c1[i - 1]) current++;
      labels[i] = current;
    }

    for (int i = 0; i < relabeling.length; i++) {
      int j = Arrays.binarySearch(c1, s1[i]);
      relabeling[i][0] = labels[j];
      j = Arrays.binarySearch(c1, s2[i]);
      validateElementIndex(j);
      relabeling[i][1] = labels[j];
    }
    return current + 1;
  }

  @Override
  public int relabel(char[] s1, char[] s2, int[][] relabeling) {
    char[] c1 = s1.clone();
    Arrays.sort(c1);
    int[] labels = new int[c1.length];
    int current = labels[0] = 0;
    for (int i = 1; i < labels.length; i++) {
      if (c1[i] != c1[i - 1]) current++;
      labels[i] = current;
    }

    for (int i = 0; i < relabeling.length; i++) {
      int j = Arrays.binarySearch(c1, s1[i]);
      relabeling[i][0] = labels[j];
      j = Arrays.binarySearch(c1, s2[i]);
      validateElementIndex(j);
      relabeling[i][1] = labels[j];
    }
    return current + 1;
  }

  @Override
  public int relabel(String s1, String s2, int[][] relabeling) {
    char[] c1 = s1.toCharArray();
    Arrays.sort(c1);
    int[] labels = new int[c1.length];
    int current = labels[0] = 0;
    for (int i = 1; i < labels.length; i++) {
      if (c1[i] != c1[i - 1]) current++;
      labels[i] = current;
    }

    for (int i = 0; i < relabeling.length; i++) {
      int j = Arrays.binarySearch(c1, s1.charAt(i));
      relabeling[i][0] = labels[j];
      j = Arrays.binarySearch(c1, s2.charAt(i));
      validateElementIndex(j);
      relabeling[i][1] = labels[j];
    }
    return current + 1;
  }

  @Override
  public int relabel(float[] s1, float[] s2, int[][] relabeling) {
    float[] c1 = s1.clone();
    Arrays.sort(c1);
    int[] labels = new int[c1.length];
    int current = labels[0] = 0;
    for (int i = 1; i < labels.length; i++) {
      if (c1[i] != c1[i - 1]) current++;
      labels[i] = current;
    }

    for (int i = 0; i < relabeling.length; i++) {
      int j = Arrays.binarySearch(c1, s1[i]);
      relabeling[i][0] = labels[j];
      j = Arrays.binarySearch(c1, s2[i]);
      validateElementIndex(j);
      relabeling[i][1] = labels[j];
    }
    return current + 1;
  }

  @Override
  public int relabel(double[] s1, double[] s2, int[][] relabeling) {
    double[] c1 = s1.clone();
    Arrays.sort(c1);
    int[] labels = new int[c1.length];
    int current = labels[0] = 0;
    for (int i = 1; i < labels.length; i++) {
      if (c1[i] != c1[i - 1]) current++;
      labels[i] = current;
    }

    for (int i = 0; i < relabeling.length; i++) {
      int j = Arrays.binarySearch(c1, s1[i]);
      relabeling[i][0] = labels[j];
      j = Arrays.binarySearch(c1, s2[i]);
      validateElementIndex(j);
      relabeling[i][1] = labels[j];
    }
    return current + 1;
  }

  @Override
  @SuppressWarnings("unchecked")
  public int relabel(Object[] s1, Object[] s2, int[][] relabeling) {
    return internalRelabel((Comparable[]) s1, (Comparable[]) s2, relabeling);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> int relabel(List<T> s1, List<T> s2, int[][] relabeling) {
    return internalRelabel((List<Comparable>) s1, (List<Comparable>) s2, relabeling);
  }
}
