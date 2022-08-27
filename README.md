# What's  play-json-generation 
play-json-generation 是一个专门为 [Play Framework](https://www.playframework.com/) 开发的 序列化 模块, 为 Play Framework 提供一种简洁的 默认序列化 访问方式。
play-json-generation is a serialization module specially developed for [Play Framework](https://www.playframework.com/), which provides a simple default serialization access method for the play framework.
And provides the default mode of other serialization modules, such as:

- Generate 'play.api.libs.json.Format' according to the case class

- Generate 'com.github.plokhotnyuk.jsoniter_scala.core.JsonValueCodec' according to the case class

- Easy to use 'import com.play.generation.format.main.EnableAuto._'

## Existing problems

- Mixing the implicit definition of the same class / object with EnableAuto may lead to duplicate definition errors

- JsonValueCodec does not support serialization in the form of array and list