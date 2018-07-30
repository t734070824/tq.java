package _aop_sound_code_analyze._springaop_vs_aspectj;

import org.springframework.stereotype.Component;

/**
 * @author 734070824@qq.com
 * @date 2018/7/30 11:37
 */
@Component
public class UserServiceImpl {

    public void add(){
        System.err.println("add");
    }
}
