lazy val commonSettings = Seq(
  scalaVersion := "2.12.13"
)

lazy val infrastructure = project.in(file("infrastructure"))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
      "software.amazon.awscdk" % "core" % "1.131.0" withSources(),
      "software.amazon.awscdk" % "cdk-pipelines" % "1.131.0" withSources(),
    )
  )

lazy val app = project.in(file("app"))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "0.7.29" % Test
    )
  )
