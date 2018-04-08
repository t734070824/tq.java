package _aop_sound_code_analyze;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 734070824@qq.com
 * @date 2018/4/8 16:46
 */
public class TestAop {

    @Test
    public void testAop() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");

        Dao dao = (Dao)ac.getBean("daoImpl");
        dao.select();
    }
}
