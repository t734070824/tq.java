218-06-25

## 修饰符
1. public的类、类属变量及方法，包内及包外的任何类均可以访问；
1. protected的类、类属变量及方法，包内的任何类，**及包外的那些继承了此类的子类才能访问**；
1. private的类、类属变量及方法，**包内包外的任何类均不能访问**；
1. 如果一个类、类属变量及方法不以这三种修饰符来修饰，它就是friendly类型的，
    那么包内的任何类都可以访问它，**而包外的任何类都不能访问它(包括包外继承了此类的子类)**，因
    此，这种类、类属变量及方法对包内的其他类是友好的，开放的，而对包外的其他类是关闭的。