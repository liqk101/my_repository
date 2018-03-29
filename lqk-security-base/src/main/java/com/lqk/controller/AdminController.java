/**
 * 
 */
package com.lqk.controller;

import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LQK
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	//private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @GetMapping("")
    public String index2(Map<String, Object> model) {
        return "redirect:/admin/home";
    }
    @GetMapping("/")
    public String index(Map<String, Object> model) {
        return "redirect:/admin/home";
    }

    @GetMapping("/home")
    public String goHome(Map<String, Object> model) {
    	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
    		    .getAuthentication()
    		    .getPrincipal();
    	
    	model.put("username", userDetails.getUsername());
        return "admin/home";
    }

    @GetMapping("/login")
    public String goLogin(Map<String, Object> model) {
        return "admin/login";
    }
}
