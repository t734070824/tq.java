2018-10-15

## 统一的数据访问异常层次体系

### DAO
1. 屏蔽不同数据访问机制的差异
2. 但是
    - 返回的异常不同怎么办???
    
### 解决
1. 以 unchecked exception 进行封装返回
2. 问题
    - 如何屏蔽具体异常的差异
        - 异常的分类转译
            - 针对不同的数据库的规则分析错误
    - 错误统一分类
        - 连接失败
        - 数据一致性冲突
3. 异常
    - ClearupFailureDataAccessException
        - 资源清理失败: 关闭数据库连接
    - DataAccessResourceFailureException
        - 无法访问数据源
    - ConcurrencyFailureException
        - 并发访问数据库失败: 获取锁失败
    - PermissionDeniedDataAccessException
        - 没有响应的权限
    - DataIntegrityViolationException
        - 数据一致性冲突


