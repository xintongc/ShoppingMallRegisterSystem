package com.zz.mall.controller;

import com.zz.mall.entity.User;
import com.zz.mall.model.UserBizResult;
import com.zz.mall.service.user.IUserService;
import com.zz.mall.util.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/internal/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/avatar", method = RequestMethod.POST)
    public UserBizResult uploadAvatar(MultipartFile file) {
        User user = userService.uploadAvatar(file);
        return null;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public User getCurrentUser() {
        User user = UserHolder.getUser();
        return user;
    }
}
