package _oom._memory_leak;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 734070824@qq.com
 * @date 2019/5/10 16:30
 */
public class HashSetMemoryLeak {

    public static void main(String[] args)
    {
        Set<Person> set = new HashSet<Person>();
        Person p1 = new Person("唐僧","pwd1",25);
        Person p2 = new Person("孙悟空","pwd2",26);
        Person p3 = new Person("猪八戒","pwd3",27);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:3 个元素!
        p3.setAge(2); //修改p3的年龄,此时p3元素对应的hashcode值发生改变

        set.remove(p3); //此时remove不掉，造成内存泄漏

        set.add(p3); //重新添加，居然添加成功
        System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:4 个元素!
        for (Person person : set)
        {
            System.out.println(person);
        }
    }

    static class Person{
        String name;
        String pass;
        int age;

        public Person(String name, String pass, int age) {
            this.name = name;
            this.pass = pass;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (age != person.age) return false;
            if (name != null ? !name.equals(person.name) : person.name != null) return false;
            return pass != null ? pass.equals(person.pass) : person.pass == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (pass != null ? pass.hashCode() : 0);
            result = 31 * result + age;
            return result;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
