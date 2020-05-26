package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.interf.ModelDao;
import model.Model;
import model.User;
import org.apache.struts2.dispatcher.HttpParameters;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.interf.UserService;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport {

    @Resource
    private UserService userService;
    @Resource
    private User user;

    @Override
    public String execute() throws Exception {
        ActionContext context = ActionContext.getContext();
        HttpParameters map = context.getParameters();

        List<User> users = userService.getUsers();
        Iterator iterator = users.iterator();
        while (iterator.hasNext()){
            User user1 = (User) iterator.next();
            if(user1.getName().equals(map.get("name").getValue())) {
                if (user1.getPassword().equals(map.get("password").getValue()))
                    user.setId(user1.getId());
                    return SUCCESS;
            }
        }
        return ERROR;
    }

    public void validate(){
        ActionContext context = ActionContext.getContext();
        HttpParameters map = context.getParameters();

        String name = map.get("name").getValue();
        String password = map.get("password").getValue();
        if(name == null || name.equals("")){
            addFieldError("name","账号为空，请重新输入");
        }
        if(password == null || password.equals("")){
            addFieldError("password","密码为空，请重新输入");
        }
    }

}
