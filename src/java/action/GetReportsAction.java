package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.interf.ReportDao;
import model.Report;
import model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

@Controller("getReports")
@Scope("prototype")

public class GetReportsAction extends ActionSupport {
    @Resource
    ReportDao reportDao;
    @Resource
    User user;
    private List<Report> reports;
    public String execute(){
        reports = reportDao.getReports(user.getId());
//        ActionContext.getContext().put("reports", reports);
        return SUCCESS;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public List<Report> getReports() {
        return reports;
    }
}
