package com.crawler.api

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.testkit.ScalatestRouteTest
import com.crawler.api.models._
import com.crawler.api.routes.WebCrawlerRoutes
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import spray.json._

import scala.concurrent.Await
import scala.concurrent.duration._

class ServerAppSpec extends AnyWordSpec with Matchers with ScalatestRouteTest with JsonProtocols {

  "A Request to Crawl List of url" should {
    "return all crawl data " in {
      val crawlerRequest = CrawlerRequest(List("https://google.com", "https://github.com"))
      Post("/api/crawl", crawlerRequest) ~> WebCrawlerRoutes().routes ~> check {
        status shouldBe StatusCodes.OK
        val strictEntityFuture = response.entity.toStrict(1.second)
        val strictEntity       = Await.result(strictEntityFuture, 1.second)
        val crawlerResponse    = strictEntity.data.utf8String.parseJson.convertTo[CrawlerResponse]
        assert(crawlerResponse.result.nonEmpty)
      }
    }

    "return Error in case of Exception Occurred" in {
      val crawlerRequest = CrawlerRequest(List("https:google.com", "https://github.com"))
      Post("/api/crawl", crawlerRequest) ~> WebCrawlerRoutes().routes ~> check {
        // assertions
        status shouldBe StatusCodes.OK
        val strictEntityFuture = response.entity.toStrict(2.second)
        val strictEntity       = Await.result(strictEntityFuture, 2.second)
        val crawlerResponse    = strictEntity.data.utf8String.parseJson.convertTo[CrawlerResponse]
        assert(crawlerResponse.error.nonEmpty)
      }
    }

  }
}
