package _begin_to_learn._5_transaction_spring;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author 734070824@qq.com
 * @date 2018/6/13 16:07
 */
public class StudentDaoImpl extends MyBatisUtil implements StudentDao
{
    private static final String NAMESPACE = "2.";

    public List<Student2> selectAllStudents()
    {
        SqlSession ss = getSqlSession();
        List<Student2> list = ss.selectList(NAMESPACE + "selectAllStudents");
        ss.close();
        return list;
    }

    public int insertStudent(Student2 student)
    {
        SqlSession ss = getSqlSession();
        int i = ss.insert(NAMESPACE + "insertStudent", student);
        // ss.commit();
        ss.close();
        return i;
    }
}
