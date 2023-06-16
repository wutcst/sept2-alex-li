package com.afterend.service.impl;

import com.afterend.entity.Monster;
import com.afterend.mapper.MonsterMapper;
import com.afterend.service.MonsterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MonsterServiceImpl extends ServiceImpl<MonsterMapper, Monster> implements MonsterService {
}
