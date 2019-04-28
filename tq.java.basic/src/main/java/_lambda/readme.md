2019-04-28

## lambda

### 表达式
```java

public class Demo{
    public static void main(String[] args){
        //old
        new Thread(new Runnable() {
            public void run(){
                System.err.println("123");
            }
        }).start();
        
        //now
        new Thread(() -> System.err.println("123")).start();
        
        
        //排序
        List<String> list = java.util.Arrays.asList(new String[]{"a","b","c"});
        java.util.Collections.sort(list, new java.util.Comparator<String>() {
            public int compare(String s1, String s2){
                return s1.compareTo(s2);
            }
        });
        
        //now
        java.util.Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
    }
}
```

### 语法
```javascript

(Type1 param1, Type2 param2, ..., TypeN paramN) -> {
    statment1;
    statment2;
    //.............
    return statmentM;
}
```

1. lambda表达式可使用的变量
    - lambda表达式可以访问给它传递的变量，访问自己内部定义的变量，同时也能访问它外部的变量。
    - 不过lambda表达式访问外部变量有一个非常重要的限制：变量不可变（只是引用不可变，而不是真正的不可变）。
    - **所以编译器会隐式的把其当成final来处理**。
    
### this
1. 