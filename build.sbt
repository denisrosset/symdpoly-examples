val symdpolyVersion = "0.1"
val slf4jVersion = "1.7.25"
scalaVersion := "2.12.6"

resolvers ++= Seq(
  "bintray/denisrosset/maven" at "https://dl.bintray.com/denisrosset/maven",
  Resolver.sonatypeRepo("snapshots"),
  Resolver.sonatypeRepo("releases")
)

libraryDependencies ++= Seq(
  "net.alasc" %% "symdpoly-core" % symdpolyVersion,
  // UNCOMMENT BELOW if using Mosek
  // in that case, create a bin/ subfolder here with the Mosek library files
  // from mosek/$version/tools/platform/$platformType/bin
  //
  //  "net.alasc" %% "symdpoly-mosek" % symdpolyVersion,   UNCOMMENT if using Mosek
  "org.slf4j" % "slf4j-nop" % slf4jVersion
)
