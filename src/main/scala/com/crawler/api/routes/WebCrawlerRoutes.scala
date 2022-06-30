package com.crawler.api.routes

import akka.http.scaladsl.server.{Directives, Route}
import com.crawler.api.models.{CrawlerRequest, JsonProtocols}
import com.crawler.api.services.WebCrawlerService
import com.crawler.api.utils.Logging

class WebCrawlerRoutes(webCrawlerService: WebCrawlerService) extends Directives with JsonProtocols with Logging {

  /**
   * Post: {{url}}/api/crawl body:{ "urls":[] }
    */
  val routes: Route = path("api" / "crawl") {
    post {
      entity(as[CrawlerRequest]) { request =>
        infoLog(s"Received Request to crawl websites :- $request")
        val response = webCrawlerService.crawlWebsites(request.urls)
        infoLog(s"Request successfully processed")
        complete(response)
      }
    }
  }

}

object WebCrawlerRoutes {
  def apply() = new WebCrawlerRoutes(WebCrawlerService())
}
