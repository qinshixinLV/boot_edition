package com.example.boot_edition.po;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class DictInfo {
    private Integer id;

    private String dictKey;

    private String dictValue;

    private String remark;

    private Byte status;

    private Date createTime;

    private Timestamp updateTime;

}