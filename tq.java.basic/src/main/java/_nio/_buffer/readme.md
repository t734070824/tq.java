2018-12-24

## ByteBuffer

### 属性
1. Capacity
    - 容量
    - 创建时被设定, 不能改变
2. Limit
    - 数据的总数, **可读或者可写的总数**
3. Position
    - 下一个要被读或者被写的元素的位置, 由相应的get和put函数更新
4. Mark
    - 标记, 一个备忘位置
        - mark = position
    - reset
        - position = mark
    
### get()
1. 不 flip(), 直接get()
    - nextGetIndex = (position++)
    - 会获取put位置的下一个元素
    
### flip()
1. 想在一个Buffer中放入了数据，然后想从中读取的话，就要把position调到想读的那个位置才行
    - limit(position)
    - position = 0
2. 