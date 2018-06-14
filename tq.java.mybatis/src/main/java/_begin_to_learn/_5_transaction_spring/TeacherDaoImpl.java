package _begin_to_learn._5_transaction_spring;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 734070824@qq.com
 * @date 2018/6/14 11:34
 */
@Repository
public class TeacherDaoImpl extends SqlSessionDaoSupport implements TeacherDao
{
    private static final String NAMESPACE = "2.";

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
    {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public List<Teacher> selectAllTeachers()
    {
        return getSqlSession().selectList(NAMESPACE + "selectAllTeachers");
    }

    public int insertTeacher(Teacher teacher)
    {
        return getSqlSession().insert(NAMESPACE + "insertTeacher", teacher);
    }
}
