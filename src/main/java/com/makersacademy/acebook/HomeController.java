package com.makersacademy.acebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class HomeController {

	private final UserService userService;

	@Autowired
	public HomeController(UserService userService){
		this.userService = userService;
	}

	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/users", method = GET)
	public String registration(Model model) { return "register"; }

	@RequestMapping(value = "/users", method = POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String registrationUser(
			@ModelAttribute("user") @Valid UserRegistrationDto userDto,
			BindingResult result) {


        User existingEmail = userService.findByEmail(userDto.getEmail());
        User existingUsername = userService.findByUsername(userDto.getUsername());
        if (existingEmail != null || existingUsername != null){
            result.rejectValue("email", null, "There is already an account registered with those details");
			return "register";
        }

        if (result.hasErrors()){
            return "register";
        }

        userService.save(userDto);
        return "redirect:/users?success";
    }

}
