package com.CoCoDa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CoCoDa.entity.UserEntity;
import com.CoCoDa.service.UserService;
import com.CoCoDa.vo.UserVO;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/userlogin")
	public String userlogin() {
		return "userlogin";
	}
	
	@GetMapping("/userjoin")
	public String userjoin() {
		return "userjoin";
	}
	
	@PostMapping("/userlogin")
	public String userloginForm(@RequestBody UserEntity user, HttpSession session) {
		
		String id = null;
		String pw = null;
		
		UserEntity us = service.userlogin(user);

		id = us.getUserid();
		pw = us.getUserpw();

		if(!"".equals(us.getUserid()) || us.getUserid() != null) {
			
			if(id.equals(us.getUserid()) && pw.equals(us.getUserpw())) {

				if(id.equals("admin")) {
					
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
	public String userjoin(@RequestBody UserEntity user, Model model) {
		
		int result = 0;

		try {

			UserEntity entity = service.userjoin(user);
			result = (entity == null) ? 0 : 1;

		} catch(Exception e) {

			e.printStackTrace();

		}

		if (result != 1) {
			
			model.addAttribute("errorMsg", "Error");

			return "customer/joinForm";

		}

		model.addAttribute("id", user.getUserid());

		return "customer/joinComplete";

	}
	
	@GetMapping("checkId")
	public int searchUserid(String userid) {
		
		int numm = 0;

		numm = service.searchUserid(userid);
		
		return numm;

	}
	
	@GetMapping("userJoin")
	public int joinUser(UserVO user) {
		
		int number = 0;
		
		number = service.joinUser(user);

		return number;

	}
	
}
