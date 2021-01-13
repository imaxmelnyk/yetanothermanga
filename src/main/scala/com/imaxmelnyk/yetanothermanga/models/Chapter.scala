package com.imaxmelnyk.yetanothermanga.models

import java.util.UUID

import com.imaxmelnyk.yetanothermanga.storage.S3PageStorage

case class Chapter(id: UUID,
                   mangaId: UUID,
                   number: Int,
                   volumeNumber: Option[Int],
                   title: Option[String],
                   numberOfPages: Int) {
  import Chapter._

  lazy val pages: Seq[Page] = (1 to numberOfPages).map { pageNumber =>
    Page(pageNumber, S3PageStorage.getPageUrl(this, pageNumber))
  }
}

object Chapter {
  case class Page(number: Int, url: String)
}
