package com.project.datingapp.controllers;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.datingapp.dao.DaoCharacters;
import com.project.datingapp.dao.DaoUsers;
import com.project.datingapp.entities.HistoryCharacter;
import com.project.datingapp.entities.User;

import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {

	@Autowired
	private DaoUsers du;

	@Autowired
	private DaoCharacters dc;

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

		// we take the user from the session
		User us = (User) session.getAttribute("loggeduser");

		// we check if the user is NULL
		if(us == null){
			System.out.println("is null " + us);
			// DIO MORTO, SI USA REDIRECT, OPPURE TI SOVRASCRIVE IL MAPPING
			return "redirect:formlogin";
		}

		// we take the swipeable characters from the db
		ArrayList<HistoryCharacter> swipeableCharacters = dc.swipeableCharacters(us.getId());

		// we send off only the ID of the user (should be lighter?)
		model.addAttribute("iduser", us.getId());
		model.addAttribute("daousers", du);
		// we also send the al with the characters
		model.addAttribute("swipeableCharacters", swipeableCharacters);

		return "swipe.jsp";
	}
}

