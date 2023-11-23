package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("//costumers")
public class CustomerController {

	@GetMapping("/insertCustomer")
	public ModelAndView insertCurtomer(ModelAndView model) {
		model.addObject("id", "25");
		model.addObject("name", "Annie");
		model.addObject("lastName", "Clinton");
		model.setViewName("costumers/insertCustomer");

		return model;
	}
}
