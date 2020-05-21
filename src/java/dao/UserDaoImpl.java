package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public User getUser(String name) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        User user = session.get(User.class,name);
        tx.commit();
        session.close();
        return user;
    }

    @Override
    public List<User> getUsers() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "FROM User";
        Query query = session.createQuery(hql);
        List<User> users = query.getResultList();
        tx.commit();
        session.close();
        return users;
    }

    @Override
    public void setUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
    }

}
