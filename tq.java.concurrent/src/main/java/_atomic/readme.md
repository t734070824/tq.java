2018-02-01

### AtomicReferenceFieldUpdater
1. 通过**反射**原子更新对象的字段,既然他们的作用是更新字段我们知道有些类型的字段是不可被更新的，所以被更新的字段是有一定的
2. 底层还是通过 unsafe
3. 3个参数 **包含该字段的对象的类 将被更新的对象的类  将被更新的字段的名称** 

### 要求
1. 必须是volatile类型（volatile是线程可见变量，保存在Jvm的主内存中，而不是线程的工作内存里面），
2. 字段的描述类型（修饰符public/protected/default/private）是调用者与操作对象字段的关系一致，
3. 只能是实例变量，不能是类变量，也就是说不能加static关键字，
4. 只能是可修改变量，不能使final变量，因为final的语义就是不可修改。实际上final的语义和volatile是有冲突的，这两个关键字不能同时存在，
5. 对于AtomicIntegerFieldUpdater和AtomicLongFieldUpdater只能修改int/long类型的字段，不能修改其包装类型（Integer/Long）。如果要修改包装类型就需要使用AtomicReferenceFieldUpdater。