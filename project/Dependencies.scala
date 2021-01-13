import sbt._

object Dependencies {
  private val AkkaVersion = "2.6.8"
  private val AkkaHttpVersion = "10.2.2"
  private val logbackVersion = "1.2.3"
  private val scalaLoggingVersion = "3.9.2"
  private val alpakkaVersion = "2.0.2"
  private val awssdkS3Version = "2.15.62"

  val defaultDependencies = Seq(
    "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
    "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
    "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-xml" % AkkaHttpVersion,
    "ch.qos.logback" % "logback-classic" % logbackVersion,
    "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingVersion,
    "com.lightbend.akka" %% "akka-stream-alpakka-s3" % alpakkaVersion,
    "software.amazon.awssdk" % "s3" % awssdkS3Version)
}
