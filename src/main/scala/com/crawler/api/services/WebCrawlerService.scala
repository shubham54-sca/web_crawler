package com.crawler.api.services

import com.crawler.api.models.CrawlerResponse
import com.crawler.api.utils.Crawler

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.control.NonFatal

class WebCrawlerService(crawler: Crawler) {

  def crawlWebsites(urls: List[String]): Future[CrawlerResponse] =
    crawler.crawl(urls).map(values => CrawlerResponse(values, "")).recover { case NonFatal(th) =>
      CrawlerResponse(List.empty, th.getMessage)
    }

}

object WebCrawlerService {
  def apply(): WebCrawlerService = new WebCrawlerService(new Crawler)
}
