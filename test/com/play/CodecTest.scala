package com.play

import com.github.plokhotnyuk.jsoniter_scala.core.readFromString
import com.play.generation.format.JsonCache
import com.play.generation.format.main.EnableAuto.codec
import com.play.model.Entity.Food

object CodecTest extends App {
  val foodStr = "{\"weight\":2,\"colour\":\"red\"}"
  val foodTpe = "test.com.play.Entity.Food"
  val food = readFromString[Food](foodStr)
  println(food.weight)
  val foodCodecCache = JsonCache.getCodec(foodTpe)
  println(foodCodecCache)
  assert(JsonCache.getSize()._2 == 1)
}
