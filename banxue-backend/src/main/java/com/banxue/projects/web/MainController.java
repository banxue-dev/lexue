package com.banxue.projects.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.banxue.projects.service.IProjectService;
import com.banxue.utils.Constants;
import com.banxue.utils.log.FileLog;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author feng
 * @since 2018-09-25
 */
@Controller
public class MainController {
	
	/**
	 * 首页
	 * @return
	 */
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	/**
	 * 登录页
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
    public String login(String username,String password, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        if (!"123456".equals(password)) {
            map.put("success", false);
            map.put("message", "密码错误");
            return "err";
        }
        // 设置session
        session.setAttribute(Constants.SESSION_KEY, username);
        map.put("success", true);
        map.put("message", "登录成功");
        return "redirect:index";
    }
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(Constants.SESSION_KEY);
        return "redirect:/login";
    }
	
}
