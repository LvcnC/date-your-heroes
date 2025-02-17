package com.project.datingapp.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.datingapp.dao.DaoUsers;
import com.project.datingapp.entities.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private DaoUsers du;
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("formlogin")
	public String formlogin() {
		return "formlogin.html";
	}
	
	@GetMapping("login")
	public String login(@RequestParam("username") String user,
						@RequestParam("password") String pass,
						HttpSession session) {
		User us;
		try {
			
			us = du.searchUser(user, pass);
			
		}catch(Exception err) {
			us = null;
			err.printStackTrace();
		}
		
		
		if(us == null) {
			return "redirect:formlogin";
		}else {
			// we need to tell the SESSION 
			// 1) that someone LOGGED
			// 2) WHO logged
			session.setAttribute("islogged", "logged");
			session.setAttribute("loggeduser", us);
			// then go home
			return "";
		}
	}
	
	@GetMapping("formregister")
	public String formregister() {
		return "formregister.html";
	}
	
	@GetMapping("newuser")
	public String newuser(@RequestParam Map<String,String> map) {
		
		System.out.println("sono qui");
		for(String s : map.keySet()) {
			System.out.println(s);
		}
		User us = (User) context.getBean("userObject", map);
		System.out.println("Created succefully? " + du.create(us));
		
		return "formlogin";
	}
	
	
}
