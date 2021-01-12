package com.imaxmelnyk.yetanothermanga.routes

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._

object MangaRoutes extends RoutesLike {
  val routes: Route = pathPrefix("manga") {
    pathEndOrSingleSlash {
      get {
        complete("list all manga")
      } ~ post {
        complete("create new manga")
      }
    } ~ pathPrefix(JavaUUID) { mangaId =>
      pathEndOrSingleSlash {
        get {
          complete(s"get manga by id (id: $mangaId)")
        } ~ put {
          complete(s"change manga by id (id: $mangaId)")
        } ~ delete {
          complete(s"delete manga by id (id: $mangaId)")
        }
      } ~ pathPrefix("chapter") {
        ChapterRoutes.mangaRoutes(mangaId)
      }
    }
  }
}
