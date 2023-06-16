package com.afterend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserDaoTestCase {
    @Autowired
    private UserMapper userDao;
    @Autowired
    private StudentsMapper studentsMapper;
    @Test
    void testGetById(){
        System.out.println(studentsMapper.selectById(1));
    }
//    @Test
//    void testAdd(){
//        User user = new User();
//        user.setAge(99);
//        user.setHobby("鸡你太美");
//        user.setName("小黑子");
//        userDao.insert(user);
//    }
//    @Test
//    void testDelete(){
//        userDao.deleteById(1632243714);
//    }

    @Test
    void testCondition(){
//        QueryWrapper<Students> qw = new QueryWrapper<Students>();
//        qw.like("name","1");
//        studentsMapper.selectList(qw);
//        List<Students> studentsList = studentsMapper.selectList(qw);
//        studentsList.forEach(System.out::println);

        QueryWrapper<Students> queryWrapper = new QueryWrapper<Students>();
        queryWrapper.like("name","lk");
        List<Students> studentsList = studentsMapper.selectList(queryWrapper);
//        studentsList.forEach(System.out::println);
//        return new Result(true,studentsList);
    }

}
