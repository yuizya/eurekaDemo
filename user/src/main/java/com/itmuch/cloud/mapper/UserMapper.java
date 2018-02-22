package com.itmuch.cloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.itmuch.cloud.entity.User;

@Mapper
@Repository
public interface UserMapper{
	User fetchUserByUsername(String username);
	User fetchUserById(Long id);
}
