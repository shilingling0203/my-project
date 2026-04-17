package com.example.my_project_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;
    public static <T> Result<T> success(T data){
        return new Result<>(200,"success",data);
    }

    public static Result<?> error(String msg){
        return new Result<>(401,msg,null);
    }
}
