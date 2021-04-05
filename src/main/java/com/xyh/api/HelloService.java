package com.xyh.api;

import com.xyh.common.NotEmpty;
import com.xyh.common.NotNull;
import com.xyh.dto.UserInfo;

/**
 * @author : xiangyida
 * @date : 9:30 下午 2021/3/18
 */
public interface HelloService {

    /**
     * 测试
     * @param userName 用户名
     * @return hello + userName
     */
    String sayHello(@NotEmpty String userName);

    /**
     * 用户注册
     * @param userInfo 用户信息
     */
    String userRegister(@NotNull UserInfo userInfo);
}
