package com.cv.mycar.service.iml;

import com.alibaba.dubbo.config.annotation.Service;
import com.cv.mycar.dao.mapper.MiaoshaUserMapper;
import com.cv.mycar.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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
    public Object findAll() {
        return miaoshaUserMapper.selectAll();
    }
}
    