2019-03-19

## 大文件传输

### 零拷贝，将文件数据直接从文件系统弄到网络堆栈

```java
FileInputStream in = new FileInputStream(file); //1
FileRegion region = new DefaultFileRegion(in.getChannel(), 0, file.length()); //2
channel.writeAndFlush(region).addListener(new ChannelFutureListener(){});
```

### 一块一块读写，不要一次把文件全部加载到内存

```java
ctx.writeAndFlush(new ChunkedStream(new FileInputStream(file)));
```