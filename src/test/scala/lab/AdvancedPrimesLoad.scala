package lab

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import scala.concurrent.duration._
import scala.language.postfixOps

class AdvancedPrimesLoad extends Simulation with DummyDefaults {
  //val httpConf = buildDefaultConfig("http://127.0.0.1:8080/primesui")
  val httpConf = buildDefaultConfig("http://127.0.0.1/primesui")

  def rand(i: Int) : String = java.util.concurrent.ThreadLocalRandom.current.nextInt(i).toString

  val scn =
        scenario("Simple primes load").during(5 minutes) {
          exec(
                http("primesui homage")
                   .get("/")
                   .headers(defaultHeaders)
                   .check(status.is(200)) )
          .pause(500 milliseconds, 1000 milliseconds)
          .exec(
                http("check prime first")
                   .get(_ => "/check/"+rand(20000))
                   .headers(defaultHeaders)
                   .check(status.is(200)) )
          .pause(250 milliseconds, 500 milliseconds)
          .exec(
                http("check prime second")
                   .get(_ => "/check/"+rand(20000))
                   .headers(defaultHeaders)
                   .check(status.is(200)) )
          .pause(500 milliseconds, 1000 milliseconds)
        }

  setUp(scn.inject(rampUsers(500) over(60 seconds))).protocols(httpConf)
}

