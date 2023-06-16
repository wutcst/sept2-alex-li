package com.afterend.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTestCase {

    @Autowired
    private UserService userService;

    @Test
    void testAdd(){
        System.out.println(userService.getById(3));
    }
    @Test
    void testGetAll(){
        userService.list();
    }

//    @Test
//    void add(){
//        User user = new User();
//        user.setName("ji");
//        user.setAge(11);
//        user.setHobby("ssss");
//        userService.save(user);
//    }
    @Test
    void delete(){
        userService.removeById(2089545735);
    }

//    @Test
//    void update(){
//        User user = new User();
//        user.setId(2);
//        user.setName("wwwww");
//        userService.updateById(user);
//    }
}
