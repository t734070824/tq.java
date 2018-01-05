package _begin_to_learn._dao;

import _begin_to_learn._entity.User;

import java.util.List;


public interface UserDao {

    public void insert(User user);

    public User findUserById (int userId);

    public List<User> findAllUsers();

}