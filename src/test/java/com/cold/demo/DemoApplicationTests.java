package com.cold.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cold.demo.entity.User;
import com.cold.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    UserMapper userMapper;

    //查询User表中的数据
    @Test
    void contextLoads() {
        //List<User> users = userMapper.selectList(null);
        List<User> cold = userMapper.selectBatchIds(Arrays.asList(1,2,3));
        System.out.println(cold);
    }
    @Test
    void add(){
//        int cold = userMapper.insert(new User("yf2", 25, "yf2_ai@163.com"));
        Page<User> page = new Page<>(1,5);
        Page<User> cold = userMapper.selectPage(page, null);
    }

    @Test
    void updateUser(){
//        User user=new User();
//        user.setId(2L);
//        user.setAge(30);
//        user.setEmail("1157788389@qq.com");
//        userMapper.selectById(1258052231351808002L);
        int i = userMapper.updateById(userMapper.selectById(1258052231351808002L));
        System.out.println(i);
    }

    @Test
    void deleteTest(){
        int i = userMapper.deleteBatchIds(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(i);
    }

    @Test
    void testSelectQuery(){
        QueryWrapper<User> qw = new QueryWrapper();
//        qw.ge("age",30);
//        qw.eq("name","cold");
//        qw.between("age",10,30);
        qw.select("id","name");
        List<User> users = userMapper.selectList(qw);
        System.out.println(users);
    }
}
