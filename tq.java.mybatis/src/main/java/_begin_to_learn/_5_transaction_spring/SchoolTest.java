package _begin_to_learn._5_transaction_spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 734070824@qq.com
 * @date 2018/6/14 13:51
 */
public class SchoolTest {

    @Test
    public void insertTeacherAndStudent(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("_begin_to_learn/_5_transaction_spring/spring.xml");
        SchoolService schoolService =
                (SchoolService)ac.getBean("schoolServiceImpl");

//        Student2 student = new Student2();
//        student.setStudentName("Billy");
//        Teacher teacher = new Teacher();
//        teacher.setTeacherName("Luna");

        Student2 student = new Student2();
        student.setStudentName("White");
        Teacher teacher = new Teacher();
        teacher.setTeacherName(null);

        schoolService.insertTeacherAndStudent(teacher, student);
    }
}
