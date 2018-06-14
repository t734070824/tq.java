package _begin_to_learn._5_transaction_spring;

import java.util.List;

/**
 * @author 734070824@qq.com
 * @date 2018/6/14 11:34
 */
public interface TeacherDao
{
    public List<Teacher> selectAllTeachers();
    public int insertTeacher(Teacher teacher);
}