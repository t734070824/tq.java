2018-11-09

## Map接口与 Xml 配置文件的关系

### 为什么 namespace 是 接口的相对地址
1. 解析的时候要关联 接口
2. 尝试 Resources.classForName, 如果成功, 就动态代理

### 为什么xml里面的id 要和 接口里面的方法名一致
1. 在通过 MapperProxy.invoke() 之后, 要根据方法名获取 xml 中相对应的id, 获取命令类型, 然后通过返回结果类型
    来决定具体的 sqlSession.function()