package _begin_to_learn._4_dynamic_sql;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 734070824@qq.com
 * @date 2018/6/8 10:50
 */
public class MyBatisTest {

    @Test
    public void selectInCondition(){
        List<Student> students = StudentOperator.getInstance().selectInCondition(1, "tq");
        System.err.println(students);
    }

    @Test
    public void updateStudentAgeById5(){
        StudentOperator.getInstance().updateStudentAgeById5(2, 0);
    }

    @Test
    public void dynamicForeach3Map1(){
        System.err.println(StudentOperator.getInstance().dynamicForeach3Map1(1,"22"));
    }
    @Test
    public void dynamicForeach3Map2(){

        Map map = new HashMap();
        map.put("table", "student");
        List l = new ArrayList();
        l.add(new Student(0, "0_1", 0, "0_1"));
        l.add(new Student(0, "0_2", 0, "0_1"));
        l.add(new Student(0, "0_3", 0, "0_1"));
        l.add(new Student(0, "0_4", 0, "0_1"));
        map.put("ids", l);
        System.err.println(StudentOperator.getInstance().dynamicForeach3Map2(map));
    }


}
