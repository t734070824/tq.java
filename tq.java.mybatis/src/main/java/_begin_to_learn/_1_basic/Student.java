package _begin_to_learn._1_basic;

/**
 * @author 734070824@qq.com
 * @date 2018/6/8 10:44
 */
public class Student
{
    private int        studentIds;
    private String     studentName;
    private int        studentAge;
    private String    studentPhone;

    public Student()
    {
        super();
    }


    public String toString()
    {
        return "StudentId:" + studentIds + "\tStudentName:" + studentName +
                "\tStudentAge:" + studentAge + "\tStudentPhone:" + studentAge;
    }
}
