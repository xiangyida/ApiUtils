package com.xyh.service;

import com.xyh.api.HelloService;
import com.xyh.dto.UserInfo;
import org.springframework.stereotype.Service;

/**
 * @author : xiangyida
 * @date : 9:31 下午 2021/3/18
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String userName) {
        return "Hello " + userName;

    }

    @Override
    public String userRegister(UserInfo userInfo) {
        return userInfo.toString();
    }
}
