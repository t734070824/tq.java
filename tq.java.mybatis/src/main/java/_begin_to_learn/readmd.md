2018-01-04
### Mybatis 配置文件
1. configuration节点为根节点。
2. 在configuration节点之下，我们可以配置10个子节点， 
分别为：properties、typeAliases、plugins、objectFactory、objectWrapperFactory、settings、environments、databaseIdProvider、typeHandlers、mappers

### Properties 与 XML 同时配置
1. 优先读取XML中的数据, 然后读取 Properties, 相同的key覆盖
```javascript
Properties defaults = context.getChildrenAsProperties();
String resource = context.getStringAttribute("resource");
String url = context.getStringAttribute("url");
if (resource != null && url != null) {
  throw new BuilderException("...");
}
if (resource != null) {
  defaults.putAll(Resources.getResourceAsProperties(resource));
} else if (url != null) {
  defaults.putAll(Resources.getUrlAsProperties(url));
}
```
### 关键字
1. 动态代理(Mapper)
2. 缓存(一,二级缓存)
3. 数据库连接池(最大活动连接, 最大空闲连接, 最大空闲时间)
4. 动态SQL
5. sql文件统一存放
6. 结果映射

### 关键类
![](https://github.com/t734070824/tq.java/blob/master/tq.java.mybatis/src/main/java/_begin_to_learn/1.png?raw=true)