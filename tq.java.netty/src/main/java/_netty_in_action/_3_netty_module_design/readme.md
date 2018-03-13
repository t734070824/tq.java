2018-01-23
                            ### ChannelFuture
                            1. 可以将ChanneFuture看做一个将来的操作的结果的占位符
                            2. 不可准确的预测什么时候执行,但可以肯定他一定会被执行
                            3. 所属同一个Channel的操作都被保证已它们被调用的顺序执行
                            
                            ### xxx is not a @Sharable handler, so can't be added or removed multiple times
                            - http://www.fanyeong.com/2016/10/24/netty-channelhandler%E4%BD%BF%E7%94%A8%E6%8A%A5%E9%94%99/
                            
                            ### 数据的 出站 与 入站
                            1. 出站 和 入站是相对的概念
                            2. 入站时, channelPipeline从头到尾.
                            3. 出站时, channelPipeline从尾到头.