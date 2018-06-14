package _begin_to_learn._5_transaction_spring;

import java.util.List;

/**
 * @author 734070824@qq.com
 * @date 2018/6/13 16:07
 */
public interface StudentDao
{
    public List<Student2> selectAllStudents();
    public int insertStudent(Student2 student);
    public int batchInsertStudents(List<Student2> studentList);
}
