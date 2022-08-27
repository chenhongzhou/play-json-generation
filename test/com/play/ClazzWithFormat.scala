package com.play.model

import com.play.generation.format.main.EnableAuto.formats
import com.play.generation.format.JsonCache
import com.play.model.Entity.BaseResponse
import com.play.model.children.OtherEntity.People
import play.api.libs.json.Json

class ClazzWithFormat {
  def formatMethod(): Int = {
    val peopleStr = "{\"name\":\"Tom\",\"age\":31}"
    val people = Json.parse(peopleStr).as[People]
    println(people.name)
    println(Json.toJson(BaseResponse(200, "OK", people)))
    JsonCache.getSize()._1
  }
}
