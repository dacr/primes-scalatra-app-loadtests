name := "primesui-scalatra-app-loadtest"

version := "v2015-02-03"

scalaVersion := "2.11.5"

scalacOptions ++= Seq("-unchecked", "-deprecation" , "-feature")

enablePlugins(GatlingPlugin)

libraryDependencies ++= Seq(
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.1.4" % "test",
  "io.gatling"            % "gatling-test-framework"    % "2.1.4" % "test",
  "io.gatling"            % "gatling-bundle"            % "2.1.4" % "test" artifacts (Artifact("gatling-bundle", "zip", "zip", "bundle"))
)

