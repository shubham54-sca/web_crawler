ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "web_crawler"
  )
mainClass in Compile := Some("com.crawler.api.ServerApp")

val akkaVersion = "2.6.19"
val akkaHttpVersion = "10.2.9"
libraryDependencies += "com.typesafe.akka" %% "akka-http" % akkaHttpVersion
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % akkaVersion
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % akkaVersion
libraryDependencies += "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion
libraryDependencies += "org.jsoup" % "jsoup" % "1.15.1"
libraryDependencies += "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12"
libraryDependencies +="com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion
libraryDependencies +="com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test


enablePlugins(DockerPlugin)
enablePlugins(JavaAppPackaging)

