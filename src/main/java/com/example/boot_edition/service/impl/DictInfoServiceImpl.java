package com.example.boot_edition.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.boot_edition.mapper.DictInfoMapper;
import com.example.boot_edition.po.DictInfo;
import com.example.boot_edition.service.DictInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictInfoServiceImpl extends ServiceImpl<DictInfoMapper, DictInfo> implements DictInfoService {

    @Autowired
    private DictInfoMapper dictInfoMapper;

}
