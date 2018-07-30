package _aop_sound_code_analyze._springaop_vs_aspectj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 734070824@qq.com
 * @date 2018/7/30 13:34
 */
public class App {

    @Test
    public void simple(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("_springaop_vs_aspectj/_1/applicationContext.xml");
        UserServiceImpl service = (UserServiceImpl) ac.getBean("proxyService");
        service.add();
    }



    @Test
    public void middle(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("_springaop_vs_aspectj/_2/applicationContext.xml");
        UserServiceImpl service = (UserServiceImpl) ac.getBean("userServiceImpl");
        service.add();
    }

    @Test
    public void aspectXml(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("_springaop_vs_aspectj/_3/applicationContext.xml");
        UserServiceImpl service = (UserServiceImpl) ac.getBean("userServiceImpl");
        service.add();
    }



    @Test
    public void aspectAnno(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("_springaop_vs_aspectj/_4/applicationContext.xml");
        UserServiceImpl service = (UserServiceImpl) ac.getBean("userServiceImpl");
        service.add();
    }



}
