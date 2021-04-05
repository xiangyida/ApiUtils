package com.xyh;

import com.xyh.api.HelloService;
import com.xyh.dto.UserDetail;
import com.xyh.dto.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : xiangyida
 * @date : 10:19 下午 2021/4/5
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestHelloService {
    @Autowired
    private HelloService helloService;

    /**
     * 测试字符串类型参数校验
     */
    @Test
    public void testSayHello(){
        System.out.println(helloService.sayHello("Tom"));
        System.out.println(helloService.sayHello(""));
    }

    /**
     * 测试校验对象类型参数
     */
    @Test
    public void testUserRegister(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("123");
        System.out.println(helloService.userRegister(null));
        System.out.println(helloService.userRegister(userInfo));
        UserDetail userDetail = new UserDetail();
        userDetail.setPhoneNumber(123456);
        userInfo.setUserDetail(userDetail);
        System.out.println(helloService.userRegister(userInfo));
    }
}

