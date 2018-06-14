package _begin_to_learn._5_transaction_spring;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author 734070824@qq.com
 * @date 2018/6/13 16:06
 */
public class MyBatisUtil
{
    protected static SqlSessionFactory ssf;
    protected static Reader reader;

    static
    {
        try
        {
            reader = Resources.getResourceAsReader("_begin_to_learn/_5_transaction_spring/config.xml");
            ssf = new SqlSessionFactoryBuilder().build(reader);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    protected SqlSession getSqlSession()
    {
        return ssf.openSession();
    }
}