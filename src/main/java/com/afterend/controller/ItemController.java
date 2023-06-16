package com.afterend.controller;

import com.afterend.controller.utils.Result;
import com.afterend.entity.Item;
import com.afterend.entity.Monster;
import com.afterend.mapper.ItemMapper;
import com.afterend.service.ItemService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemMapper itemMapper;

    @GetMapping
    public Result getAll(){
        return new Result(true,itemService.list());
    }

    @GetMapping("/roomId={roomId}")
    public Result getByRoomId(@PathVariable Integer roomId) {
        QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("room_id",roomId);
        List<Item> itemList = itemMapper.selectList(queryWrapper);
        return new Result(true,itemList);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Item item) {
        return new Result(itemService.save(item));
    }

    @PutMapping("/update")
    public Result update(@RequestBody Item item){
        return new Result(true,itemService.updateById(item));
    }

}
