package com.cv.mycar.service.iml;

import com.alibaba.dubbo.config.annotation.Service;
import com.cv.mycar.dao.mapper.MiaoshaUserMapper;
import com.cv.mycar.dao.model.MiaoshaUser;
import com.cv.mycar.dto.UserDto;
import com.cv.mycar.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shimengqiang
 * @Date 2020-04-14-16:54
 * @Version 1.0
 */
@Service
@Component
public class IUserServiceImpl implements IUserService {
    @Autowired
    MiaoshaUserMapper miaoshaUserMapper;
    @PostConstruct
    public void test(){
        System.out.println(miaoshaUserMapper.selectAll().toString());
    }

    @Override
    public List<UserDto> findAll() {
        //TODO 超时
        List<UserDto> dtoList = new ArrayList<>();
        List<MiaoshaUser> miaoshaUsers = miaoshaUserMapper.selectAll();
        for (MiaoshaUser user : miaoshaUsers) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
            dtoList.add(userDto);
        }

//        miaoshaUsers.forEach( miaoshaUser -> {
//            UserDto userDto = new UserDto();
//            BeanUtils.copyProperties(miaoshaUsers, userDto);
//            dtoList.add(userDto);
//        });
        return dtoList;
    }
}
    