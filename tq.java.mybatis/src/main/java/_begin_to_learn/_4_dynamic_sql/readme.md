2018-06-13

## 动态SQL

### if
1. 能用"<![CDATA[ ... ]]>"尽量还是用，不过只包动态SQL外的内容。
2. test里面可以判断字符串、整型、浮点型，大胆地写判断条件吧。如果属性是复合类型，则可以使用A.B的方式去获取复合类型中的属性来进行比较。

### choose、when、otherwise
1. 两个when只能满足一个，都不满足则走other。还是注意一下这里的"<![CDATA[ ... ]]>"，不可以包围整个语句。

### trim、where、set
1. 因为很多时候我们需要where后面的子句都动态生成，而不是事先有一个where
    - 比如 select * from student where
    - 如果后续判断满足, 就会 变成 select * from student where and ... --> sql错误
2. **解决办法也有，一个讨巧的办法是用where 1 = 1的方式**

### foreach
1. item表示集合中每一个元素进行迭代时的别名，
1. index指 定一个名字，用于表示在迭代过程中，每次迭代到的位置，
1. open表示该语句以什么开始，
1. separator表示在每次进行迭代之间以什么符号作为分隔 符，
1. close表示以什么结束。
2. collection
    - 如果传入的是单参数且参数类型是一个List的时候，collection属性值为list
    - 如果传入的是单参数且参数类型是一个array数组的时候，collection的属性值为array
    - 如果传入的参数是多个的时候，我们就需要把它们封装成一个Map了，当然单参数也可