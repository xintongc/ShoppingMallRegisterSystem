package com.zz.mall.util;

import com.zz.mall.entity.User;

public class UserHolder {

    /*

    用于存储当前这个线程的私有变量
    对象 在线程内 单例

     */
    private static ThreadLocal<User> USER_HOLDER =
            new ThreadLocal<User>();

    public static User getUser() {
        return USER_HOLDER.get();
    }

    public static void setUser(User user) {
        USER_HOLDER.set(user);
    }
}
