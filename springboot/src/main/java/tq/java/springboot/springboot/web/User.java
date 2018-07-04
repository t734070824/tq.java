package tq.java.springboot.springboot.web;

/**
 * @author 734070824@qq.com
 * @date 2018/7/4 17:29
 */
public class User {

    private Long id;
    private String name;
    private Integer age;

    // 省略setter和getter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
