package dao.interf;

import model.User;

import java.util.List;

public interface UserDao {
    User getUser(String name);//根据用户名，返回用户对象
    List<User> getUsers();//获取数据库中所有的对象
    void setUser(User user);//更改用户信息
}
