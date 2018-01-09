package _ioc._2_bean_factory;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App {


    @Test
    public void xmlBeanFactory(){
        BeanFactory container = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        Object bean = container.getBean("djNewsProvider");
        System.err.println(bean);
    }


    @Test
    public void classPathBeanFactory(){
        BeanFactory container = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object bean = container.getBean("djNewsProvider");
        System.err.println(bean);
    }

}
