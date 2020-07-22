# JavaPermutationTools (JPT): A Java API for computation on permutations and sequences 

Copyright (C) 2018-2020 Vincent A. Cicirello.

https://www.cicirello.org/

[![DOI](http://joss.theoj.org/papers/10.21105/joss.00950/status.svg)](https://doi.org/10.21105/joss.00950)
[![DOI](https://zenodo.org/badge/139182095.svg)](https://zenodo.org/badge/latestdoi/139182095)
![build](https://github.com/cicirello/JavaPermutationTools/workflows/build/badge.svg)
![GitHub](https://img.shields.io/github/license/cicirello/JavaPermutationTools)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/cicirello/JavaPermutationTools)

## How to Cite

If you use this library in your research, please cite the following paper:

> Cicirello, Vincent A (2018). JavaPermutationTools: A Java Library of Permutation Distance Metrics. *Journal of Open Source Software*, 3(31), 950.  https://doi.org/10.21105/joss.00950 .

## Overview

The JavaPermutationTools (JPT) API provides Java classes that enable representing and generating 
permutations and sequences, as well as performing computation on permutations and sequences. 
It includes implementations of a variety of permutation distance metrics as well as distance 
metrics on sequences (i.e., Strings, arrays, and other ordered data types). 

JPT is organized into the following packages:
* __org.cicirello.permutations__: Permutation class and a class for iterating over permutations.
* __org.cicirello.permutations.distance__: Collection of permutation distance metric implementations.
* __org.cicirello.sequences__: Classes that perform a variety of operations on sequences (such as arrays, etc).
* __org.cicirello.sequences.distance__: Collection of distance metrics on Strings and other sequences.
* __org.cicirello.math.la__ : Linear algebra related classes.
* __org.cicirello.math.rand__ : Classes related to efficient, or specialized, random number generation. 
* __org.cicirello.math.stats__: Statistics related classes.

Javadoc documentation is in the /docs folder as well as at https://jpt.cicirello.org/

Source code is found in the /src folder.  JUnit test classes are found in the /tests folder, which
mirrors the package structure of /src.

Compiled jar files of the library are in the /lib folder.

The /examples folder includes source code to illustrate how to use the library.  The /replication
folder includes source code that recreates results found in publications associated with the library.

## Building the Library (with ant)

The /build directory contains an ant build file.  The build file also executes the JUnit tests, and the build directory contains
the relevant jar files for the JUnit libraries.  If you prefer, you can replace these with the latest versions available
from https://junit.org/junit4/ (just be sure to edit the property fields in the build.xml to point to the locations of the JUnit jar files).

To execute the build process do one of the following.  If your working directory is the build directory, then simply execute
`ant` from the command line.  If your working directory is the parent of build, then execute: `ant -f build/build.xml`

The default of the provided ant build file, compiles all source files and all JUnit tests, executes all test cases,
and generates the jar file of the library. The build process will terminate on any test case failures.  The default 
does not compile the example programs or the experiment replication programs.  To include those in the build as well
then execute `ant all` (if your working directory is the build directory) or `ant -f build/build.xml all` (if your 
working directory is the parent of build).

If you use the ant build file, the build will generate the following directories: bin (for the compiled Java classes),
testbin (for the compiled JUnit tests), lib (for the jar file of the library), and exbin (for the compiled example
programs and experiment replication programs).

## Running the Example Programs

The examples directory contains example usage of several of the classes of the API.
The replication directory additionally contains more complex examples that replicate the
experiments from published papers that have used the library.  Those directories contain
readmes that provide more detail on the examples.

Assuming the build was successful, the compiled examples and replication programs will be
in the exbin directory.  If your working directory is the root
of the repository, then you can run these programs from the command line with the following:

```
java -cp "lib/jpt2.jar;exbin" org.cicirello.examples.jpt.AverageDistance
java -cp "lib/jpt2.jar;exbin" org.cicirello.examples.jpt.TableOfDistances
java -cp "lib/jpt2.jar;exbin" org.cicirello.examples.jpt.PermutationExamples
java -cp "lib/jpt2.jar;exbin" org.cicirello.examples.jpt.SimpleDistanceExamples
java -cp "lib/jpt2.jar;exbin" org.cicirello.examples.jpt.SequenceDistanceExamples
java -cp "lib/jpt2.jar;exbin" org.cicirello.examples.jpt.PermutationHashCodes
java -cp "lib/jpt2.jar;exbin" org.cicirello.replication.flairs2013.Flairs2013
java -cp "lib/jpt2.jar;exbin" org.cicirello.replication.ieeetevc2016.FDC
java -cp "lib/jpt2.jar;exbin" org.cicirello.replication.bict2019.BICT2019
```

In each of the above cases, the source code includes comments explaining the example
usage of the library.

**Memory Intensive Example**: Note that depending on your processor speed, 
the experiment replication programs may be slow (certainly slower than
the examples from the examples folder).  Additionally, the `org.cicirello.replication.ieeetevc2016.FDC` is memory intensive, 
and depending upon your system may require increasing the heap allocation to the Java virtual machine.
If it throws an `OutOfMemoryError`, then execute as follows (note the additional command line argument):

```
java -Xms1g -cp "lib/jpt2.jar;exbin" org.cicirello.replication.ieeetevc2016.FDC
```


## Contribute

Report bugs, suggestions, feature requests, etc via the [issues tracker](https://github.com/cicirello/JavaPermutationTools/issues).  If you would like to directly contribute new code, you may also fork the repository, and create pull requests.
