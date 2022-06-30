package com.crawler.api.utils

import com.crawler.api.models.CrawlerResponseData
import org.jsoup.Jsoup

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class Crawler {

  /** Run task on thread
    * @param url
    *   , website url to be provided
    * @return
    *   Future[CrawlerResponseData]
    */
  def crawl(url: String): Future[CrawlerResponseData] = Future {
    val data = Jsoup.connect(url).get().data()
    CrawlerResponseData(url, data)
  }

  /** Transform the List(Future[CrawlerResponseData]) to Future(List[CrawlerResponseData])
    * @param urls
    *   , List of website url to be provided
    * @return
    *   Future(List[CrawlerResponseData])
    */
  def crawl(urls: List[String]): Future[List[CrawlerResponseData]] =
    Future.sequence(urls.map(crawl))

}
