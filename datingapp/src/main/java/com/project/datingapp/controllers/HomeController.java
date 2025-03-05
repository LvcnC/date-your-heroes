package com.project.datingapp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.datingapp.dao.DaoUsers;
import com.project.datingapp.entities.User;

import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {

	@Autowired
	private DaoUsers du;

	@GetMapping("")
	public String home() {
		return "home.html";
	}
	
	@GetMapping("characterprofile")
	public String characterprofile(){
		return "characterprofile.jsp";
	}

	
	@GetMapping("swipe")
	public String swipe(HttpSession session, Model model) {
		// chiediamo se il log c'è
		System.out.println(session.getAttribute("loggeduser"));
		// lo prendiamo
		User us = (User) session.getAttribute("loggeduser");


		if(us == null){
			System.out.println("è null " + us);
			// DIO MORTO, SI USA REDIRECT, OPPURE TI SOVRASCRIVE IL MAPPING
			return "redirect:formlogin";
		}
		// we send off only the ID of the user (should be lighter?)
		model.addAttribute("iduser", us.getId());
		model.addAttribute("daousers", du);
		System.out.println("ci arriviamo?");

		return "swipe.jsp";
	}
}

