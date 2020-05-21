package service.impl;

import dao.UserDao;
import model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.UserService;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @Override
    public User getUser(String name) {
        return userDao.getUser(name);
    }

    @Override
    public void setUser(User user) {
        userDao.setUser(user);
    }
}
