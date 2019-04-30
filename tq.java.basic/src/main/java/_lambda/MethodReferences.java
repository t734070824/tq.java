package _lambda;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * 方法引用
 * @author 734070824@qq.com
 * @date 2019/4/29 10:23
 */
public class MethodReferences {

    //构造器引用 无惨构造器
    private Person conRef(Supplier<Person> sub){
        return sub.get();
    }

    @Test
    public void testConRef(){
        Person p = conRef(Person::new);
    }





    private class Person{}

}
