package com.example.boot_edition.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.boot_edition.po.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
