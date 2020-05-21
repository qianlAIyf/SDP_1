package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.User;
import org.apache.struts2.dispatcher.HttpParameters;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.UserService;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport {
    @Resource
    private User user;

    @Resource
    private UserService userService;

    @Override
    public String execute() throws Exception {
        ActionContext context = ActionContext.getContext();
        HttpParameters map = context.getParameters();

        List<User> users = userService.getUsers();
        Iterator iterator = users.iterator();
        while (iterator.hasNext()){
            User user = (User) iterator.next();
            if(user.getName() == map.get("name").getValue()){
                return ERROR;
            }
        }
        return SUCCESS;
    }
}
