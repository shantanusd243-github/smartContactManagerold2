package com.smart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smart.dao.UserRepository;
import com.smart.entities.User;
import com.smart.helper.Message;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home - Smart Contact Manager");
		return "home";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About - Smart Contact Manager");
		return "about";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "Register - Smart Contact Manager");
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("title", "Login - Smart Contact Manager");
		return "login";
	}
	
	//handler for register user.
	@RequestMapping(value = "/do_register",method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult bindResult, Model model,HttpSession session) {
		List<String> message =new ArrayList<String>();  
		try {
			System.out.println("USER "+user);
			System.out.println("bindResult "+bindResult);
			if(bindResult.hasErrors()) {
				model.addAttribute("user", user);
				session.setAttribute("message",new Message((List<String>) bindResult,"alert-danger"));
				System.out.println("bindResult "+bindResult);
				return "signup";
			}
			user.setRole("User");
			user.setEnabled(true);
			User result = this.userRepository.save(user);
			System.out.println("RESULT "+result);
			model.addAttribute("user", new User()); 
			message.add("Successfully Registered !!");
			session.setAttribute("message",new Message(message,"alert-success"));
			System.out.println("session "+session.getAttribute("message"));
			return "signup";
		}
		catch(Exception e) {
			message.add("Something went wrong !! ");
			session.setAttribute("message",new Message(message,"alert-danger"));
			System.out.println("Exception during signup : "+e);
			model.addAttribute("user", user); //to send data again in failure case
			return "signup";
		}
	}
}
