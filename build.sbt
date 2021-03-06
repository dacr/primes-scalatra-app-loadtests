name := "primesui-scalatra-app-loadtest"

version := "v2016-11-29"

scalaVersion := "2.11.8"

scalacOptions ++= Seq("-unchecked", "-deprecation" , "-feature")

enablePlugins(GatlingPlugin)

fork := true

javaOptions in Gatling := Seq(
 "-Xms2g",
 "-Xmx2g",
 "-Xmn300m",
 "-XX:+PerfDisableSharedMem",
 "-XX:+UseAdaptiveSizePolicy",
 "-XX:GCTimeRatio=95",
// "-XX:ParallelGCThreads=4",
 "-XX:+UseParNewGC",
 "-XX:MaxGCPauseMillis=200",
 "-XX:+AggressiveOpts",
 "-XX:+OptimizeStringConcat",
 "-XX:+UseFastAccessorMethods",
 "-XX:+UseThreadPriorities", 
 "-XX:ThreadPriorityPolicy=42",
 "-verbose:gc",
 "-XX:+PrintGCDetails",
 "-XX:+PrintGCDateStamps",
 "-Xloggc:GC_gatling.log",
 "-Djava.security.egd=file:///dev/urandom",
 "-Djava.net.preferIPv4Stack=true",
 "-Djava.net.preferIPv6Addresses=false"
)

/*
javaOptions in Gatling := Seq(
 "-Xms2g",
 "-Xmx2g",
 "-Xmn300m",
 "-XX:+PerfDisableSharedMem",
 "-XX:+ExplicitGCInvokesConcurrent",
 "-XX:+UseConcMarkSweepGC",
 "-XX:+CMSIncrementalMode",
 "-XX:+CMSIncrementalPacing",
 "-XX:CMSIncrementalDutyCycleMin=10",
 "-XX:CMSIncrementalDutyCycle=50",
 "-XX:ParallelGCThreads=4",
 "-XX:+UseParNewGC",
 "-XX:MaxGCPauseMillis=500",
 "-XX:GCTimeRatio=10",
 "-XX:+AggressiveOpts",
 "-XX:+OptimizeStringConcat",
 "-XX:+UseFastAccessorMethods",
 "-XX:+UseThreadPriorities", 
 "-XX:ThreadPriorityPolicy=42",
 "-verbose:gc",
 "-XX:+PrintGCDetails",
 "-XX:+PrintGCDateStamps",
 "-Xloggc:GC_gatling.log",
 "-Djava.security.egd=file:///dev/urandom",
 "-Djava.net.preferIPv4Stack=true",
 "-Djava.net.preferIPv6Addresses=false"
)
*/

/*
javaOptions in Gatling := Seq(
 "-Xms2g",
 "-Xmx2g",
 "-Xmn300m",
 //"-XX:GCTimeRatio=50", 
 //"-XX:SurvivorRatio=4",
 "-XX:+PerfDisableSharedMem",  // Decrease the latency !!!
 "-XX:+UseConcMarkSweepGC",
 "-XX:+UseParNewGC",
 "-XX:+CMSParallelRemarkEnabled",
 "-XX:+ScavengeBeforeFullGC",
 "-XX:+CMSScavengeBeforeRemark",
 "-XX:+ExplicitGCInvokesConcurrent",
 "-XX:+CMSClassUnloadingEnabled",
 "-XX:+UseCMSInitiatingOccupancyOnly",
 "-XX:CMSInitiatingOccupancyFraction=70",
// "-XX:ParallelGCThreads=5", // Number of CPU / 2 if load test injection is done from the same host
 "-XX:+AggressiveOpts",
 "-XX:+OptimizeStringConcat",
 "-XX:+UseFastAccessorMethods",
 "-XX:+UseThreadPriorities", 
 "-XX:ThreadPriorityPolicy=42",
 "-verbose:gc",
 "-XX:+PrintGCDetails",
 "-XX:+PrintGCDateStamps",
 "-Xloggc:GC_gatling.log",
 "-Djava.security.egd=file:///dev/urandom",
 "-Djava.net.preferIPv4Stack=true",
 "-Djava.net.preferIPv6Addresses=false"
)
*/

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
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.2.3" % "test",
  "io.gatling"            % "gatling-test-framework"    % "2.2.3" % "test",
  "io.gatling"            % "gatling-bundle"            % "2.2.3" % "test" artifacts (Artifact("gatling-bundle", "zip", "zip", "bundle"))
)

//resolvers += "JAnalyse Repository" at "http://www.janalyse.fr/repository/"

