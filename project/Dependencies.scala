import sbt._

object Dependencies {
  private val AkkaVersion = "2.6.8"
  private val AkkaHttpVersion = "10.2.2"
  private val logbackVersion = "1.2.3"
  private val scalaLoggingVersion = "3.9.2"

  val defaultDependencies = Seq(
    "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
    "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
    "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
    "ch.qos.logback" % "logback-classic" % logbackVersion,
    "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingVersion)
}
