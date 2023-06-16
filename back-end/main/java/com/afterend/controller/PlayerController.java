package com.afterend.controller;

import com.afterend.controller.utils.Result;
import com.afterend.entity.Monster;
import com.afterend.entity.Player;
import com.afterend.mapper.PlayerMapper;
import com.afterend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private PlayerMapper playerMapper;
    @GetMapping
    public Result getAll(){
        return new Result(true,playerService.list());
    }

    @PutMapping("/update")
    public Result update(@RequestBody Player player){
        return new Result(true,playerService.updateById(player));
    }

}
