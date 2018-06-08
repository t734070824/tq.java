package _begin_to_learn._1_basic;

import org.apache.ibatis.session.SqlSession;

/**
 * @author 734070824@qq.com
 * @date 2018/6/8 10:47
 */
public class StudentOperator extends BaseOperator
{
    private static StudentOperator instance = new StudentOperator();

    private StudentOperator()
    {

    }

    public static StudentOperator getInstance()
    {
        return instance;
    }

    public Student selectStudentById(int studentId)
    {
        SqlSession ss = ssf.openSession();
        Student student = null;
        try
        {
            student = ss.selectOne("1.selectStudentById", 1);
        }
        finally
        {
            ss.close();
        }
        return student;
    }
}
