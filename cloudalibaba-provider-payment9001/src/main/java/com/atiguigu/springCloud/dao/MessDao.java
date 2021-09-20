package com.atiguigu.springCloud.dao;

import com.atiguigu.springCloud.entities.Mess;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Mess record);

    int insertSelective(Mess record);

    Mess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mess record);

    int updateByPrimaryKey(Mess record);
}