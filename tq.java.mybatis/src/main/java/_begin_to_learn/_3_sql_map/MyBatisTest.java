package _begin_to_learn._3_sql_map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 734070824@qq.com
 * @date 2018/6/8 10:50
 */
public class MyBatisTest {

    public static void main(String[] args)
    {
        System.out.println(StudentOperator.getInstance().selectStudentById(1));
    }

    @Test
    public void selectStudentByNameAndAge(){
        Student para = new Student(0, null, 0, null);
        Student student = StudentOperator.getInstance().selectStudentByNameAndAge(para);
        System.err.println(student);
    }

    @Test
    public void selectAll() throws InterruptedException {
        List<Student> students = StudentOperator.getInstance().selectAll(1);
        System.err.println(students);

    }

    @Test
    public void insertOne(){

        SqlSession sqlSession = StudentOperator.ssf.openSession();
        try
        {
            sqlSession.insert("1.insertOneStudent", new Student(0, "ss", 26, "1121323"));
        } catch (Exception e){
            e.printStackTrace();
        }

        sqlSession.commit();
        sqlSession.close();
    }
}
