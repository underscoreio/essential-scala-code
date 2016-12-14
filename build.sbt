scalaVersion := "2.12.1"

scalacOptions += "-Xfatal-warnings"

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.1" % Test,
  "org.scalatest" %% "scalatest" % "3.0.1" % Test
)

scalacOptions ++= Seq("-Xfatal-warnings")

