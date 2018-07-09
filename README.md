SymDPoly example gallery
========================

To run the examples here, follow the steps below.

1. Install the SBT build tool
-----------------------------

Direct download: https://www.scala-sbt.org/download.html
Instructions for Linux: https://www.scala-sbt.org/1.x/docs/Installing-sbt-on-Linux.html
Instructions for macOS: https://www.scala-sbt.org/1.x/docs/Installing-sbt-on-Mac.html
Instructions for Windows: https://www.scala-sbt.org/1.x/docs/Installing-sbt-on-Windows.html

2. Try a simple example
-----------------------

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
