package com.aldekain.basicUserService.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aldekain.basicUserService.entities.User;
import com.aldekain.basicUserService.models.bindingModels.UserLogin;
import com.aldekain.basicUserService.models.bindingModels.UserRegister;
import com.aldekain.basicUserService.service.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("register")
	public String getRegister(Model model, UserRegister userRegister) {

		//model.addAttribute("view", "users/register-user");
		model.addAttribute("user",userRegister);
		
		return "user/user-register";
	}
	
	@PostMapping("/register")
	public String postRegister(@Valid @ModelAttribute(name="user") UserRegister userRegister, BindingResult bindingResult) {
		System.out.println("postRegister Part_1");
		if (bindingResult.hasErrors()) {
			//return "redirect:/user/user-register";
			return "user/user-register";
		}
		System.out.println("postRegister Part_2");
				
		this.userService.register(userRegister);
		
		
		return "redirect:/user/login";
	}
	
	@GetMapping("/login")
	public String getLoginPage(Model model,@RequestParam(required = false) boolean hasError) {
//	public String getLoginPage(@ModelAttribute(name="user") UserLoginViewModel user,@RequestParam(required = false) boolean hasError, Model model) {
//		if (error != null) {
//			model.addAttribute("error", "Invalid Credentials");
//		}
//
//		if (hasError) {
//			model.addAttribute("error", "Invalid Credentials");
//		}
//		
//		System.out.println("getLoginPage is called");

//	    model.addAttribute("view", "users/login");
//	    model.addAttribute("title", "Login");
	    model.addAttribute("user", new UserLogin());
		
		return "user/login";
	}
	
	@PostMapping("/login")
	public String postLogin(Model model,@Valid UserLogin userLogin, BindingResult bindingResult,RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "users/login";
		}
	
		return "user/login-successful";
	}
}
