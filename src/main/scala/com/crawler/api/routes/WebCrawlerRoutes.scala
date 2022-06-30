package com.crawler.api.routes

import akka.http.scaladsl.server.{Directives, Route}
import com.crawler.api.models.{CrawlerRequest, JsonProtocols}
import com.crawler.api.services.WebCrawlerService



class WebCrawlerRoutes(webCrawlerService: WebCrawlerService) extends Directives with JsonProtocols {

  val routes: Route = path("api" / "crawl") {
    post {
      entity(as[CrawlerRequest]) { request =>
        val response = webCrawlerService.crawlWebsites(request.urls)
        complete(response)
      }
    }
  }

}

object WebCrawlerRoutes {
  def apply() = new WebCrawlerRoutes(WebCrawlerService())
}
