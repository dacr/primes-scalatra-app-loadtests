package lab

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import scala.concurrent.duration._

class AdvancedPrimesLoad extends Simulation with DummyDefaults {
  val httpConf = buildDefaultConfig("http://127.0.0.1:8080/primesui")

  def rand(i: Int) : String = java.util.concurrent.ThreadLocalRandom.current.nextInt(i).toString

  val scn =
        scenario("Simple primes load").during(10 minutes) {
          exec(
                http("primesui homage")
                   .get("/")
                   .headers(defaultHeaders)
                   .check(status.is(200)) )
          .pause(1000 milliseconds, 3000 milliseconds)
          .exec(
                http("check prime")
                   .get(_ => "/check/"+rand(20000))
                   .headers(defaultHeaders)
                   .check(status.is(200)) )
          .pause(1000 milliseconds, 3000 milliseconds)
        }

  setUp(scn.inject(rampUsers(1500) over(30 seconds))).protocols(httpConf)
}

