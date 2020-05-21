package service;

import model.User;

import java.util.List;

public interface UserService {
    User getUser(String name);
    List<User> getUsers();
    void setUser(User user);
}
