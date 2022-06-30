package com.crawler.api.utils

import org.slf4j.{Logger, LoggerFactory}
trait Logging {

  @transient
  private lazy val log: Logger = LoggerFactory.getLogger(this.getClass)

  protected def debugLog(message: => String): Unit =
    log.debug(message)

  protected def infoLog(message: => String): Unit =
    log.info(message)

  protected def warnLog(message: => String): Unit =
    log.warn(message)

  protected def errorLog(message: => String): Unit =
    log.error(message)

  protected def errorLog(message: => String, exception: => Throwable): Unit =
    log.error(message, exception)

}
