package com.xyh.dto;

import com.xyh.common.NotEmpty;
import com.xyh.common.NotNull;
import lombok.Data;

/**
 * @author : xiangyida
 * @date : 1:42 下午 2021/3/20
 */
@Data
public class UserInfo {
    /**
     * 用户id
     */
    @NotEmpty
    private String UserId;
    /**
     * 用户详细信息
     */
    @NotNull
    private UserDetail userDetail;
}
