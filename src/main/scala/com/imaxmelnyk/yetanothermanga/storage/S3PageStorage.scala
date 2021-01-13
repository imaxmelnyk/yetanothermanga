package com.imaxmelnyk.yetanothermanga.storage

import akka.NotUsed
import akka.http.scaladsl.model.{ContentType, MediaTypes}
import akka.stream.Materializer
import akka.stream.alpakka.s3.scaladsl.S3
import akka.stream.scaladsl.Source
import akka.util.ByteString
import com.imaxmelnyk.yetanothermanga.models.Chapter
import com.imaxmelnyk.yetanothermanga.storage.S3PageStorage._
import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.{ExecutionContext, Future}

class S3PageStorage extends LazyLogging {
  def savePage(fileSource: Source[ByteString, NotUsed],
               chapter: Chapter,
               pageNumber: Int)
              (implicit materializer: Materializer,
               ec: ExecutionContext): Future[Unit] = {
    val pageKey = getPageKey(chapter, pageNumber)

    val s3Sink = S3.multipartUpload(bucketName, pageKey, contentType = ContentType(MediaTypes.`image/png`))

    fileSource.runWith(s3Sink).map { result =>
      logger.info(s"Saved $pageKey (version: ${result.versionId})")
    }
  }
}

object S3PageStorage {
  private val bucketName = "yetanothermanga-dev"
  private val bucketUrl = "https://yetanothermanga-dev.s3.eu-central-1.amazonaws.com"

  def getPageKey(chapter: Chapter,
                 pageNumber: Int): String = {
    s"${chapter.mangaId}/${chapter.id}/$pageNumber.png"
  }

  def getPageUrl(chapter: Chapter,
                 pageNumber: Int): String = {
    s"$bucketUrl/${getPageKey(chapter, pageNumber)}"
  }
}
