package edu.cn.neusoft.project.controller;

import edu.cn.neusoft.project.model.service.UserService;
import edu.cn.neusoft.project.model.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user/")
public class UserAction {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("login.action")
    public Map<String, String> login(String user_name, String user_password, HttpSession httpSession){

        User dbUser = userService.checkUser(user_name, user_password);

        Map<String,String> m=new HashMap<String,String>();
        if(dbUser!=null){
            httpSession.setAttribute("_LOGIN_USER_", dbUser);
            System.out.println("用户不为空");
            m.put("login", "yes");
        }
        else{

            System.out.println("用户为空");
            m.put("login","no");
        }
        return m;
    }
}
