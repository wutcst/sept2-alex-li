package com.afterend.service.impl;

import com.afterend.entity.Room;
import com.afterend.mapper.RoomMapper;
import com.afterend.service.RoomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {
}
