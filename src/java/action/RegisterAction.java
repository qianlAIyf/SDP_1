package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.User;
import org.apache.struts2.dispatcher.HttpParameters;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.interf.UserService;

import javax.annotation.Resource;

@Controller("registerAction")
@Scope("prototype")
public class RegisterAction extends ActionSupport {
    @Resource
    private User user;
    @Resource
    private UserService userService;

    public String execute() {
        ActionContext context = ActionContext.getContext();
        HttpParameters map = context.getParameters();
        user.setName(map.get("name").getValue());
        user.setPassword(map.get("password").getValue());
        userService.setUser(user);
        return SUCCESS;
    }
}
