package com.crawler.api

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import com.crawler.api.routes.WebCrawlerRoutes

object ServerApp {

  implicit val actorSystem: ActorSystem = ActorSystem("ActorSystem")

  val interface: String = "0.0.0.0"
  val port:      Int    = 9991

  def main(args: Array[String]): Unit = {
    val routes: Route =
      WebCrawlerRoutes().routes

    Http().newServerAt(interface, port).bind(routes)

    println(s"Server is ready on interface $interface and port $port")
  }
}
