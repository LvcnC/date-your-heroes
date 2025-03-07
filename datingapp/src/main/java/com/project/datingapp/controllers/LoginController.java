package com.project.datingapp.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.datingapp.dao.DaoImages;
import com.project.datingapp.dao.DaoUsers;
import com.project.datingapp.entities.Image;
import com.project.datingapp.entities.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private DaoUsers du;

	@Autowired
	private DaoImages di;
	
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
			System.out.println(user);
			System.out.println(pass);
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
			return "profile";
		}
	}

	@GetMapping("profile")
	public String profile(HttpSession session, Model model){
		// take the logged in user (SESSION)
		User loggedUser = (User) session.getAttribute("loggeduser");

		// put the credentials in the model 
		model.addAttribute("loggeduser", loggedUser);
		model.addAttribute("daousers", du);
		ArrayList<Image> images = di.getImages(loggedUser.getId(), "user");
		model.addAttribute("images", images);

		return "profile.jsp";
	}
	
	@GetMapping("formregister")
	public String formregister() {
		return "formregister.html";
	}
	
	@GetMapping("newuser")
	public String newuser(@RequestParam Map<String,String> map) {
		
		// we create a new user
		User us = (User) context.getBean("userNew", map);
		System.out.println("Created succefully? " + du.create(us));

		return "formlogin";
	}
	
	
}
