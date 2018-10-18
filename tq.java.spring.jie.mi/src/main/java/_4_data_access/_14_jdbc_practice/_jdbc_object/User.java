package _4_data_access._14_jdbc_practice._jdbc_object;

/**
 * @author 734070824@qq.com
 * @date 2018/10/18 15:18
 */
public class User {

    public int id;
    public String name;
    public String password;
    public int age;
    public int deleteFlag;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}
