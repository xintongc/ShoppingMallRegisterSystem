package com.zz.mall.controller;

import com.zz.mall.entity.User;
import com.zz.mall.model.LoginBizResult;
import com.zz.mall.service.login.ILoginBizService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/external/login")
public class LoginController {

    @Autowired
    private ILoginBizService loginBizService;

    //register
    /*
        1.必须用账号注册, 所以账号不能为空
    */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public LoginBizResult register(@RequestBody @Valid User user,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return LoginBizResult.builder()
                    .msg(bindingResult.getAllErrors().get(0).getDefaultMessage())
                    .status(LoginBizResult.FAILED)
                    .build();
        }
        return loginBizService.register(user);
    }

    @RequestMapping(value = "/exist/{name}", method = RequestMethod.GET)
    public LoginBizResult isNameAvaliable(String name) {
        if (StringUtils.isEmpty(name)) {
            return LoginBizResult.builder()
                    .status(LoginBizResult.FAILED)
                    .msg("name不能为空")
                    .build();
        }
        LoginBizResult loginBizResult =
                loginBizService.exist(name);
        return loginBizResult;
    }

    //sign in
    @RequestMapping(value = "/sign_in", method = RequestMethod.POST)
    public LoginBizResult signIn(@RequestBody Sign sign) {
        return loginBizService.loginByName(sign.getName(), sign.getPwd());
    }

    @Data
    private class Sign {
        String name;
        String pwd;
    }

    //retrieve pwd
}
