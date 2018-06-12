2018-06-12

## Sql映射

### 为什么要使用<![CDATA[ ... ]]>?
1. 就是student.xml本身是一个xml文件，它并不是专门为MyBatis服务的，它首先具有xml文件的语法
2. 它可以保证无论如何<![CDATA[ ... ]]>里面的内容都会被解析成SQL语句
3. 建议每一条SQL语句都使用<![CDATA[ ... ]]>包含起来，这也是一种规避错误的做法。

### # $
1. **使用"#"最重要的作用就是防止SQL注入**

### select
1. 多条件查询一个结果
    - select id="selectStudentByNameAndAge" parameterType="Student" resultType="Student"
    - select * from student where studentName = #{studentName} and studentAge = #{studentAge}
2. 查询多个结果
    - select id="selectAll" parameterType="int" resultType="Student" flushCache="false" useCache="true" 
    timeout="10000" fetchSize="100" statementType="PREPARED" resultSetType="FORWARD_ONLY"
        - resultType----**结果类型，注意如果返回结果是集合，应该是集合所包含的类型，而不是集合本身**
        - flushCache----将其设置为true，无论语句什么时候被调用，都会导致缓存被清空，默认值为false
        - useCache----将其设置为true，将会导致本条语句的结果被缓存，默认值为true
        - timeout----这个设置驱动程序等待数据库返回请求结果，并抛出异常事件的最大等待值，默认这个参数是不设置的（即由驱动自行处理）
        - fetchSize----这是设置驱动程序每次批量返回结果的行数，默认不设置（即由驱动自行处理）
        - statementType----STATEMENT、PREPARED或CALLABLE的一种，这会让MyBatis选择使用Statement、PreparedStatement或CallableStatement，默认值为PREPARED。
        - resultSetType----FORWARD_ONLY、SCROLL_SENSITIVE、SCROLL_INSENSITIVE中的一种，默认不设置（即由驱动自行处理）
    - select * from student where studentId > #{id};
3. 使用resultMap来接收查询结果
    - 提供一个 数据库字段到 Entity 的字段映射, 可以不在sql中使用as
    - **resultMap定义中主键要使用id**
    - **resultMap和resultType不可以同时使用** 

### insert
1. openSession默认设置 autoCommit = false; 所以记得 手动commit

### 重用的SQL代码段
1. **注意这里要把"<![CDATA[ ... ]]>"给去掉，否则"<"和">"就被当成SQL里面的小于和大于了，因此使用SQL的写法有一定限制，使用前要注意一下避免出错。**
```sql
  <sql id="insertColumns">
       studentName, studentAge, studentPhone
  </sql>
   
   <insert id="insertOneStudent" parameterType="Student" useGeneratedKeys="true" keyProperty="studentId">
       insert into student(<include refid="insertColumns" />) 
           values(#{studentName}, #{studentAge}, #{studentPhone});
   </insert>
```


### 




### QA
1. **在没有默认构造器的情况下**
    - 不会报错,  mybatis会寻找合适的构造器
    - 但是坑的时候 不许使用基本数据类型的包装类
    - eg: Student(int studentId, String studentName, int studentAge, String studentPhone)
            --> Student(Integer studentId, String studentName, Integer studentAge, String studentPhone)


    