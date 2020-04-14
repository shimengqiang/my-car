package com.cv.mycar.dao.mapper;

import com.cv.mycar.dao.model.MiaoshaUser;

import java.util.List;

public interface MiaoshaUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MiaoshaUser record);

    MiaoshaUser selectByPrimaryKey(Long id);

    List<MiaoshaUser> selectAll();

    int updateByPrimaryKey(MiaoshaUser record);
}