package com.zz.mall.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "name不允许为空")
    @Column(name = "user_name")
    private String userName;

    @NotNull(message = "mailAddr不能为空")
    @Column(name = "mail_addr")
    private String mailAddr;

    @NotNull(message = "pwd不能为空")
    @Column(name = "pwd")
    private String pwd;

    @Column(name = "avatar")
    private String avatar;//url -> local file

    @Transient //这个变量，不参与数据的持久化
    private String photo; //图片 -> byte[] -> base64做encode -> String 给前端

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "is_active")
    private Boolean active = true;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;


    @PrePersist
    public void prePersist() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        createdAt = timestamp;
        updatedAt = timestamp;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

}
