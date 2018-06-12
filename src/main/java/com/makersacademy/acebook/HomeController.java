package com.makersacademy.acebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class HomeController {

	private final UserRepository repository;

	@Autowired
	public HomeController(UserRepository repository) { this.repository = repository; }

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/users", method = POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String registration(HttpServletRequest request) {
		String[] parammap = request.getParameterValues("username");
		this.repository.save(new User(parammap, "hello@test.com", "password123"));
		return "index";
	}
}
