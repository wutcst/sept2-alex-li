package com.afterend.controller.utils;

import lombok.Data;

@Data
public class Result {
    private Boolean flag;
    private Object data;
    public Result(){}
    public Result(boolean flag){
        this.flag = flag;
    }
    public Result(boolean flag, Object data){
        this.flag=flag;
        this.data=data;
    }
}
