package com.imaxmelnyk.yetanothermanga

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import com.imaxmelnyk.yetanothermanga.routes.Routes
import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.ExecutionContext
import scala.util.Failure

object Main extends App with LazyLogging {
  implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "yetanothermanga-system")
  implicit val ec: ExecutionContext = system.executionContext

  Http().newServerAt("localhost", 8080).bind(Routes.routes).onComplete {
    case Failure(_) =>
      system.terminate()
      logger.error("Failed to start the server...")
    case _ =>
      logger.info("Started the server...")
  }
}
