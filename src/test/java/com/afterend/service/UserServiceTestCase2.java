package com.afterend.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTestCase2 {

    @Autowired
    private UserService userService;

    @Test
    void testAdd(){
        System.out.println(userService.getById(3));
    }
}
