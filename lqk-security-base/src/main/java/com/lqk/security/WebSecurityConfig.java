package com.lqk.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    UserDetailsService securityUserService() {
        return new SecurityUserServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        		//.antMatchers("task**", "/file_area/**", "/realtime_area/**", "/sub_system/**").permitAll()
        		.antMatchers("/").permitAll()
        		//验证admin
        		.antMatchers("/admin/**").hasRole("ADMIN")
                //设置默认登录成功跳转页面
                .and().formLogin().loginPage("/admin/login").defaultSuccessUrl("/admin/home").failureUrl("/admin/login?error").permitAll()
                //cookie保存用户数据、设置cookie有效期、设置cookie的私钥
                //.and().rememberMe().tokenValiditySeconds(30 * 60).key("bijie-key")
                //默认注销行为logout
                .and().logout().logoutUrl("/admin/logout").logoutSuccessUrl("/").permitAll();
        
        http.csrf().disable();
        // http.cors().disable();
        http.headers().frameOptions().disable();
        //权限不足处理
        http.exceptionHandling().accessDeniedHandler(new AccessDeniedHandlerImpl()).accessDeniedPage("/");
    }
}
