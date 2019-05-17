2019-05-17

## 循环依赖

### 解决根本
1. 只可以解决 setter 注入造成的循环依赖
2. 通过 spring容器 **提前暴露** **刚完成构造器注入** 但是 没有完成其他步骤的bean 来完成
3. 只可以解决 setter 的 singleton 对象, 无法 prototype 对象(Spring容器不进行缓存"prototype"作用域的bean)

### 具体 (A-B-A)
1. A尝试初始化第一步, 构造函数, 并且将自己提前曝光给 singletonFactories
2. A 初识划第二步, 发现依赖 B, get(B), 发现没有被创建, 于是 createB
3. B 初始化后, set 发现依赖 A, 尝试 get(A), 
4. 尝试一级缓存 singletonObjects 没有, A 还没有初始化完
5. 尝试二级缓存, earlySingletonObjects 没有
6. 尝试三级缓存singletonFactories, B 得到了 A, 完成初始化, 将自己放入 一级缓存
7. 返回A 中, A 也从一级缓存获取 B, 完成初始化, 进入一级缓存

### 构造器的循环依赖无法解决
1. 至少 对象先初始化, 如果构造器依赖, 对象还没有初始化
