package _begin_to_learn._5_transaction_spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 734070824@qq.com
 * @date 2018/6/14 10:45
 */
public class StudentDaoImpl2Test {
    @Test
    public void selectAllStudents() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("_begin_to_learn/_5_transaction_spring/spring.xml");
        StudentDao studentDao = (StudentDao)ac.getBean("studentDaoImpl");

        Student2 student = new Student2();
        student.setStudentName("Lucy");

        int j = studentDao.insertStudent(student);
        System.out.println("j = " + j + "\n");

        System.out.println("-----Display students------");
        List<Student2> studentList = studentDao.selectAllStudents();
        for (int i = 0, length = studentList.size(); i < length; i++)
            System.out.println(studentList.get(i));
    }

    @Test
    public void insertStudent() throws Exception {
    }

    @Test
    public void batchInsertStudents() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("_begin_to_learn/_5_transaction_spring/spring.xml");
        StudentDao studentDao = (StudentDao)ac.getBean("studentDaoImpl");
        List<Student2> studentList = null;

        Student2 student0 = new Student2();
        student0.setStudentName("Smith");
        Student2 student1 = new Student2();
        student1.setStudentName(null);
        studentList = new ArrayList<>();
        studentList.add(student0);
        studentList.add(student1);
        studentDao.batchInsertStudents(studentList);


        System.out.println("-----Display students------");
        studentList = studentDao.selectAllStudents();
        for (int i = 0, length = studentList.size(); i < length; i++)
            System.out.println(studentList.get(i));
    }

}