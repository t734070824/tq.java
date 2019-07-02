2019-07-02

## BitMap

### 原理用法
1. 8bit = 1 byte
2. 0 或者 1
3. 命令
    - setBit key offset value(0/1)
    - getBit key offset
    - bitCount key start end

### 优势 与 限制
1. 优势
    - bit 存储
    - set O(1), get O(n)
    - 二进制存储 位运算
    - 方便扩容
        - TODO
2. 限制
    - bit映射限制 512M, 所以最大 2^32(40亿+), 
    
### 使用场景
1. 用户的纵向扩展, 每个key记录业务属性状态, 每个uid 当做 offset, **超过 2^32 需要分片存储**
2. 视频属性的无线延伸
    - 描述
        - 亿级数量的短视频app
        - 视频有各种属性: 是否加锁, 是否特效
        - 需要做各种标记
    - 解决
        - 方案1
            - 主要
                - mysql
            - 问题
                - 业务属性一直在增加
                - 存在时间限制的属性
                - 直接对数据库字段进行加减非常不合理
                - 废弃字段回收不容易
        - 方案2
            - 主要
                - redis
                - 业务属性+uid
            - 问题
                - key的长度 都大于 value, 浪费
                - json 
                - 数据回收问题
        - 方案3
            - bitmap
            - 属性id+视频分片id
            - value 按照视频id对分片范围进行取模来决定偏移量 offset, 
        - 细节
            - 分片原因
                - 读取的时间复杂度和存储的多少有关
                - bitmap长度限制 2^32
            - 分片粒度如何衡量
                - id存在断层, 需要避免, 防止空间浪费, 单个分区key存储的 value
2. 用户在线状态
    - bitmap
    - 分片, 防止单个 key数据量太多, 影响查询效率
3. 统计活跃用户
    - 方案
        - 时间作为 key
        - id -- offset
        - bitop 进行二进制运算 计算某段时间范围内的活跃情况
        - 可以分片 也可以不分, 防止业务变复杂
    - 伪代码
        - status = 1
        - redis --> setBit("active_20190702", uid, status)
        - redis --> setBit("active_20190703", uid, status)
        - redis --> bitop("AND", "active", "active_20190703", uid, status)
4. 用户签到

### 坑
1. getBit()--> 返回一个指定key中位的值为1的个数**(是以byte为单位不是bit)**
    - 所以bitcount 0 0 那么就应该是第一个字节中1的数量的，注意是字节，**第一个字节也就是1,2,3,4,5,6,7,8这八个位置上**。

### 进阶用法
1. bitmap 空间压缩
    - 00000000000110000010001111110000000000001000
    - 压缩为 0 11 2 5 1 3 6 12 1 3
    - 第一位0 连续11个, 然后2个1, 5个0....
    - RLE (Run Length Encoding)