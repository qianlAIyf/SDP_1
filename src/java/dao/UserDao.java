package dao;

import model.User;

public interface UserDao {
    User getUser(String name);
    void setUser(User user);
}
