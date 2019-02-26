name := "scoverage-multi-module-jenkins"

enablePlugins(AkkaDisciplinePlugin)

lazy val root = project.
	aggregate(one, two)

lazy val one = project.
		settings(commonSettings: _*)

lazy val two = project.
		settings(commonSettings: _*).
		dependsOn(one)

lazy val commonSettings = Seq(
    scalaVersion := "2.12.8",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.6-SNAP6" % "test")

