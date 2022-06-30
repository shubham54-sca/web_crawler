import sbt._
object Dependencies {

  val akkaVersion      = "2.6.19"
  val akkaHttpVersion  = "10.2.9"
  val jsoupVersion     = "1.15.1"
  val scalaTestVersion = "3.2.12"

  lazy val akka            = "com.typesafe.akka" %% "akka-actor"           % akkaVersion
  lazy val akkaHttp        = "com.typesafe.akka" %% "akka-http"            % akkaHttpVersion
  lazy val akkaStream      = "com.typesafe.akka" %% "akka-stream"          % akkaVersion
  lazy val akkHttpSpryJson = "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion
  lazy val akkaStreamTest  = "com.typesafe.akka" %% "akka-stream-testkit"  % akkaVersion
  lazy val akkaTestKit     = "com.typesafe.akka" %% "akka-testkit"         % akkaVersion     % Test
  lazy val akkaHttpTestKit = "com.typesafe.akka" %% "akka-http-testkit"    % akkaHttpVersion % Test
  lazy val jsoup           = "org.jsoup"          % "jsoup"                % jsoupVersion
  lazy val scalaTest       = "org.scalatest"     %% "scalatest"            % scalaTestVersion

  lazy val webCrawlerDependencies = Seq(
    akka,
    akkaHttp,
    akkaStream,
    akkHttpSpryJson,
    akkaStreamTest,
    akkaTestKit,
    akkaHttpTestKit,
    jsoup,
    scalaTest
  )
}
