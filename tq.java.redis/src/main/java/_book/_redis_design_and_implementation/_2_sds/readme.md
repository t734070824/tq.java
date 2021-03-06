2018-04-19

## SDS(简单动态字符串)

### 定义
1. len
    - 记录buf数组中已使用字节的数量
    - SDS 所保存的字符串长度
2. free
    - buf数组中未使用的字节数量
3. buf[]
    - 字节数组, 保存字符串
    
### 特点
1. 空字符 '\0' 作为最后一个字符, 不计入 len 中
2. 常数复杂度 获取 字符串长度
3. 杜绝缓冲区溢出
    - 空间自动扩展
4. 减少修改字符串是带来的内存重分配次数
    - 空间预分配
        - len = len + x.len
        - len 小于 1MB
            - free = len
            - size = free + len + 1
        - len 大于 1Mb
            - free = 1MB
            - size = len + free + 1byte
    - 惰性空间释放
        - 缩短后多出来的字节, free记录, 等待使用
        - 需要时释放
5. 二进制安全
    - 使用len判断字符串是否结束