name := "spark1"

version := "0.1"

scalaVersion := "2.11.11"

libraryDependencies += "org.apache.spark" %% "spark-core" %"2.1.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" %"2.1.0"


libraryDependencies ++= Seq(
  "junit" % "junit" % "4.12",
  "org.scala-sbt" % "test-interface" % "1.0"
)
