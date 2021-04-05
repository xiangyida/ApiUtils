package com.xyh.dto;

import com.xyh.common.NotEmpty;
import com.xyh.common.NotNull;
import lombok.Data;

/**
 * @author : xiangyida
 * @date : 10:40 下午 2021/4/5
 */
@Data
public class UserDetail {
    /**
     * 用户名
     */
    @NotEmpty
    private String userName;
    /**
     * 电话号码
     */
    @NotNull
    private Integer phoneNumber;

    /**
     * 地址
     * 可为空
     */
    private String address;
}
