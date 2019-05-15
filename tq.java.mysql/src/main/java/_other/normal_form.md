2019-05-13

## 范式

### 1NF 第一范式
1. 每一列都是不可分割的基本数据项
    - 不可分割(只表达一种意思)
    - 不能有重复的属性
    - 举例
        - Student(stuNo, stuName, age, age, sex)
            - 多个 age
            - Student(stuNo, stuName, age, sex)
        - Studeng(stuNo, stuName, age, phone, sex)
            - phone 可能有手机号码 或者 是 家庭号码
            - Studeng(stuNo, stuName, age, phone, honePhone, sex)

2. 2NF 第二范式
    - 属性完全依赖于主键
        - 每个实例或者行必须可以被唯一区分
        - 不可以存在 仅依赖主关键字一部分的属性
    - 建立在 1NF 的基础上
    - 举例
        - StuGrade(stuNo, stuName, age, sex, courseNo, courseName, credit, score)
            - stuNo --> stuName
            - courseNo --> courseName
            - 存在部分依赖
            - 修改为
                - Studnet(stuNo,stuName,age,sex)
                - Course(courseNo,courseName,credit)
                - StuGrade(stuNo,courseNo,score)

3. 3NF 第三范式
    - 同时满足 2NF 1NF
    - **非主键列是直接依赖于主键，还是直接依赖于非主键列。**
    - 第三范式（3NF）要求一个数据库表中不包含已在其它表中已包含的非主关键字信息。
    - 属性不依赖于其它非主属性 [ 消除传递依赖 ]


### 总结
1. 数据库表之间的连接会带来一部分的性能损失
2. 并不是数据表的范式越高越好
3. 有时会在数据冗余以及范式之间做出权衡
    - **在实际的数据库开发过程中，往往会允许一部分的数据冗余来减少数据库表之间连接。**