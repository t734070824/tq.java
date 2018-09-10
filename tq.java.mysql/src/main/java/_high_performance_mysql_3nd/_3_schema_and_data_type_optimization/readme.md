2018-09-10

## Schema与数据类型优化

### 选择优化的数据类型
1. 尽量使用可以正确存储数据的最小数据类型
    - 更小的数据类型通常占用更小的磁盘, 内存, CPU
2. 简单就好
    - 整数类型比字符串操作代价更低
    - 使用Mysql内建的类型(date, time, dateTime)而不是字符串表示日期
    - 使用整型存储IP
3. 尽量避免使用null
    - mysql难以优化
    - 避免在可能为null的列建立索引
4. 选择具体类型
    - TimeStamp VS DataTime
    
### 整数类型
1. 整数
    - TinyInt(8), SmallInt(16), MediumInt(24), Int(32), BigInt(64)
    - 存储范围 -2(N-1) 到 2(N-1)-1
    - Unsigned: 不允许负值
        - 存储内容大致上升一倍
    - 为整数类型指定宽度
        - Int(11), 不会限制值的合法范围
        - 对于存储和计算来说, Int(1) 和 Int(20) 是相同的
2. 实数
    - Float
    - Double
    - Decimal
    - 可以将小数乘以一个响应的倍数, 保存为整数存储
    
### 字符串类型(InnoDB/MyISAM)
1. VarChar  Char
    - VarChar
        - 可变长字符串(无法超过最大长度)
        - 仅适用必要的空间(越短的字符串使用越少的空间), 但是 ROW_Format=FIXED
        - 使用1/2额外个字节记录字符串的长度
            - 列的最长长度<=255byte --> 1
        - 缺点
            - 由于行的变长,在Update的时候可能是行变的更长, 但是页内没有更多的空间存储, **Innodb需要分裂页使行可以放进页内**
            - Innodb会把过长的Varchar存储为 Blob;???
        - 适用于
            - 字符串的最大长度比平均长度大得多
            - 列的更新较少
    - Char
        - 定长的
        - 根据需要填充空格以方便比较
        - 适用于
            - 很短的 或者是 所有值都接近同一个长度
            - 经常变更的, 不容易产生碎片
3. Binary VarBinary
    - 二进制字符串
    - 存储字节码而不是字符
    - 填充Binary使用 \0(零字节)
    - 比较Binary字符串, 因为每次按一个字节, 速度较快
4. Blob  VS  TEXT
    - Blod
        - 二进制
        - TinyBlob, SmallBlob, MediumBlob, IntBlob, BigBlob
    - TEXT
        - 字符
        - TinyText, SmallText, MediumText, IntText, BigText
    - 共同点
        - 存储很大数据而设计的字符串数据类型
        - 排序 只对每个列最前的 max_sort_lenght 字节而不是整个字符串排序
        - 不能将这种列全部长度的字符串进行索引, 也不能使用这些索引消除排序???