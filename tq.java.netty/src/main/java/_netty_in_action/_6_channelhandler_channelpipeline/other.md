20180604

### 同时使用多个编码器
1. 只有在 pipeline最后的那个编码器起作用(pipeline的out从队列尾--头) 
2. 原因:
    1. encode在执行write(ctx, msg, promise)和一般的outHandler不一样, 有一个acceptOutboundMessage(msg)的判断
    2. 当第二次执行到 编码器的encode方法的时候, 你的msg的type是integer, 
        但是 现在的type经过上一个编码器已修改为 allocateBuffer(ctx, cast, preferDirect)
    