package com.lqk.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.lqk.pojo.SysUser;

/**
 * Created by LQK on 2018-3-25.
 */
@Mapper
public interface SysUserMapper {	
	@Select("SELECT * FROM tbl_sys_user where username=#{username}")
    @Results(value = {
    		@Result(property = "roles", javaType = List.class, column = "id", many = @Many(select = "com.lqk.dao.mapper.SysRoleMapper.findByUserId"))})
    SysUser findByUsername(@Param("username") String username);
}
