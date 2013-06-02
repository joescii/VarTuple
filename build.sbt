name := "VarTuple"

organization := "com.github.barnesjd"

version := "0.1"

scalaVersion := "2.10.1"

scalacOptions := Seq("-deprecation", "-unchecked", "-feature", "-language:postfixOps", "-language:implicitConversions")

libraryDependencies ++= Seq(
  "com.chuusai" %% "shapeless" % "1.2.4",
  "org.scalatest" %% "scalatest" % "1.9.1" % "test"
)

resolvers ++= Seq(
  "Sonatype OSS Releases" at "http://oss.sonatype.org/content/repositories/releases/",
  "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
)

