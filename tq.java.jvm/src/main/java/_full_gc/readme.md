2017-11-29

### 什么时候进行Full GC 

1. 悲观策略:在发生Minor GC之前，虚拟机会先检查老年代最大可用的连续空间是否大于新生代所有对象的总空间。
如果大于则进行Minor GC，如果小于则看HandlePromotionFailure设置是否允许担保失败（不允许则直接Full GC）。
如果允许，那么会继续检查老年代最大可用的连续空间是否大于历次晋升到老年代对象的平均大小，
如果大于则尝试Minor GC（如果尝试失败也会触发Full GC），如果小于则进行Full GC。
2. old空间不足，perm空间不足，调用方法System.gc() ，ygc时的悲观策略, dump live的内存信息时(jmap –dump:live)

