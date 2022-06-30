package com.crawler.api.models

case class CrawlerResponseData(url:String, data:String)

case class CrawlerResponse (result:List[CrawlerResponseData], error:String)
