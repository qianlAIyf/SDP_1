package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.interf.ModelDao;
import model.Model;
import model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.xml.ws.Action;
import java.util.List;

@Controller("getModels")
@Scope("prototype")

public class GetModelsAction extends ActionSupport {
    @Resource
    ModelDao modelDao;
    @Resource
    private User user;

    public String execute(){
        List<Model> models =  modelDao.getModels(user.getId());
        ActionContext.getContext().put("models",models);
        return SUCCESS;
    }
}
