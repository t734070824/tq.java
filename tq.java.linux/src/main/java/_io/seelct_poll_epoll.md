2018-07-20

## Select poll Epoll

### 公共
1. 都是IO多路复用的机制
2. 本质上都是同步IO, 都需要在读写事件就绪后自己负责进行读写
3. 

### select
1. int select (int n, fd_set *readfds, fd_set *writefds, fd_set *exceptfds, struct timeval *timeout);
2. 见识3类描述符, readfds-有数据可读, writefds-有数据可写, 有 except, 或超时
3. 调用 select()函数 阻塞, 直到有描述符就绪
4. 当select函数返回后，可以 **通过遍历fdset**，来找到就绪的描述符
5. 缺点: 单个进程能够监视的文件描述符的数量存在最大限制，在Linux上一般为1024

### poll
1. int poll (struct pollfd *fds, unsigned int nfds, int timeout)
    - pollfd
        - int fd;
            - 文件描述符
        - short events;      
            - 等待的事件
            - 监控文件描述符的事件掩码
            - 用户来设置这个域
        - short revents; 
            - 实际发生了的事件
            - 文件描述符的操作结果事件掩码
            - 内核在调用返回时设置这个域
2. 并没有最大数量限制（但是数量过大后性能也是会下降）
3. 和select函数一样，poll返回后，**需要轮询pollfd来获取就绪的描述符**


### epoll
1. 操作过程
    - int epoll_create(int size)；//创建一个epoll的句柄，size用来告诉内核这个监听的数目一共有多大
    - int epoll_ctl(int epfd, int op, int fd, struct epoll_event *event)；
    - int epoll_wait(int epfd, struct epoll_event * events, int maxevents, int timeout);
2. int epoll_create(int size)
    - 参数size并不是限制了epoll所能监听的描述符最大个数，只是对内核初始分配内部数据结构的一个建议
3. int epoll_ctl(int epfd, int op, int fd, struct epoll_event *event)
    - epoll的事件注册函数。
    - 对指定描述符fd执行op操作
    - epfd：是epoll_create()的返回值
    - op：表示op操作，用三个宏来表示：添加 EPOLL_CTL_ADD，删除 EPOLL_CTL_DEL，修改 EPOLL_CTL_MOD。分别添加、删除和修改对fd的监听事件
    - fd：是需要监听的fd（文件描述符）
    - epoll_event：是告诉内核需要监听什么事件
        - struct epoll_event {__uint32_t events;  epoll_data_t data; };
        - events
            - EPOLLIN: 表示对应文件描述符可以读(包括对端SOCKET正常关闭)
            - EPOLLOUT: 表示对应的文件描述符可以写
            - EPOLLPRI：表示对应的文件描述符有紧急的数据可读（这里应该表示有带外数据到来）；
            - EPOLLERR：表示对应的文件描述符发生错误；
            - EPOLLHUP：表示对应的文件描述符被挂断；
            - EPOLLET： 将EPOLL设为边缘触发(Edge Triggered)模式，这是相对于水平触发(Level Triggered)来说的。
            - EPOLLONESHOT：只监听一次事件，当监听完这次事件之后，如果还需要继续监听这个socket的话，需要再次把这个socket加入到EPOLL队列里
4. int epoll_wait(int epfd, struct epoll_event * events, int maxevents, int timeout)
    - 等待epfd上的io事件，最多返回maxevents个事件
    - 参数timeout是超时时间（毫秒，0会立即返回，-1将不确定，也有说法说是永久阻塞）
    
### Epoll 工作模式
1. LT(level trigger) 水平模式 默认
    - 当epoll_wait检测到描述符事件发生并将此事件通知应用程序，**应用程序可以不立即处理该事件**。
        下次调用epoll_wait时，会再次响应应用程序并通知此事件
2. ET(edge trigger) 边缘模式 
    - 当epoll_wait检测到描述符事件发生并将此事件通知应用程序，**应用程序必须立即处理该事件**。
        如果不处理，下次调用epoll_wait时，不会再次响应应用程序并通知此事件
    - 高速工作方式
    
### Epoll 总结
1. epoll事先通过epoll_ctl()来注册一 个文件描述符
2. 此处去掉了遍历文件描述符，而是通过监听回调的的机制
3. 当进程调用epoll_wait() 时便得到通知