2018-10-11

## Spring AOP

### 实现机制
1. 代理模式
    - 在访问者与被访问者之间
    - 几乎全权有用被代理者的功能
    - 作用
        - 减少被代理这的负担
        - 安全访问控制
        - **翻墙 计费**
    - 限制
        - **Joinpoint不同需要生成不同的代理类**
2. 动态代理
3. 动态字节码生成
    - CGLIB
    - **继承**
    