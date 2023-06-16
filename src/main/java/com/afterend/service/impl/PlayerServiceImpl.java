package com.afterend.service.impl;

import com.afterend.entity.Player;
import com.afterend.mapper.PlayerMapper;
import com.afterend.service.PlayerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl extends ServiceImpl<PlayerMapper, Player> implements PlayerService {
}
