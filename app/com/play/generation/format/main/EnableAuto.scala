package com.play.generation.format.main

import com.github.plokhotnyuk.jsoniter_scala.core.JsonValueCodec
import com.play.generation.format.PlayJsonGenerationMacro
import play.api.libs.json.Format

import scala.language.experimental.macros
/**
 * @author chenhongzhou
 * @Date 2022/08/24
 */
object EnableAuto {
  implicit def formats[T <: Product]: Format[T] = macro PlayJsonGenerationMacro.materializeJsonFormat[T]

  implicit def codec[T <: Product]: JsonValueCodec[T] = macro PlayJsonGenerationMacro.materializeJsonCodec[T]
}
