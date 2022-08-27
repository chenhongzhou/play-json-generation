package com.play.generation.format

import com.github.plokhotnyuk.jsoniter_scala.core.JsonValueCodec
import play.api.libs.json.Format

import scala.reflect.macros.whitebox.Context

/**
 * @author chenhongzhou
 * @Date 2022/08/24
 */
object PlayJsonGenerationMacro {

  def materializeJsonFormat[T: c.WeakTypeTag](c: Context): c.Expr[Format[T]] = {
    import c.universe._
    val tpe = c.weakTypeOf[T]
    c.Expr[Format[T]] {
      q"""
        import play.api.libs.json.Json
        import com.play.generation.format.JsonCache

        val clsName: String = ${show(tpe)}
        val format = JsonCache.getFormat[${tpe}](clsName)
        if (format == None) {
          this.synchronized {
          JsonCache.getFormat[${tpe}](clsName) match {
              case Some(f) => f
              case None =>
                val f = Json.format[${tpe}]
                JsonCache.setFormat[${tpe}](clsName, f)
              }
            }
          } else {
            format.get
        }
      """
    }
  }


  def materializeJsonCodec[T: c.WeakTypeTag](c: Context): c.Expr[JsonValueCodec[T]] = {
    import c.universe._

    // Resolve full class name from parameter type.
    val tpe = c.weakTypeOf[T]

    c.Expr[JsonValueCodec[T]] {
      q"""
        import com.github.plokhotnyuk.jsoniter_scala.core.JsonValueCodec
        import com.github.plokhotnyuk.jsoniter_scala.macros.{CodecMakerConfig, JsonCodecMaker}
        import com.play.generation.format.JsonCache

        val clsName: String = ${show(tpe)}
        val codec = JsonCache.getCodec[${tpe}](clsName)
        if (codec == None) {
          this.synchronized {
          JsonCache.getCodec[${tpe}](clsName) match {
              case Some(c) => c
              case None =>
                val c: JsonValueCodec[${tpe}] = JsonCodecMaker.make(CodecMakerConfig.withTransientDefault(false))
                JsonCache.setCodec[${tpe}](clsName, c)
              }
            }
          } else {
            codec.get
        }
      """
    }
  }
}