package _ityouknow._redis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author 734070824@qq.com
 * @date 2019/5/20 16:07
 */

@RestController
public class SessionController {

    @RequestMapping("/uid")
    public String uid(HttpSession session){
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}
