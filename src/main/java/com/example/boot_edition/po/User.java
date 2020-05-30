package com.example.boot_edition.po;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class User  {

    private Long id;

    private String username;

    private String password;

    private String financePwd;

    private String contactName;

    private String mobile;
    
    private String email;

    private Integer status;
    // 最后更新时间
    private Timestamp lastUpdateTime;
    // 数据创建时间
    private Timestamp createTime;

}