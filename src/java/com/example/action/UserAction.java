package com.example.action;

import com.example.model.UserInfoEntity;
import com.example.service.UserService;
import com.example.utils.UuidUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Map;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {

    @Resource
    private UserService userService;

    private UserInfoEntity user;

    public UserInfoEntity getUser() {
        return user;
    }

    public void setUser(UserInfoEntity user) {
        this.user = user;
    }

    public String info() {
        user = userService.info(1L);
        return SUCCESS;
    }

    public String login() {
        if (userService.login(user)) {
            Map session = ActionContext.getContext().getSession();
            session.put("user", user);
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String register() {
        if (userService.register(user)) {
            return INPUT;
        } else {
            return ERROR;
        }
    }
}
