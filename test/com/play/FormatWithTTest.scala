package com.play

import com.play.generation.format.JsonCache
import com.play.generation.format.main.EnableAuto.formats
import com.play.model.Entity.{BaseResponse, Food}
import com.play.model.children.OtherEntity.People
import play.api.libs.json.Json


object FormatWithTTest extends App{
  val peopleStr = "[{\"name\":\"Tom\",\"age\":31},{\"name\":\"Tom1\",\"age\":311}]"
  val foodStr = "[{\"weight\":1,\"colour\":\"green\"},{\"weight\":2,\"colour\":\"red\"}]"
  val people = Json.parse(peopleStr).as[Array[People]]
  val baseStr = Json.toJson(BaseResponse(200, "OK", people))
  println(baseStr)

  val food = Json.parse(foodStr).as[Array[Food]]
  val baseFoodStr = Json.toJson(BaseResponse(200, "OK", food))
  println(baseFoodStr)
  assert(JsonCache.getSize()._1 ==4)
}
