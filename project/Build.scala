import sbt._
import Keys._

object FPInScalaBuild extends Build {


  val dependencies = Seq(
    "org.scalatest" % "scalatest_2.11" % "3.0.0-SNAP4",
    "junit" % "junit" % "4.12"
  )

  val opts = Project.defaultSettings ++ Seq(
    name := "fpinscala" ,
    version := "0.1",
    scalaVersion := "2.11.4",
    scalacOptions := Seq("-deprecation"),
    resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/" ,
    libraryDependencies ++= dependencies
  )

  /****
  lazy val root =
    Project(id = "fpinscala",
            base = file("."),
            settings = opts ++ Seq(
              onLoadMessage ~= (_ + nio2check())
            )) aggregate (chapterCode, exercises, answers)
    *****/

  lazy val root = Project("fpinscala", file(".")) settings(
    version       := "0.2",
    scalaVersion  := "2.11.4",
    scalacOptions := Seq("-deprecation"),
    libraryDependencies ++= dependencies
    )  aggregate (chapterCode, exercises, answers)


  lazy val chapterCode =
    Project(id = "chapter-code",
            base = file("chaptercode"),
            settings = opts)
  lazy val exercises =
    Project(id = "exercises",
            base = file("exercises"),
            settings = opts)
  lazy val answers =
    Project(id = "answers",
            base = file("answers"),
            settings = opts)

  def nio2check(): String = {
    val cls = "java.nio.channels.AsynchronousFileChannel"
    try {Class.forName(cls); ""}
    catch {case _: ClassNotFoundException =>
      ("\nWARNING: JSR-203 \"NIO.2\" (" + cls + ") not found.\n" +
       "You are probably running Java < 1.7; answers will not compile.\n" +
       "You seem to be running " + System.getProperty("java.version") + ".\n" +
       "Try `project exercises' before compile, or upgrading your JDK.")
    }
  }
}

