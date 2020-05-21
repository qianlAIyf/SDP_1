package action;

import com.opensymphony.xwork2.ActionSupport;
import model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.UserService;

import javax.annotation.Resource;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport {
    private User user;

    @Resource
    private UserService userService;

    public User getUser() {
        return user;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
