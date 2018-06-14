package _begin_to_learn._5_transaction_spring;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 734070824@qq.com
 * @date 2018/6/13 16:07
 */

@Repository
public class StudentDaoImpl extends SqlSessionDaoSupport implements StudentDao
{
    private static final String NAMESPACE = "2.";

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
    {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public List<Student2> selectAllStudents()
    {
        return getSqlSession().selectList(NAMESPACE + "selectAllStudents");
    }

    public int insertStudent(Student2 student)
    {
        return getSqlSession().insert(NAMESPACE + "insertStudent", student);
    }

    public int batchInsertStudents(List<Student2> studentList)
    {
        return getSqlSession().insert(NAMESPACE + "batchInsert", studentList);
    }
}
