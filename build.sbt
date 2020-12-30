
name := "magnolia-268-sealed-trait-bug"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq("com.propensive" %% "magnolia" % "0.17.0",      "org.scala-lang" % "scala-reflect" % scalaVersion.value)

lazy val root = (project in file(".")).settings(commonSmlBuildSettings)
