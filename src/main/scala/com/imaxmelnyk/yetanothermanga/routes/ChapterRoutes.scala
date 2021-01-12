package com.imaxmelnyk.yetanothermanga.routes

import java.util.UUID

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

object ChapterRoutes extends RoutesLike {
  val routes: Route = pathPrefix("chapter") {
    pathEndOrSingleSlash {
      get {
        complete("get all chapters")
      } ~ post {
        complete("create new chapter")
      }
    } ~ (pathPrefix(JavaUUID) & pathEndOrSingleSlash) { chapterId =>
      get {
        complete(s"get chapter by id (id: $chapterId)")
      } ~ put {
        complete(s"change chapter by id (id: $chapterId)")
      } ~ delete {
        complete(s"delete chapter by id (id: $chapterId)")
      }
    }
  }

  def mangaRoutes(mangaId: UUID): Route = {
    (pathEndOrSingleSlash & get) {
      complete(s"get all manga (id: $mangaId) chapters")
    } ~ (pathPrefix(IntNumber) & pathEndOrSingleSlash & get) { chapterNumber =>
      complete(s"get chapter $chapterNumber of manga (id: $mangaId)")
    }
  }
}
