2018-10-08

## Spring Boot

### 注解
1. EnableAutoConfiguration
    - Spring 将采用默认的配置项
        - SpringMvc + Tomcat
    - 依赖具体的 jar
2. SpringBootApplication
    - same as @Configuration @EnableAutoConfiguration @ComponentScan

### Restart vs Reload
1. spring boot -- Restart
    - 两个classLoader
    
### 中文
1. TODO

### 类型安全的配置
1. 独立配置
2. bean 添加注解, 说明配置文件位置

### Profile配置问题
1. 测试环境与生产环境的配置文件
    - dev
    - prod

### 测试
1. 