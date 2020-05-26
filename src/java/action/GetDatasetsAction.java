package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.Dataset;
import model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.interf.DatasetService;

import javax.annotation.Resource;
import java.util.List;

@Controller("getDatasets")
@Scope("prototype")
public class GetDatasetsAction extends ActionSupport {

    @Resource
    DatasetService datasetService;
    @Resource
    User user;

    public String execute(){
        List<Dataset> datasets = datasetService.getDatasets(user.getId());
        ActionContext.getContext().put("datasets",datasets);
        return SUCCESS;
    }
}
