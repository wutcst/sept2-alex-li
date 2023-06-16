package com.afterend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("item")
public class Item {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;  //物品名
    private Integer value;   //物品属性值
    private String des;  //物品描述
    private Integer roomId;
    private String img;
}
