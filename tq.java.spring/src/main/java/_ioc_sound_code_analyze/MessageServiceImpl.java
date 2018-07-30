package _ioc_sound_code_analyze;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author 734070824@qq.com
 * @date 2018/3/27 20:28
 */
public class MessageServiceImpl implements MessageService {


    public MessageServiceImpl() {
        System.err.println("ss");
    }

    @Transactional
    public String getMessage() {
        return "hello world";
    }
}