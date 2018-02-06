package _stack;

import java.io.Serializable;
import java.util.EmptyStackException;

public class SeqStack<T> implements Stack<T>, Serializable{

    private static final long serialVersionUID = -5413303117698554397L;

    /**
     * 栈顶指针,-1代表空栈
     */
    private int top=-1;

    /**
     * 容量大小默认为10
     */
    private int capacity=10;

    /**
     * 存放元素的数组
     */
    private T[] array;

    private int size;

    public SeqStack(int capacity){
        array = (T[]) new Object[capacity];
    }

    public SeqStack(){
        array= (T[]) new Object[this.capacity];
    }

    public int size() {
        return size;
    }



    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    @Override
    public void push(T data) {
        if(array.length == size)
            ensureCapacity(size * 2 + 1);
        array[++top] = data;
        size++;
    }

    @Override
    public T peek() {
        if(isEmpty()) throw  new EmptyStackException();
        return array[top];
    }

    @Override
    public T pop() {
        if(isEmpty()) throw  new EmptyStackException();
        size--;
        return  array[top--];
    }

    /**
     * 扩容的方法
     * @param capacity
     */
    public void ensureCapacity(int capacity) {
        //如果需要拓展的容量比现在数组的容量还小,则无需扩容
        if (capacity<size)
            return;

        T[] old = array;
        array = (T[]) new Object[capacity];
        //复制元素
        for (int i=0; i<size ; i++)
            array[i]=old[i];
    }
}
