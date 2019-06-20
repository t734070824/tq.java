package _mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 项目名:
 * 创建人:admin
 * 创建时间:2019/6/2010:24
 * 类名: OtherService
 * 类描述:
 */
@Service
public class OtherService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateAgain(String name, Integer age) {
        jdbcTemplate.update("insert into tq_user values (?,?)", 1, 1);
        jdbcTemplate.update("delete from tq_user where name = ?", name);
        jdbcTemplate.update("insert into tq_user values (?,?)", name, age);
        jdbcTemplate.update("insert into tq_user values (?,?)", name, age);
    }
}