package com.chrgue.poc.hulk;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SpringBootApplication
public class Hulk {

	public static void main(String[] args) {
		SpringApplication.run(Hulk.class, args);
	}

	@Autowired
	private LinkHeaderService linkHeaderService;

	@GetMapping("/")
	public ModelAndView main(ModelAndView mav,
			HttpServletRequest request,
			HttpServletResponse response) {

		linkHeaderService.addToResponse(request, response);
		mav.setViewName("fragment");
		return mav;
	}
}
