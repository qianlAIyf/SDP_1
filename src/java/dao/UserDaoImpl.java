package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserDaoImpl implements UserDao{
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public User getUser(String name) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class,name);
        return user;
    }

    @Override
    public void setUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

}
