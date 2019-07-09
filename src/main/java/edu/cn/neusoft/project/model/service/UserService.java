package edu.cn.neusoft.project.model.service;

import edu.cn.neusoft.project.model.vo.User;

public interface UserService {
    User checkUser(String user_name, String user_password);
}
