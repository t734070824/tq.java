package _begin_to_learn._dao;

import _begin_to_learn._entity.User;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;


public interface UserDao {

    public int insert(User user);

    public User findUserById (int userId);

    public User findUserById2 (int userId);

    public List<User> findAllUsers();

    @MapKey("age")
    public Map<Integer, User> findAllUsersMap();

}