/**
 * 
 */
package com.lqk.service;

import com.lqk.pojo.SysUser;

/**
 * @author LQK
 *
 */
public interface SysUserService {
	SysUser findByUsername(String username);
}
