package _ioc._2_bean_factory;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App {

    @Test
    public void defaultListableBeanFactory(){
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory container = bindViaXMLFile(beanRegistry);
        FXNewsProvider newsProvider = (FXNewsProvider)container.getBean("djNewsProvider");
        System.err.println(newsProvider);
//        newsProvider.getAndPersistNews();
    }

    private static BeanFactory bindViaXMLFile(DefaultListableBeanFactory beanRegistry) {

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanRegistry);
        reader.loadBeanDefinitions("classpath:new-config.xml");
        return beanRegistry;
    }


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
