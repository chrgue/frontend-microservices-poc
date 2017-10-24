package com.chrgue.poc.spiderman;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SpringBootApplication
public class Spiderman {

	public static void main(String[] args) {
		SpringApplication.run(Spiderman.class, args);
	}

	@GetMapping("/")
	public ModelAndView main(ModelAndView mav,
			HttpServletRequest request,
			HttpServletResponse response) {

		Util.addToResponse(request, response);
		mav.setViewName("fragment");
		return mav;
	}
}
