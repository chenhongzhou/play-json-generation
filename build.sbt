name := """play-json-generation"""
version := "1.0.0"
scalaVersion := "2.11.11"
organization := "io.github.chenhongzhou"
organizationName := "io.github.chenhongzhou"

organizationHomepage := Some(url("https://github.com/chenhongzhou"))
homepage := Some(url("https://github.com/chenhongzhou/play-json-generation"))

version in ThisBuild := "0.3.2"

val jsoniterCore     = "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core" % "2.12.0"
val jsoniterMacros  = "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % "2.12.0" % "provided"

val buildSettings = Seq(
  organization := "io.github.chenhongzhou",
  organizationName := "io.github.chenhongzhou",
  organizationHomepage := Some(url("https://github.com/chenhongzhou")),
  scalaVersion := "2.11.12",
  crossScalaVersions := Seq("2.11.12", "2.12.6"),
  libraryDependencies ++= Seq(jsoniterCore, jsoniterMacros)

)

lazy val publishSettings = Seq(
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  },
  licenses += ("The Apache Software License, Version 2.0", url("http://www.apache.org/licenses/LICENSE-2.0.txt")),
  publishConfiguration := publishConfiguration.value,
  publishMavenStyle := true,
  publishArtifact in Test := false,
  pomIncludeRepository := { _ => false },
  pomExtra := (
    <scm>
      <url>git@github.com:chenhongzhou/play-json-generation.git</url>
      <connection>scm:git:git@github.com:chenhongzhou/play-json-generation.git</connection>
    </scm>
      <developers>
        <developer>
          <name>chenhongzhou</name>
          <organization>https://github.com/chenhongzhou</organization>
        </developer>
      </developers>
    )
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)
  .settings(buildSettings)
  .settings(publishSettings)



