2018-05-30

## 异常

### 概念
1. Throwable
    - 所有错误或异常的超类, 两个子类
    - Error
        - 不应该捕捉的严重问题
        - 内存溢出, 虚拟机错误, 栈溢出
        - OOM, StackOverflowError, 
    - Exception
        - 合理的引用程序需要捕捉的错误
        - RunTimeException
            - Exception类的子类
            - 在 Java 虚拟机正常运行期间抛出的异常的超类。可能在执行方法期间抛出但未被捕获的RuntimeException 的任何子类都无需在 throws 子句中进行声明
            - NullPointerException, ClassCastException, ArrayIndexOutOfBoundsException
        - IOException
            - Exception类的子类
2. error, Exceprion
    - Error和RuntimeException及其子类称为未检查异常（Unchecked exception），其它异常成为受检查异常（Checked Exception）

2. try-catch-finally-return执行顺序
    - tq.java\tq.java.basic\src\main\java\_finally
    