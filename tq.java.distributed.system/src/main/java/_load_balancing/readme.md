2019-06-01

## 负载均衡

### 算法
1. 随机：
    - 负载均衡方法随机的把负载分配到各个可用的服务器上，通过随机数生成算法选取一个服务器，然后把连接发送给它。
    - 虽然许多均衡产品都支持该算法，但是它的有效性一直受到质疑，除非把服务器的可运行时间看的很重。
1. 轮询：
    - 轮询算法按顺序把每个新的连接请求分配给下一个服务器，最终把所有请求平分给所有的服务器。
    - 轮询算法在大多数情况下都工作的不错，但是如果负载均衡的设备在处理速度、连接速度和内存等方面不是完全均等，那么效果会更好。
1. 加权轮询：
    - 该算法中，每个机器接受的连接数量是按权重比例分配的。
    - 这是对普通轮询算法的改进，比如你可以设定：第三台机器的处理能力是第一台机器的两倍，
        那么负载均衡器会把两倍的连接数量分配给第3台机器。
1. 动态轮询：
    - 类似于加权轮询，但是，权重值基于对各个服务器的持续监控，并且不断更新。
    - 这是一个动态负载均衡算法，基于服务器的实时性能分析分配连接，比如每个节点的当前连接数或者节点的最快响应时间等。
1. 最快算法：
    - 最快算法基于所有服务器中的最快响应时间分配连接。
    - 该算法在服务器跨不同网络的环境中特别有用。
1. 最少连接：
    - 系统把新连接分配给当前连接数目最少的服务器。
    - 该算法在各个服务器运算能力基本相似的环境中非常有效。
1. 观察算法：
    - 该算法同时利用最小连接算法和最快算法来实施负载均衡。
    - 服务器根据当前的连接数和响应时间得到一个分数，分数较高代表性能较好，会得到更多的连接。
1. 预判算法：
    - 该算法使用观察算法来计算分数，但是预判算法会分析分数的变化趋势来判断某台服务器的性能正在改善还是降低。
    - 具有改善趋势的服务器会得到更多的连接。该算法适用于大多数环境。