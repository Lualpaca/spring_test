package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}

	@GetMapping("/string")
	private String param(@RequestParam(name="texto", required = false) String texto, Model model) {
		model.addAttribute("resultado", "El texto es: "+texto);
		return "params/ver";
	}

	@GetMapping("/mix-params")
	private String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("resultado", "El saludo es: '" + saludo + "' y el número es '" + numero +"'");
		return "params/ver";
	}

	@GetMapping("/mix-params-request")
	private String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
			System.out.println("Numero: "+numero);
			System.out.println("Saludo: "+saludo);
			
		} catch (NumberFormatException e) {
			numero=0;
		}
		
		model.addAttribute("resultado", "El saludo es: '" + saludo + "' y el número es '" + numero +"'");
		return "params/ver";
	}
}
