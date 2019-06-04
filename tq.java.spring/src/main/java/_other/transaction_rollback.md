2019-06-04

## 异常回滚

### 什么时候会 回滚
1. 默认spring事务只在发生未被捕获的 runtimeexcetpion + ERROR 时才回滚。  
2. aop 异常捕获原理
    - 被拦截的方法需要显示的抛出异常, 并不经过任何处理, 才能回滚.
    - **可以通过配置来捕获特定的异常来回滚**
        - **@Transaction(rollbackFor=Exception.class)**
    - 手动回滚
        - TransactionAspectSupport.currentTransactionStatus().setRollbackOnly()