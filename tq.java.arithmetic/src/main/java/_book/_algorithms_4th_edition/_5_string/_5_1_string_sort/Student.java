package _book._algorithms_4th_edition._5_string._5_1_string_sort;

/**
 * @author 734070824@qq.com
 * @date 2018/9/6 17:02
 */
public class Student {

    private String name;
    private int key;

    public Student(String name, int key) {
        this.name = name;
        this.key = key;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", key=" + key +
                '}';
    }

    public int key(){
        return key;
    }
}

