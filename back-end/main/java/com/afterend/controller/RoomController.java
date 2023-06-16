package com.afterend.controller;

import com.afterend.controller.utils.Result;
import com.afterend.entity.Room;
import com.afterend.mapper.RoomMapper;
import com.afterend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomMapper roomMapper;

    @GetMapping
    public Result getAll(){
        return new Result(true,roomService.list());
    }
    @GetMapping("/roomId={roomId}")
    public Result getById(@PathVariable Integer roomId){
        return new Result(true,roomService.getById(roomId));
    }

//    @PostMapping("/update")
//    public Result update(@RequestBody Room room){
//        return new Result(true,roomService.updateById(room));
//    }
}
