package com.cv.mycar.service;

import com.cv.mycar.dto.UserDto;

import java.util.List;

/**
 * @author shimengqiang
 * @Date 2020-04-14-16:53
 * @Version 1.0
 */
public interface IUserService {

    List<UserDto> findAll();

    UserDto findById(Long id);
}
