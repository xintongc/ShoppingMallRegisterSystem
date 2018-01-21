package com.zz.mall.model;

import com.zz.mall.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBizResult {
    private String status;
    private String msg;
    private User user;
}
