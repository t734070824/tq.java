2018-03-05

## IO -- Select Poll Epoll 

### 疑问
1. 同步IO VS 异步IO
2. 阻塞IO VS 非阻塞IO

### 概念说明
1. 用户空间 与 内核空间
    - 操作系统的核心是内核，独立于普通的应用程序，可以访问受保护的内存空间，也有访问底层硬件设备的所有权限。
    为了保证用户进程不能直接操作内核（kernel），保证内核的安全，操心系统将虚拟空间划分为两部分，一部分为内核空间，一部分为用户空间
2. 进程切换
    - 为了控制进程的执行，内核必须有能力挂起正在CPU上运行的进程，并恢复以前挂起的某个进程的执行。
    这种行为被称为进程切换。因此可以说，任何进程都是在操作系统内核的支持下运行的，是与内核紧密相关的
3. 进程的阻塞
    - 正在执行的进程，由于期待的某些事件未发生，如请求系统资源失败、等待某种操作的完成、新数据尚未到达或无新工作做等，
    则由系统自动执行阻塞原语(Block)，使自己由运行状态变为阻塞状态
    - **进程自身的主动行为**
    - **只有处于运行态的进程(获取CPU执行时间), 才可以将其转为 阻塞状态**
    - **进程进入阻塞状态, 不占用 CPU资源**
4. 文件描述符fd
    - 一个索引值
    - 进程用于标识打开的文件的无符号整数
    - 表述指向文件的引用的抽象化概念
5. 缓存 I/O
    - 数据会先被拷贝到操作系统内核的缓冲区中，然后才会从操作系统内核的缓冲区拷贝到应用程序的地址空间
    - 数据在传输过程中需要在应用程序地址空间和内核进行多次数据拷贝操作，这些数据拷贝操作所带来的 CPU 以及内存开销是非常大的。

### Read操作发生
1. 等待数据准备(Waiting for the data to be ready)
2. 将数据从内核拷贝到进程中(Copying the data from the kernel to the process)

### IO 模式
1. 阻塞IO (Blocking IO)

    ![](https://github.com/t734070824/tq.java/blob/master/tq.java.linux/src/main/java/_io/1.jpg?raw=true)

    - 用户进程调用了recvfrom, kernel 进入等待数据阶段, 此时用户进程被阻塞
    - 数据准备好, 从 kernel 拷贝到 用户内存, 在拷贝的过程中, 用户进程依然被阻塞
    - 拷贝完成, kernel 返回结果, 用户进程解除 block状态, 运行
    - **blocking IO的特点就是在IO执行的两个阶段都被block了**

2. 非阻塞 I/O（nonblocking IO）

    ![](https://github.com/t734070824/tq.java/blob/master/tq.java.linux/src/main/java/_io/2.jpg?raw=true)
    
    - 用户read请求时, kernel并不会阻塞用户线程, 如果数据没有准备好, 返回 error, 
    - 用户进程 read之后,不等待, 判断结果,如果是 error, 再次 read
    - **一旦 kernel 数据准备好, 又再次收到 用户进程的 system call, 拷贝到 用户内存, 返回**
    - **nonblocking IO的特点是用户进程需要不断的主动询问kernel数据好了没有 --> 但用户进程并没有阻塞**
    
3. I/O 多路复用()IO multiplexing 又被称为“事件驱动”)

    ![](https://github.com/t734070824/tq.java/blob/master/tq.java.linux/src/main/java/_io/3.jpg?raw=true)

    - select/epoll的好处就在于**单个process就可以同时处理多个网络连接的IO**
    - 基本原理就是select，poll这个function会不断的轮询所负责的所有socket，当某个socket有数据到达了，就通知用户进程
    - epoll callBack //TODO
    - 操作系统的这个功能通过select/poll/epoll/kqueue之类的系统调用函数来使用，这些函数都可以同时监视多个描述符的读写就绪状况，
      这样，多个描述符的I/O操作都能在一个线程内并发交替地顺序完成，这就叫I/O多路复用，这里的“复用”指的是复用同一个线程
    - Reactor模式
    - 同步非阻塞模型
    - 当用户进程调用了select，那么整个进程会被block
    - 特点是通过一种机制一个进程能同时等待多个文件描述符，而这些文件描述符（套接字描述符）其中的任意一个进入读就绪状态，
        select()函数就可以返回
    
4. 异步 I/O(asynchronous IO)

    ![](https://github.com/t734070824/tq.java/blob/master/tq.java.linux/src/main/java/_io/4.jpg?raw=true)

    - 用户进程发起read操作之后，立刻就可以开始去做其它的事
    - 从kernel的角度，当它受到一个asynchronous read之后，首先它会立刻返回，所以不会对用户进程产生任何block
    - 然后，kernel会等待数据准备完成，然后将数据拷贝到用户内存，**当这一切都完成之后，kernel会给用户进程发送一个signal**，告诉它read操作完成了


### 总结

   ![](https://github.com/t734070824/tq.java/blob/master/tq.java.linux/src/main/java/_io/5.jpg?raw=true)

1. blocking和non-blocking的区别
    - 调用blocking IO会一直block住对应的进程直到操作完成，而non-blocking IO在kernel还准备数据的情况下会立刻返回。
2. synchronous IO和asynchronous IO的区别
    - synchronous IO:  A synchronous I/O operation causes the requesting process to be blocked until that I/O operation completes;
    - asynchronous IO: An asynchronous I/O operation does not cause the requesting process to be blocked;
    - synchronous IO做”IO operation”的时候会将process阻塞
        - blocking IO，non-blocking IO，IO multiplexing都属于synchronous IO。
    

   