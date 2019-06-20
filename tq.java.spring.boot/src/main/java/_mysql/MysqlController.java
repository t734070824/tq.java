package _mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 项目名:
 * 创建人:admin
 * 创建时间:2019/6/1815:04
 * 类名: MysqlController
 * 类描述:
 */

@RestController
@RequestMapping("/mydb")
public class MysqlController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MysqlService mysqlService;

    @RequestMapping("/getUsers")
    public List<Map<String, Object>> getDbType(){
        String sql = "select * from tq_user";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Map.Entry<String, Object>> entries = map.entrySet( );
            if(entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
                while(iterator.hasNext( )) {
                    Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
                    Object key = entry.getKey( );
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }
        return list;
    }

    /**
     *
     Create Table

     CREATE TABLE `tq_user` (
     `name` varchar(100) NOT NULL,
     `age` int(11) DEFAULT NULL,
     PRIMARY KEY (`name`)
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4

     * @param name
     * @param age
     * @return
     */
    @RequestMapping("/addUser/{name}/{age}")
    public String addUser(@PathVariable String name, @PathVariable Integer age){
        mysqlService.update(name, age);
        return "success";
    }


    @RequestMapping("/user/{id}")
    public Map<String,Object> getUser(@PathVariable String id){
        Map<String,Object> map = null;

        List<Map<String, Object>> list = getDbType();

        for (Map<String, Object> dbmap : list) {

            Set<String> set = dbmap.keySet();

            for (String key : set) {
                if(key.equals("id")){
                    if(dbmap.get(key).equals(id)){
                        map = dbmap;
                    }
                }
            }
        }

        if(map==null)
            map = list.get(0);
        return map;
    }
}