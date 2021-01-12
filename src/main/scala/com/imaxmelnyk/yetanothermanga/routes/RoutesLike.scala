package com.imaxmelnyk.yetanothermanga.routes

import akka.http.scaladsl.server.Route

trait RoutesLike {
  def routes(): Route
}
