name := "primesui-scalatra-app-loadtest"

version := "v2016-03-15"

scalaVersion := "2.11.8"

scalacOptions ++= Seq("-unchecked", "-deprecation" , "-feature")

enablePlugins(GatlingPlugin)

fork := true

javaOptions in Gatling := Seq(
   "-Xms2g",
   "-Xmx2g",
   "-Xmn200m",
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
 "-XX:CMSInitiatingOccupancyFraction=60",
 "-XX:ParallelGCThreads=4",
 "-XX:+AggressiveOpts",
 "-XX:+OptimizeStringConcat",
 "-XX:+UseFastAccessorMethods",
 "-XX:+UseThreadPriorities", 
 "-XX:ThreadPriorityPolicy=42",
 "-verbose:gc",
 "-XX:+PrintGCDetails",
 "-XX:+PrintGCDateStamps",
 "-Xloggc:GC_gatling.log",
 "-Djava.net.preferIPv4Stack=true",
 "-Djava.net.preferIPv6Addresses=false"
)

/*
javaOptions in Gatling := Seq(
 "-Xms2g",
 "-Xmx2g",
 "-XX:+UseG1GC",
 "-XX:MaxGCPauseMillis=50",
 "-XX:G1HeapRegionSize=200m",
 "-XX:InitiatingHeapOccupancyPercent=75",
 "-XX:+ParallelRefProcEnabled",
 "-XX:+PerfDisableSharedMem",
 "-XX:+AggressiveOpts",
 "-XX:+OptimizeStringConcat",
 "-verbose:gc",
// "-XX:+PrintGCDetails",
 "-XX:+PrintGCDateStamps",
 "-Xloggc:GC_gatling.log",
 "-Djava.net.preferIPv4Stack=true",
 "-Djava.net.preferIPv6Addresses=false"
)
*/

libraryDependencies ++= Seq(
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.1.7" % "test",
  "io.gatling"            % "gatling-test-framework"    % "2.1.7" % "test",
  "io.gatling"            % "gatling-bundle"            % "2.1.7" % "test" artifacts (Artifact("gatling-bundle", "zip", "zip", "bundle"))
)

