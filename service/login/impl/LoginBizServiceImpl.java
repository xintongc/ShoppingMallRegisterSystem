package com.zz.mall.service.login.impl;

import com.zz.mall.entity.User;
import com.zz.mall.model.LoginBizResult;
import com.zz.mall.service.login.ILoginBizService;
import com.zz.mall.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginBizServiceImpl implements ILoginBizService {

    @Autowired
    private IUserService userService;

    @Override
    public LoginBizResult loginByName(String name, String pwd) {
        User user = userService.findByName(name);
        if (user == null) {
            return LoginBizResult.builder()
                    .msg("用户不存在")
                    .status(LoginBizResult.FAILED)
                    .build();
        }
        if (!user.getPwd().equals(pwd)) {
            return LoginBizResult.builder()
                    .msg("密码错误")
                    .status(LoginBizResult.FAILED)
                    .build();
        }
        return LoginBizResult.builder()
                .msg("")
                .status(LoginBizResult.SUCC)
                .user(user)
                .build();
    }

    @Override
    public LoginBizResult exist(String name) {
        User user = userService.findByName(name);
        boolean exist = user == null ? false : true;
        return LoginBizResult.builder()
                .exist(exist)
                .status(LoginBizResult.SUCC)
                .build();
    }

    @Override
    public LoginBizResult register(User user) {
        user = userService.createNewUser(user);
        if (user == null) {
            return LoginBizResult.builder()
                    .msg("创建失败")
                    .status(LoginBizResult.FAILED)
                    .build();
        }
        return LoginBizResult.builder()
                .user(user)
                .status(LoginBizResult.SUCC)
                .build();
    }
}
