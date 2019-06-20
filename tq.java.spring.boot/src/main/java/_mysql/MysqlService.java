package _mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 项目名:
 * 创建人:admin
 * 创建时间:2019/6/1816:03
 * 类名: MysqlService
 * 类描述:
 */

@Service
public class MysqlService {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private OtherService otherService;



    @Transactional
    public void update(String name, Integer age) {
        jdbcTemplate.update("insert into tq_user values (?,?)", name, age);
        otherService.updateAgain(name, age);
    }



}