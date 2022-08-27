package com.play.generation.format

import com.github.plokhotnyuk.jsoniter_scala.core.JsonValueCodec
import play.api.libs.json.Format

import java.util.concurrent.ConcurrentHashMap

/**
 * @author chenhongzhou
 * @Date 2022/08/24
 */
object JsonCache {
  private val formatCache = new ConcurrentHashMap[String, Format[_]]()

  private val codecCache = new ConcurrentHashMap[String, JsonValueCodec[_]]()

  def getFormat[T](clsName: String): Option[Format[T]] = {
    val format = formatCache.get(clsName)
    if (format == null) None else Option(format.asInstanceOf[Format[T]])
  }

  /**
   * put return Format[_] but need Format[T]
   *
   * @param clsName
   * @param format
   * @tparam T
   * @return
   */
  def setFormat[T](clsName: String, format: Format[T]): Format[T] = {
    formatCache.put(clsName, format)
    format
  }

  def getCodec[T](clsName: String): Option[JsonValueCodec[T]] = {
    val codec = codecCache.get(clsName)
    if (codec == null) None else Option(codec.asInstanceOf[JsonValueCodec[T]])
  }

  def setCodec[T](clsName: String, codec: JsonValueCodec[T]): JsonValueCodec[T] = {
    codecCache.put(clsName, codec)
    codec
  }

  def getSize(): (Int, Int) = {
    (formatCache.size, codecCache.size)
  }
}
