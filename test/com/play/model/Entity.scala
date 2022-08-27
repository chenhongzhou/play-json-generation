package com.play.model


object Entity {
  case class Food(weight: Int, colour: String)

  case class BaseResponse[T](code: Int, msg: String, data: T)
}
