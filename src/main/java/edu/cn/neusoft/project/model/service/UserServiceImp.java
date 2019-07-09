package edu.cn.neusoft.project.model.service;

import edu.cn.neusoft.project.model.dao.UserMapper;
import edu.cn.neusoft.project.model.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public User checkUser(String user_name, String user_password) {

        User ue=new User(user_name,user_password);
        return mapper.checkUser(ue);

    }
}
