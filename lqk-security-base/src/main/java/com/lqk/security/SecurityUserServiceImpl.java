/**
 * 
 */
package com.lqk.security;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lqk.dao.mapper.SysUserMapper;
import com.lqk.pojo.SysUser;

/**
 * @author LQK
 *
 */
@Service
public class SecurityUserServiceImpl implements UserDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUserServiceImpl.class);

    @Resource
    private SysUserMapper sysUserMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser user = sysUserMapper.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        LOGGER.info("username:"+username);
        LOGGER.info("username:"+user.getUsername()+";password:"+user.getPassword());
        return user;
	}

}
