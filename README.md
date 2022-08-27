# play-json-generation 介绍
play-json-generation 是一个专门为 [Play Framework](https://www.playframework.com/) 开发的 序列化 模块, 为 Play Framework 提供一种简洁的 默认序列化 访问方式。
并且提供了其他序列化模块的默认方式，例如，

- 根据case class生成play.api.libs.json.Format

- 根据case class生成com.github.plokhotnyuk.jsoniter_scala.core.JsonValueCodec

- import com.play.generation.format.main.EnableAuto._方便使用

## 存在问题

- 同一class/object显式定义和混用可能会导致重复定义错误

- JsonValueCodec还不支持数组、列表形式的序列化操作