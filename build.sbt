name := "primesui-scalatra-app-loadtest"

version := "v2015-11-10"

scalaVersion := "2.11.7"

scalacOptions ++= Seq("-unchecked", "-deprecation" , "-feature")

enablePlugins(GatlingPlugin)

javaOptions in Gatling := overrideDefaultJavaOptions("-Xms2048m", "-Xmx2048m")

libraryDependencies ++= Seq(
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.2.0" % "test",
  "io.gatling"            % "gatling-test-framework"    % "2.2.0" % "test",
  "io.gatling"            % "gatling-bundle"            % "2.2.0" % "test" artifacts (Artifact("gatling-bundle", "zip", "zip", "bundle"))
)

