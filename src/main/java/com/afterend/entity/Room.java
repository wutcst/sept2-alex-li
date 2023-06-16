package com.afterend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("room")
public class Room {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String north;
    private String south;
    private String east;
    private String west;
}
