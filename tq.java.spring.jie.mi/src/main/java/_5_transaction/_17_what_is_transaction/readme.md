2018-10-21

## 什么是事务

### 事务存在的目的
1. ACID-->事务执行后, 系统处于"正确"的状态
2. 事务的隔离级别
    - 数据库有默认的隔离级别
    - Spring, JDBC 的访问方式 都可以为事务指定4中隔离级别, 但最终由底层的数据库决定

### 参与事务管理的成员
1. Resource Manager
    - RM
    - 存储并管理系统数据资源的状态
2. Transaction Processing Monitor
    - TPM TP Monitor
    - **在分布式事务场景中协调包含多个RM的事务处理**
3. Transaction Manager
    - TM
    - 直接负责多RM之间事务处理的协调工作
    - 提供事务界定, 事务上下文传播 等功能接口
4. Application
    - 事务边界的触发点
    
### 涉及 RM 的多少来区分事务类型
1. 全局事务
    - 多个RM参与
    - 引入 TPM 来协调
    - 两阶段(Two-Phase Commit)提交协议保证整个事务的ACID属性
    - 比喻
        - 西方婚礼过程
2. 局部事务
    - 只有一个 RM 参与