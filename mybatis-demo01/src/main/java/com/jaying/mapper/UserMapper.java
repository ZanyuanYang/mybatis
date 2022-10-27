package com.jaying.mapper;

import com.jaying.entity.UserEntity;

import java.util.List;

public interface UserMapper {

	//
	/**
	 * 调用到UserMapper.getByUsers 会自动查找userMapper.xml的getByUsers sql语句
	 * sql语句的id值与接口方法名称对应
	 */
	List<UserEntity> getByUsers();
}
