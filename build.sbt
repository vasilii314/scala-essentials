ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "HelloWorld"
  )

libraryDependencies += "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.0"
libraryDependencies += "org.scalafx" %% "scalafx" % "17.0.1-R26"