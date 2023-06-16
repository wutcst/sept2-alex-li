package com.afterend.service.impl;

import com.afterend.entity.Item;
import com.afterend.mapper.ItemMapper;
import com.afterend.service.ItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements ItemService {
}
