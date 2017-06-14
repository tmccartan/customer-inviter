lazy val projectSettings: Seq[Def.Setting[_]] = Seq(
  organization := "com",
  name := "customer-inviter",
  scalaVersion := "2.11.8"
)

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json" % "2.6.0-RC2",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)