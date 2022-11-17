/*
 * Copyright 2018-2022 Vincent A. Cicirello, <https://www.cicirello.org/>.
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
 *
 */
package org.cicirello.permutations.distance;

import static org.junit.jupiter.api.Assertions.*;

import org.cicirello.permutations.Permutation;
import org.junit.jupiter.api.*;

/** JUnit tests for ReinsertionDistance. */
public class ReinsertionDistanceTests extends SharedTestForPermutationDistance {

  @Test
  public void testNormalized() {
    ReinsertionDistance d = new ReinsertionDistance();
    for (int n = 0; n <= 7; n++) {
      assertEquals(n <= 1 ? 0.0 : 1.0, validateNormalizedDistance(d, n), "Failed on length: " + n);
    }
  }

  @Test
  public void testMax() {
    ReinsertionDistance d = new ReinsertionDistance();
    for (int n = 0; n <= 7; n++) {
      int expected = bruteForceComputeMax(d, n);
      assertEquals(expected, d.max(n), "Failed on length: " + n);
      assertEquals(1.0 * expected, d.maxf(n), "Failed on length: " + n);
    }
  }

  @Test
  public void testIdenticalPermutations() {
    ReinsertionDistance d = new ReinsertionDistance();
    identicalPermutations(d);
  }

  @Test
  public void testSameAsEditDistanceDefaults() {
    ReinsertionDistance d = new ReinsertionDistance();
    Permutation p = new Permutation(5);
    EditDistance edit = new EditDistance();
    for (Permutation q : p) {
      // NOTE: If this assertion fails, problem is either in ReinsertionDistance or EditDistance
      // Should correspond if they are both correct.
      assertEquals(edit.distancef(p, q), d.distancef(p, q));
      assertEquals(edit.distancef(q, p), d.distancef(q, p));
    }
  }

  @Test
  public void testReinsertionDistance() {
    ReinsertionDistance d = new ReinsertionDistance();
    for (int n = 2; n <= 10; n++) {
      // maximal distance is permutation reversed
      Permutation p = new Permutation(n);
      Permutation copy = new Permutation(p);
      copy.reverse();
      int expected = n - 1;
      assertEquals(expected, d.distance(p, copy));
      assertEquals(expected, d.distance(copy, p));
    }
    int[] a1 = {0, 1, 2, 3, 4, 5};
    int[] a2 = {0, 4, 2, 3, 1, 5};
    int[] a3 = {1, 5, 4, 2, 3, 0};
    int[] a4 = {5, 3, 1, 2, 0, 4};
    Permutation p1 = new Permutation(a1);
    Permutation p2 = new Permutation(a2);
    Permutation p3 = new Permutation(a3);
    Permutation p4 = new Permutation(a4);
    assertEquals(2, d.distance(p1, p2));
    assertEquals(3, d.distance(p1, p3));
    assertEquals(3, d.distance(p1, p4));
  }

  @Test
  public void testExceptions() {
    ReinsertionDistance d = new ReinsertionDistance();
    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> d.distance(new Permutation(1), new Permutation(2)));
  }
}
