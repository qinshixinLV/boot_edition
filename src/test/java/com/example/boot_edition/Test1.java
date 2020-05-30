package com.example.boot_edition;

import com.example.boot_edition.datasource.DynamicDataSourceHolder;
import com.example.boot_edition.po.DictInfo;
import com.example.boot_edition.po.User;
import com.example.boot_edition.service.DictInfoService;
import com.example.boot_edition.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

public class Test1 extends BootEditionApplicationTests {

    @Resource(name = "redisTemplate1")
    private StringRedisTemplate redisTemplate;
    @Autowired
    private DictInfoService dictInfoService;
    @Autowired
    private UserService userService;

    @Test
    void name() {
        String batchId = redisTemplate.opsForValue().get("batchId");
        System.out.println(batchId);
    }

    @Test
    void name2() {
        DynamicDataSourceHolder.setDataSource("firstDataSource");
        DictInfo byId = dictInfoService.getById(1);
        System.out.println(byId);
    }

    @Test
    void name3() {
        DynamicDataSourceHolder.setDataSource("secondDataSource");
        User byId = userService.getById(100062);
        System.out.println(byId);
    }
}
