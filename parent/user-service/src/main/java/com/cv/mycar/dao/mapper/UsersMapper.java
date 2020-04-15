package com.cv.mycar.dao.mapper;

import com.cv.mycar.dao.model.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsersMapper {
    @Select("select count(1) from users")
    int count();

    int deleteByPrimaryKey(Long id);

    int insert(Users record);

    Users selectByPrimaryKey(Long id);

    List<Users> selectAll();

    List<Users> pageQuery(@Param("begin") Integer begin, @Param("offset") Integer offset);

    int updateByPrimaryKey(Users record);
}