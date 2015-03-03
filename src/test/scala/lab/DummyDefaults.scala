package lab

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._


trait DummyDefaults {
        def buildDefaultConfig(baseURL:String) = http
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

