package dao.impl;

import dao.interf.DatasetDao;
import model.Dataset;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DatasetDaoImpl implements DatasetDao {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public boolean uploadDataset(Dataset dataset) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(dataset);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean renameDateset(Dataset dataset) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(dataset);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean deleteDateset(Dataset dataset) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(dataset);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public Dataset downloadDataset(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Dataset dataset =session.get(Dataset.class, id);
        tx.commit();
        session.close();
        return dataset;
    }

    @Override
    public List<Dataset> getDatasets(int user_id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "FROM Dataset D WHERE D.userId = " + user_id;
        Query query = session.createQuery(hql);
        List<Dataset> datasets = query.getResultList();
        tx.commit();
        session.close();
        return datasets;
    }
}
