name := "primesui-scalatra-app-loadtest"

version := "v2015-11-10"

scalaVersion := "2.11.7"

scalacOptions ++= Seq("-unchecked", "-deprecation" , "-feature")

enablePlugins(GatlingPlugin)

fork := true
javaOptions in test ++= Seq(
   "-Xms2g",
   "-Xmx2g",
   "-Xmn1g",
// "-XX:GCTimeRatio=50", 
// "-XX:SurvivorRatio=4",
 "-XX:+UseConcMarkSweepGC",
 "-XX:+UseParNewGC",
 "-XX:+CMSParallelRemarkEnabled",
 "-XX:+ScavengeBeforeFullGC",
 "-XX:+CMSScavengeBeforeRemark",
 "-XX:+ExplicitGCInvokesConcurrent",
 "-XX:+CMSClassUnloadingEnabled",
 "-XX:+UseCMSInitiatingOccupancyOnly",
 "-XX:CMSInitiatingOccupancyFraction=80",
 "-XX:ParallelGCThreads=4",
 "-XX:+UseThreadPriorities",
 "-XX:ThreadPriorityPolicy=42",
 "-XX:+AggressiveOpts",
 "-XX:+OptimizeStringConcat",
 "-XX:+UseFastAccessorMethods",
 "-XX:+UseThreadPriorities", 
 "-XX:ThreadPriorityPolicy=42",
 "-Djava.net.preferIPv4Stack=true",
 "-Djava.net.preferIPv6Addresses=false"
)

libraryDependencies ++= Seq(
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.1.7" % "test",
  "io.gatling"            % "gatling-test-framework"    % "2.1.7" % "test",
  "io.gatling"            % "gatling-bundle"            % "2.1.7" % "test" artifacts (Artifact("gatling-bundle", "zip", "zip", "bundle"))
)

