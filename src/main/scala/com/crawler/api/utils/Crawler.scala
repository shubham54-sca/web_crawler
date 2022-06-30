package com.crawler.api.utils

import com.crawler.api.models.CrawlerResponseData
import org.jsoup.Jsoup

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class Crawler {

  def crawl(url : String):Future[CrawlerResponseData] = Future{
   val data = Jsoup.connect(url).get().data()
    CrawlerResponseData(url, data)
  }

  def crawl(urls: List[String]):Future[List[CrawlerResponseData]] = {
    Future.sequence(urls.map(crawl))
  }

}
