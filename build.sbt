import Dependencies._

ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(name := "web_crawler", libraryDependencies ++= webCrawlerDependencies)
  .settings(runMain in Compile := Defaults.runMainTask(fullClasspath in Compile, runner in (Compile, run)).evaluated)
  .enablePlugins(DockerPlugin)
  .enablePlugins(JavaAppPackaging)
