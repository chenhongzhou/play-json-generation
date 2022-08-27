package com.play

import com.play.model.ClazzWithFormat

object ClazzTest extends App {
  val obj: ClazzWithFormat = new ClazzWithFormat
  assert(obj.formatMethod() == 2)
}
