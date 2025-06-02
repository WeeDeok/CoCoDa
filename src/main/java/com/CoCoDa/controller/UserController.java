package com.CoCoDa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CoCoDa.service.UserService;
import com.CoCoDa.vo.UserVO;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {

	@Autowired
	UserService service;
	
	@GetMapping("/userlogin")
	public String userlogin() {
		return "userlogin";
	}
	
	@GetMapping("/userjoin")
	public String userjoin() {
		return "userjoin";
	}
	
	@PostMapping("/userlogin")
	public String userloginForm(UserVO user, HttpSession session) {
		
		String id = null;
		String pw = null;
		
		UserVO us = service.userlogin(user);

		id = user.getUserid();
		pw = user.getUserpw();
		

		if(us!=null) {
			
			if(id.equals(us.getUserid())&&pw.equals(us.getUserpw())) {
				if(id.equals("admin")) {
					System.out.println("adminset");
					session.setAttribute("admin", id);
				} else {
				session.setAttribute("userid", id);
				}
				
				return "redirect:/";
			}
				
		}
		
		return "redirect:/";
	
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		
		// code Here
		session.invalidate(); 
		return "redirect:/";

	}
	
	@PostMapping("userjoin")
	public String userjoin(
			UserVO user,
			Model model) {
		 System.out.println(user);
		int result = service.userjoin(user);
		if (result != 1) {
			
			model.addAttribute("errorMsg", "媛��엯 �떎�뙣");
			return "customer/joinForm";

		}
		model.addAttribute("id", user.getUserid());

		return "customer/joinComplete";
	}
	
	@GetMapping("checkId")
	public int searchUserid(String userid, Model model) {
		int numm=0;
		numm=service.searchUserid(userid);
		System.out.println(numm);
		return numm;
	}
	
	@GetMapping("userJoin")
	public int joinUser(UserVO user, Model model) {
		int number = 0;
		System.out.println(user);
		number = service.joinUser(user);
		return number;

	}
	
}
