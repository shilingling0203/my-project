package com.example.my_project_system.entity.util;

import com.example.my_project_system.dto.DashboardDTO;
import lombok.Data;

import java.io.Serializable;

@Data
public class R<T> implements Serializable {
    private static final long serialVersionUID=1L;

//    状态码：0成功，非0失败
    private int code;

//    返回消息
    private String msg;

//    返回数据
    private T data;

    /** 成功（无数据） */
    public static <T> R<T> ok(DashboardDTO dashboardData) {
        return ok(null);
    }
    /** 失败 */
    public static <T> R<T> fail(String msg) {
        R<T> r = new R<>();
        r.setCode(1);
        r.setMsg(msg);
        return r;
    }

}
