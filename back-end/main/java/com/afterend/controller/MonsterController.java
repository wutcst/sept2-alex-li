package com.afterend.controller;

import com.afterend.controller.utils.Result;
import com.afterend.entity.Monster;
import com.afterend.mapper.MonsterMapper;
import com.afterend.service.MonsterService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/monster")
public class MonsterController {

    @Autowired
    private MonsterService monsterService;
    @Autowired
    private MonsterMapper monsterMapper;

    @GetMapping
    public Result getAll(){return new Result(true,monsterService.list());}
    @GetMapping("/roomId={roomId}")
    public Result getByRoomId(@PathVariable Integer roomId) {
        QueryWrapper<Monster> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("room_id",roomId);
        List<Monster> monsterList = monsterMapper.selectList(queryWrapper);
        return new Result(true,monsterList);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Monster monster) {
        return new Result(monsterService.save(monster));
    }

    @PutMapping("/update")
    public Result update(@RequestBody Monster monster){
        return new Result(true,monsterService.updateById(monster));
    }

}
