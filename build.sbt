organization := "com.imaxmelnyk"
name := "yetanothermanga"
version := "0.1-SNAPSHOT"
scalaVersion := "2.13.4"

libraryDependencies ++= Dependencies.defaultDependencies

// Dockerizing
enablePlugins(JavaAppPackaging, DockerPlugin)
dockerBaseImage := "openjdk:11-jre-buster"
