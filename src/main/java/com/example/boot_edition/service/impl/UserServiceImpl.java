package com.example.boot_edition.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.boot_edition.mapper.UserMapper;
import com.example.boot_edition.po.User;
import com.example.boot_edition.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
