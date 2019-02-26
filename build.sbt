
name := "scoverage-multi-module-jenkins"

lazy val root = project
	.in(file("."))
	.settings(buildSettings: _*)
	.aggregate(one, two)

lazy val one = project
	.in(file("one"))
	.settings(commonSettings: _*)

lazy val two = project
	.in(file("two"))
	.settings(commonSettings: _*)
	.dependsOn(one)

lazy val buildSettings = Seq(
	scalaVersion := "2.12.8", // 2.13.0-M5
  version in ThisBuild := "0.1.0-SNAPSHOT",
  organization := "org.helenaedelson")

lazy val commonSettings = buildSettings ++ Seq(
	libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0-SNAP9" % "test")
