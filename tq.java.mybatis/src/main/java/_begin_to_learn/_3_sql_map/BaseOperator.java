package _begin_to_learn._3_sql_map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author 734070824@qq.com
 * @date 2018/6/8 10:46
 */
public class BaseOperator
{
    public static SqlSessionFactory ssf;
    public static Reader reader;

    static
    {
        try
        {
            reader = Resources.getResourceAsReader("_begin_to_learn/_3_sql_map/config.xml");
            ssf = new SqlSessionFactoryBuilder().build(reader);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
