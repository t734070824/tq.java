package _begin_to_learn._5_transaction_spring;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author 734070824@qq.com
 * @date 2018/6/14 13:50
 */
@Service
public class SchoolServiceImpl implements SchoolService
{
    @Resource
    private StudentDao studentDao;

    @Resource
    private TeacherDao teacherDao;

    @Override
    public void insertTeacherAndStudent2(Teacher teacher, Student2 student) {
        insertTeacherAndStudent(teacher, student);
    }

    @Transactional
    public void insertTeacherAndStudent(Teacher teacher, Student2 student)
    {
        studentDao.insertStudent(student);
        teacherDao.insertTeacher(teacher);
    }
}