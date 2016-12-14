scalaVersion := "2.11.8"

scalacOptions += "-Xfatal-warnings"

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "2.2.6" % Test,
  "org.scalatest" %% "scalatest" % "2.2.6" % Test
)

scalacOptions ++= Seq("-Xfatal-warnings")

