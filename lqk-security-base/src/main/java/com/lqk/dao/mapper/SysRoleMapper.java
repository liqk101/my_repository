package com.lqk.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lqk.pojo.SysRole;

/**
 * Created by LQK on 2018-3-25.
 */
@Mapper
public interface SysRoleMapper {		
	@Select("SELECT * FROM tbl_sys_role a join tbl_sys_user_roles b on a.id=b.roles_id where b.sys_user_id=#{userId}")
    List<SysRole> findByUserId(@Param("userId") int userId);
}
