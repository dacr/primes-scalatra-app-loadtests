package lab

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

trait DummyDefaults {

  private def toBoolean(in:String):Boolean = {
    in.toLowerCase().trim match {
      case "true"|"1"|"on"|"yes"|"enabled"|"up" => true
      case _ => false
    }
  }
  
  private def provOrEnvOrDefault(key:String, default: => String):String = {
    import scala.util.Properties._
    propOrNone(key)
      .orElse(envOrNone(key))
      .getOrElse(default)    
  }
  
  val primesuiUrl = provOrEnvOrDefault("PRIMESUI_URL", "http://localhost:8080/primesui")
  
  def buildDefaultConfig(baseURL: String) = http
    .baseURL(baseURL)
    .acceptCharsetHeader("ISO-8859-1,utf-8;q=0.7,*;q=0.7")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("fr,fr-fr;q=0.8,en-us;q=0.5,en;q=0.3")
    .disableFollowRedirect

  val defaultHeaders = Map(
    "Keep-Alive" -> "timeout=300")

  val noKeepAliveHeaders = Map(
    "Connection" -> "Close")
}

