package dao;

import model.User;

import java.util.List;

public interface UserDao {
    User getUser(String name);
    List<User> getUsers();
    void setUser(User user);
}
