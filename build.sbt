name := "primesui-scalatra-app-loadtest"

version := "v2015-11-10"

scalaVersion := "2.11.7"

scalacOptions ++= Seq("-unchecked", "-deprecation" , "-feature")

enablePlugins(GatlingPlugin)

libraryDependencies ++= Seq(
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.1.7" % "test",
  "io.gatling"            % "gatling-test-framework"    % "2.1.7" % "test",
  "io.gatling"            % "gatling-bundle"            % "2.1.7" % "test" artifacts (Artifact("gatling-bundle", "zip", "zip", "bundle"))
)

