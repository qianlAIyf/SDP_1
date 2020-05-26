package dao.impl;

import dao.interf.ModelDao;
import model.Model;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ModelDaoImpl implements ModelDao {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;
    @Override
    public boolean renameModel(Model model) {
        return false;
    }

    @Override
    public boolean deleteModel(Model model) {
        return false;
    }

    @Override
    public List<Model> getModels(int user_id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "FROM Model M WHERE M.userId = userId";
        Query query = session.createQuery(hql);
        List<Model> models = query.getResultList();
        tx.commit();
        session.close();
        return models;
    }

    @Override
    public Model getModel(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Model model = session.get(Model.class, id);
        tx.commit();
        session.close();
        return model;
    }

    @Override
    public boolean saveModel(Model model) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(model);

        session.getTransaction().commit();
        session.close();
        return true;
    }
}
