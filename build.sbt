organization := "com.imaxmelnyk"
name := "yetanothermanga"
version := "0.1-SNAPSHOT"
scalaVersion := "2.13.4"

libraryDependencies ++= Dependencies.defaultDependencies

test in assembly := {}
assemblyJarName in assembly := s"${name.value}_${version.value}.jar"
