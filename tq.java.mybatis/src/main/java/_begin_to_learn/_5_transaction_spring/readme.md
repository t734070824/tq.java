2018-06-14

## 集成Spring事务管理

### SqlSession.commit
1. MyBatis并不会帮我们自动提交事务
2. 必须手动通过SqlSession的commit()方法提交事务

### Mybatis + Spring
1. MyBatis的配置文件config.xml里面，关于jdbc连接的部分可以都去掉，只保留typeAliases的部分：
2. MyBatis另外一个配置文件student_mapper.xml不需要改动
3. spring.xml-->事务管理器和数据库连接池两部分的内容
4. 注解:
    - @Repository，这个注解和@Component、@Controller和我们最常见的@Service注解是一个作用，都可以将一个类声明为一个Spring的Bean。它们的区别到不在于具体的语义上，更多的是在于注解的定位上
        - @Repository注解，对应的是持久层即Dao层，其作用是直接和数据库交互，通常来说一个方法对应一条具体的Sql语句
        - @Service注解，对应的是服务层即Service层，其作用是对单条/多条Sql语句进行组合处理，当然如果简单的话就直接调用Dao层的某个方法了
        - @Controller注解，对应的是控制层即MVC设计模式中的控制层，其作用是接收用户请求，根据请求调用不同的Service取数据，并根据需求对数据进行组合、包装返回给前端
        - @Component注解，这个更多对应的是一个组件的概念，如果一个Bean不知道属于拿个层，可以使用@Component注解标注
    - @Resource，这个注解和@Autowired注解是一个意思，都可以自动注入属性属性
    - @Transactional注解
        - 同一个类，对方法的事物管理配置会覆盖对类的事务管理配置
        - @Transactional(propagation = Propagation.REQUIRED)
            - 事物的传播特性
        - @Transactional(isolation = Isolation.DEFAULT)
            - 事物隔离级别
        - @Transactional(readOnly = true)
            - 该事物是否为一个只读事物，配置这个属性可以提高方法执行效率。
        - @Transactional(rollbackFor = {ArrayIndexOutOfBoundsException.class, NullPointerException.class})
            - 遇到方法抛出ArrayIndexOutOfBoundsException、NullPointerException两种异常会回滚数据，**仅支持RuntimeException的子类。**
        - @Transactional(noRollbackFor = {ArrayIndexOutOfBoundsException.class, NullPointerException.class})
            - 遇到ArrayIndexOutOfBoundsException、NullPointerException两种异常不会回滚数据，**同样也是仅支持RuntimeException的子类**
        - @Transactional(rollbackForClassName = {"NullPointerException"})、@Transactional(noRollbackForClassName = {"NullPointerException"})
            - 这里是通过字符串形式的名字来制定要回滚和不要回滚的异常。
        - @Transactional(timeout = 30)
            - 事物超时时间，单位为秒。
        - @Transactional(value = "tran_1")
        - value这个属性主要就是给某个事物一个名字而已，这样在别的地方就可以使用这个事物的配置。


### 单表事物管理
1. 批量插入100条数据，但是由于这100条数据之间存在一定的相关性，只要其中任何一条事物的插入失败，之前插入成功的数据就全部回滚
    - 使用MyBatis的批量插入功能(就是一条sql语句)
    - 使用Spring管理事物
    
### 多库/多表事务管理
1. 对单库/多库的两张表（Student表、Teacher表）同时插入一条数据，要么全部成功，要么全部失败，该如何处理
    - Dao层中的方法更多的是一种对数据库的增删改查的原子性操作，而Service层中的方法相当于对这些原子性的操作做一个组合，
    这里要同时操作TeacherDao、StudentDao中的insert方法
    