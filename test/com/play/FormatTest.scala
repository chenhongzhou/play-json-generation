package com.play

import com.play.generation.format.JsonCache
import com.play.generation.format.main.EnableAuto.formats
import com.play.model.Entity.Food
import com.play.model.children.OtherEntity.People
import play.api.libs.json.Json


object FormatTest extends App {
  val peopleStr = "{\"name\":\"Tom\",\"age\":31}"
  val peopleStr2 = "{\"name\":\"Hehe\",\"age\":18}"
  val foodStr = "{\"weight\":2,\"colour\":\"red\"}"

  val people = Json.parse(peopleStr).as[People]
  val people2String = Json.toJson(people)
  println(people.name)
  println(people2String.toString())
  println("============")
  val a = People.getClass.getName
  people.getClass.getName
  val tpe = "test.com.play.children.OtherEntity.People"
  val peopleCache = JsonCache.getFormat(tpe)
  println(peopleCache)

  val people2 = Json.parse(peopleStr2).as[People]
  val people2String2 = Json.toJson(people2)
  println(people2.name)
  println(people2String2)
  println("============")
  val peopleCache2 = JsonCache.getFormat(tpe)
  println(peopleCache2)

  val food = Json.parse(foodStr).as[Food]
  val food2String = Json.toJson(food)
  println(food.weight)
  println("============")
  println(food2String)
  val foodTpe = "test.com.play.Entity.Food"
  val foodCache = JsonCache.getFormat(foodTpe)
  println(foodCache)


  val (fSize, _) = JsonCache.getSize()
  assert(fSize == 2)
}
