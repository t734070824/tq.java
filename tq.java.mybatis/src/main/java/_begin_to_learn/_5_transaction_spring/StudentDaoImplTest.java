package _begin_to_learn._5_transaction_spring;

import org.junit.Test;

import java.util.List;

/**
 * @author 734070824@qq.com
 * @date 2018/6/14 10:45
 */
public class StudentDaoImplTest {
    @Test
    public void selectAllStudents() throws Exception {
        StudentDao studentDao = new StudentDaoImpl();

        Student2 student = new Student2();
        student.setStudentName("Jack");

        studentDao.insertStudent(student);
        System.out.println("插入的主键为：" + student.getStudentId());

        System.out.println("-----Display students------");
        List<Student2> studentList = studentDao.selectAllStudents();
        for (int i = 0, length = studentList.size(); i < length; i++)
            System.out.println(studentList.get(i));
    }

    @Test
    public void insertStudent() throws Exception {
    }

}