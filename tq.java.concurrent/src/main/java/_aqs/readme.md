2017-11-21

## AQS(AbstractQueuedSynchronizer)

### setHead
1. setHead方法里面的前驱Node是Null，也没有线程，那么为什么不用一个在等待的线程作为Head Node呢?
    - 因为一个线程随时有可能因为中断而取消，而取消的话，Node自然就要被GC了，那GC前必然要把头Node的后继Node变为一个新的头而且要应对多种情况，这样就很麻烦。
	- 用一个没有thread的Node作为头，相当于起了一个引导作用，因为head没有线程，自然也不会被取消。