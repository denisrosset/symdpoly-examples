# SymDPoly example gallery

To run the examples here, follow the steps below.

## 1. Install the SBT build tool

- Direct download: https://www.scala-sbt.org/download.html

- Instructions for Linux: https://www.scala-sbt.org/1.x/docs/Installing-sbt-on-Linux.html

- Instructions for macOS: https://www.scala-sbt.org/1.x/docs/Installing-sbt-on-Mac.html

- Instructions for Windows: https://www.scala-sbt.org/1.x/docs/Installing-sbt-on-Windows.html

## 2. Try a simple example

Execute the command `sbt run` in the `chsh/` subfolder.

You should get an output similar to (your first run will be more verbose as SBT downloads the required packages):

```
[info] Loading settings from idea.sbt ...
[info] Loading global plugins from /home/user/.sbt/1.0/plugins
[info] Loading settings from plugins.sbt ...
[info] Loading project definition from /home/user/w/symdpoly-examples/chsh/project
[info] Loading settings from build.sbt ...
[info] Set current project to chsh (in build file:/home/user/w/symdpoly-examples/chsh/)
[info] Packaging /home/user/w/symdpoly-examples/chsh/target/scala-2.12/chsh_2.12-0.1.0-SNAPSHOT.jar ...
[info] Done packaging.
[info] Running CHSH 
OptimumFound(None,2.8284271227461906,None,Vec(1.0, -0.7071067806865476))
[success] Total time: 3 s, completed 9-Jul-2018 4:39:47 AM
```

Then have a look at the [chsh/output/](https://github.com/denisrosset/symdpoly-examples/tree/master/chsh/output) subfolder, where you will find the following text files:

- [chsh_symmetry_group.txt](https://github.com/denisrosset/symdpoly-examples/blob/master/chsh/output/chsh_symmetry_group.txt) The computed symmetry group of the problem.
- [chsh_moment_matrix.txt](https://github.com/denisrosset/symdpoly-examples/blob/master/chsh/output/chsh_moment_matrix.txt) The symmetrized moment matrix build by the library.
- [chsh_canonical_monomials.txt](https://github.com/denisrosset/symdpoly-examples/blob/master/chsh/output/chsh_canonical_monomials.txt) The list of canonical monomials, and their orbit under the symmetry group.
- [chsh_moment_index_matrix.txt](https://github.com/denisrosset/symdpoly-examples/blob/master/chsh/output/chsh_moment_index_matrix.txt) A matrix of indices of monomials (corresponding to the canonical monomials above).
- [chsh_phase_matrix.txt](https://github.com/denisrosset/symdpoly-examples/blob/master/chsh/output/chsh_phase_matrix.txt) A matrix of phases for those monomials (for this real example, phases are either +1 or -1).

and the following data files:

- [chsh_scs.mat](https://github.com/denisrosset/symdpoly-examples/blob/master/chsh/output/chsh_scs.mat) [SCS](https://github.com/cvxgrp/scs) input file in Matlab format, use [SCS-matlab](https://github.com/bodono/scs-matlab) to run it.
- [chsh_sdpa.dat-s](https://github.com/denisrosset/symdpoly-examples/blob/master/chsh/output/chsh_sdpa.dat-s) Sparse [SDPA](http://sdpa.sourceforge.net/) input file
- [chsh_sdpt3.mat](https://github.com/denisrosset/symdpoly-examples/blob/master/chsh/output/chsh_sdpt3.mat) SDPT3 input file, can be used either with [SDPT3](http://www.math.nus.edu.sg/~mattohkc/sdpt3.html), [SDPNAL](http://www.math.nus.edu.sg/~mattohkc/SDPNAL.html) (untested) or [SDPNAL+](http://www.math.nus.edu.sg/~mattohkc/SDPNALplus.html)
- [chsh_sedumi.mat](https://github.com/denisrosset/symdpoly-examples/blob/master/chsh/output/chsh_sedumi.mat) [SeDuMi](http://sedumi.ie.lehigh.edu/) input file

and, if you have a Mosek license follow the instructions in [build.sbt]https://github.com/denisrosset/symdpoly-examples/blob/master/chsh/build.sbt:

- [chsh.cbf](https://github.com/denisrosset/symdpoly-examples/blob/master/chsh/output/chsh.cbf)
- [chsh.jtask](https://github.com/denisrosset/symdpoly-examples/blob/master/chsh/output/chsh.jtask)
- [chsh.task](https://github.com/denisrosset/symdpoly-examples/blob/master/chsh/output/chsh.task)
