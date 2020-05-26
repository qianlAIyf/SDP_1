package dao.impl;

import dao.interf.ReportDao;
import model.Report;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ReportDaoImpl implements ReportDao {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public boolean renameReport(Report report) {
        return false;
    }

    @Override
    public boolean deleteReport(Report report) {
        return false;
    }

    @Override
    public Report getReport(int id) {
        return null;
    }

    @Override
    public boolean saveReport(Report report) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(report);
        tx.commit();
        session.close();
        return false;
    }

    @Override
    public List<Report> getReports(int usre_id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "FROM Report R WHERE R.userId = " + usre_id;
        Query query = session.createQuery(hql);
        List<Report> reports = query.getResultList();
        tx.commit();
        session.close();
        return reports;
    }
}
