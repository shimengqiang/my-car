package com.cv.mycar.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cv.mycar.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shimengqiang
 * @Date 2020-04-14-18:19
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Reference
    private IUserService userService;

    @GetMapping("/list")
    public Object list(){
        return userService.findAll();
    }

}
    