package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.UserService;

import javax.annotation.Resource;

@Controller("registerAction")
@Scope("prototype")
public class RegisterAction extends ActionSupport {
    private User user;

    @Resource
    private UserService userService;

    public String execute() {
        ActionContext context = ActionContext.getContext();
        user.setName((String)context.get("name"));
        user.setPassword((String) context.get("password"));
        userService.setUser(user);
        return SUCCESS;
    }
}
