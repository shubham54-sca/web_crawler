package com.crawler.api

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

package object models {
  trait JsonProtocols extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val crawlerRequestFormat:      RootJsonFormat[CrawlerRequest]      = jsonFormat1(CrawlerRequest.apply)
    implicit val crawlerResponseDataFormat: RootJsonFormat[CrawlerResponseData] = jsonFormat2(CrawlerResponseData)
    implicit val crawlerResponseFormat:     RootJsonFormat[CrawlerResponse]     = jsonFormat2(CrawlerResponse)
  }
}
