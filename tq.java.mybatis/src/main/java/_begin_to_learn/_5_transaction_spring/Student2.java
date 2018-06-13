package _begin_to_learn._5_transaction_spring;

/**
 * @author 734070824@qq.com
 * @date 2018/6/13 16:03
 */
public class Student2 {

    private int        studentId;
    private String    studentName;

    public int getStudentId()
    {
        return studentId;
    }

    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public String toString()
    {
        return "Student{[studentId:" + studentId + "], [studentName:" + studentName + "]}";
    }
}
