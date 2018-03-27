package _spring_jie_mi._review_20180327._2_part_IOC;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * list 注入
 * @author 734070824@qq.com
 * @date 2018/3/27 19:57
 */
public class ListApp {

    private List para1;
    private Integer[] para2;
    private List para3;
    private String[] para4;

    public static void main(String[] args) {
        BeanFactory container = new ClassPathXmlApplicationContext("applicationContext.xml");
        ListApp app = (ListApp) container.getBean("listApp");
        System.err.println(app);


        /** 无法转换为 Array对应的数据类型 报错
         *    <property name="para2">
         *     <list>
         *     <value> "456" </value>
         *     <value> 123 </value>
         *       </list>
         *   </property>
         */


        /**同一个类型 多个对象
         *  expected single matching bean but found 2: listApp,listApp2
         */
        ListApp bean = container.getBean(ListApp.class);
        System.err.println(bean);

        /**
         * map
         * <property name="mapping">
         *  <map>
         *  <entry key="strValueKey">
         *  <value>something</value>
         *  </entry>
         *  <entry>
         *  <key>objectKey</key>
         *  <ref bean="someObject"/>
         *  </entry>
         *  <entry key-ref="lstKey">
         *  <list>
         *  </list> .
         *  </entry>
         *  ...
         *  </map>
         *  </property>
         */
    }

    public List getPara1() {
        return para1;
    }

    public void setPara1(List para1) {
        this.para1 = para1;
    }

    public Integer[] getPara2() {
        return para2;
    }

    public void setPara2(Integer[] para2) {
        this.para2 = para2;
    }

    public List getPara3() {
        return para3;
    }

    public void setPara3(List para3) {
        this.para3 = para3;
    }

    public String[] getPara4() {
        return para4;
    }

    public void setPara4(String[] para4) {
        this.para4 = para4;
    }
}
