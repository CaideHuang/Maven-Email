package com.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.pojo.User;

public interface UserMapper {

	int insertUser(@Param("email") String email,@Param("password") String doPassword,@Param("code") String doCode);

	List<User> selectUserList();

	int updateUserState(@Param("email") String email);

	User selectUserByEmail(@Param("email") String email);

}
