package _begin_to_learn._5_transaction_spring;

/**
 * @author 734070824@qq.com
 * @date 2018/6/14 11:33
 */
public class Teacher
{
    private int        teacherId;
    private String    teacherName;

    public int getTeacherId()
    {
        return teacherId;
    }

    public void setTeacherId(int teacherId)
    {
        this.teacherId = teacherId;
    }

    public String getTeacherName()
    {
        return teacherName;
    }

    public void setTeacherName(String teacherName)
    {
        this.teacherName = teacherName;
    }

    public String toString()
    {
        return "Teacher{teacherId:" + teacherId + "], [teacherName:" + teacherName + "}";
    }
}