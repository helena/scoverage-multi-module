
import sbt._, Keys._
import sbt.plugins.JvmPlugin
import scoverage.ScoverageKeys._

object AkkaDisciplinePlugin extends AutoPlugin {

  override def trigger: PluginTrigger = allRequirements
  override def requires: Plugins = JvmPlugin

  override lazy val projectSettings = disciplineSettings

  lazy val scalaFixSettings = Seq(
    Compile / scalacOptions += "-Yrangepos")

  lazy val scoverageSettings = Seq(
    coverageMinimum := 90,
    coverageFailOnMinimum := true,
    coverageOutputHTML := true,
    coverageHighlighting := {
      import sbt.librarymanagement.{ SemanticSelector, VersionNumber }
      !VersionNumber(scalaVersion.value).matchesSemVer(SemanticSelector("<=2.11.1"))
    })

  lazy val disciplineSettings =
    scalaFixSettings ++
      scoverageSettings ++ Seq(
      Compile / scalacOptions ++= disciplineScalacOptions)

  val disciplineScalacOptions = Seq(
    "-Xfatal-warnings",
    "-Ywarn-value-discard",
    "-Yno-adapted-args",
    "-Ywarn-numeric-widen",
    "-Xfuture",
    "-Ywarn-dead-code",
    "-Ywarn-inaccessible",
    "-Ywarn-infer-any",
    "-Ywarn-nullary-override",
    "-Ywarn-nullary-unit",
    "-Ywarn-unused:_",
    "-Ypartial-unification",
    "-Ywarn-extra-implicit",
    "-Ywarn-numeric-widen")

}
