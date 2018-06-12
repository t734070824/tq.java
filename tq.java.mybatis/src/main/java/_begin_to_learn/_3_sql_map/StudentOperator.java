package _begin_to_learn._3_sql_map;

import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    public Student selectStudentByNameAndAge(Student para)
    {
        SqlSession ss = ssf.openSession();
        Student student = null;
        try
        {
            student = ss.selectOne("1.selectStudentByNameAndAge", para);
        }
        finally
        {
            ss.close();
        }
        return student;
    }

    public List<Student> selectAll(int id)
    {
        SqlSession ss = ssf.openSession();
        List<Student> objects = null;
        try
        {
            objects = ss.selectList("1.selectAll", id);
            System.err.println(objects);
            TimeUnit.SECONDS.sleep(10);
            objects = ss.selectList("1.selectAll", id);
            System.err.println(objects);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally
        {
            ss.close();
        }
        return objects;
    }

    public void insertOneStudent(String studentName, int studentAge, String studentPhone)
    {
        SqlSession ss = ssf.openSession();
        try
        {
            ss.insert("1.insertOneStudent",
                    new Student(0, studentName, studentAge, studentPhone));
            ss.commit();
        }
        catch (Exception e)
        {
            ss.rollback();
        }
        finally
        {
            ss.close();
        }
    }
}
