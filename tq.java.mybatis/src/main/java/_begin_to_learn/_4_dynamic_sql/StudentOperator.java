package _begin_to_learn._4_dynamic_sql;

import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author 734070824@qq.com
 * @date 2018/6/8 10:47
 */
public class StudentOperator extends BaseOperator
{
    private static StudentOperator instance = new StudentOperator();

    public static StudentOperator getInstance()
    {
        return instance;
    }

    private StudentOperator()
    {

    }

    public List<Student> selectInCondition(int id, String name)
    {
        SqlSession ss = ssf.openSession();
        List<Student> objects = null;
        try
        {
            objects = ss.selectList("2.selectInCondition",
                    new Student(id, name, 0, null));
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
        return objects;
    }

    public List<Student> updateStudentAgeById5(int id, int age)
    {
        SqlSession ss = ssf.openSession();
        List<Student> objects = null;
        try
        {
            ss.update("2.updateStudentAgeById5",
                    new Student(id, null, age, null));
            ss.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            ss.rollback();
        }
        finally
        {
            ss.close();
        }
        return objects;
    }

    public List<Student> dynamicForeach3Map1(int age, String name)
    {
        SqlSession ss = ssf.openSession();
        List<Student> objects = null;
        try
        {
            Map<String, Object> map = new HashMap<>();
            map.put("age", age);
            map.put("name", name);
             objects = ss.selectList("2.dynamicForeach3Map1",
                     map);
            ss.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            ss.rollback();
        }
        finally
        {
            ss.close();
        }
        return objects;
    }

    public List<Student> dynamicForeach3Map2(Map map)
    {
        SqlSession ss = ssf.openSession();
        List<Student> objects = null;
        try
        {
             ss.insert("2.dynamicForeach3Map2",
                     map);
            ss.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            ss.rollback();
        }
        finally
        {
            ss.close();
        }
        return objects;
    }

}
