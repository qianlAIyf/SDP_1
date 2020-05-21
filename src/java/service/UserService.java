package service;

import model.User;

public interface UserService {
    User getUser(String name);
    void setUser(User user);
}
