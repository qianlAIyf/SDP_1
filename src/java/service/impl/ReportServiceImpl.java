package service.impl;

import dao.interf.ReportDao;
import model.Dataset;
import model.Report;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import service.interf.ReportService;

import javax.annotation.Resource;
import java.util.List;
@Service
@Scope("prototype")
public class ReportServiceImpl implements ReportService {
    @Resource
    ReportDao reportDao;
    @Override
    public Dataset chooseDataset(int id) {
        return null;
    }

    @Override
    public Dataset uploadDataset() {
        return null;
    }

    @Override
    public void chooseModel() {

    }

    @Override
    public List<Report> getReports() {
        return null;
    }

    @Override
    public boolean saveReport(Report report) {
        reportDao.saveReport(report);
        return false;
    }
}
