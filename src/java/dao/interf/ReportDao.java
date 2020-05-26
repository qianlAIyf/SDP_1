package dao.interf;

import model.Report;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ReportDao {
    boolean renameReport(Report report);//重命名报告
    //删除报告
    boolean deleteReport(Report report);
    Report getReport(int id);//根据模型id查看相应的报告
    boolean saveReport(Report report);//保存报告
    List<Report> getReports(int usre_id);//获取当前用户所有的报告
}
