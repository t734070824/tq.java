2018-11-12

## 核心处理层

### 初始化过程
1. XMLConfigBuilder.parse()
    - properties
    - setting
        - 全局配置信息
    - typeAliases
        - 别名
    - plugins
        - 插件
        - Interceptor
        - chain
    - objectFactory
    - objectWrapperFactory
    - reflectorFactory
    - environment
        - 多个数据库环境
    - databaseIdProvider
        - 实现类似 Hiberbate 方言的功能
        - databaseid, 区分不同的sqls
    - typeHandler
    - mappers
        - 配置文件
        - 注解
