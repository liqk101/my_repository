/**
 * 
 */
package com.lqk.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author LQK
 *
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Map<String, Object> model) {
        return "page/index";
    }
}
