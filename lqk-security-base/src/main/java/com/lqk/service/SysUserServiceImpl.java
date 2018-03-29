/**
 * 
 */
package com.lqk.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lqk.dao.mapper.SysUserMapper;
import com.lqk.pojo.SysUser;

/**
 * @author LQK
 *
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

	@Override
	public SysUser findByUsername(String username) {
		return sysUserMapper.findByUsername(username);
	}

}
