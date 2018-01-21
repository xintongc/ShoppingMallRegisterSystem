package com.zz.mall.model;

import com.zz.mall.entity.User;
import lombok.Builder;
import lombok.Data;

@Data//@Setter and @Getter
@Builder
public class LoginBizResult {

    public  static final String SUCC="succ";
    public  static final String FAILED="failed";

    private String status;
    private String msg;
    private Boolean exist;
    private User user;
    private String token;
}
