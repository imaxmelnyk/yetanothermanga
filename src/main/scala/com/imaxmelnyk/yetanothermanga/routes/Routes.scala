package com.imaxmelnyk.yetanothermanga.routes

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._

object Routes extends RoutesLike {
  val routes: Route = MangaRoutes.routes ~ ChapterRoutes.routes
}
