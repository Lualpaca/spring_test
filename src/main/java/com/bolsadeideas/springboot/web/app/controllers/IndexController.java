package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bolsadeideas.springboot.web.app.models.Producto;
import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("//app") // Routes of first level
public class IndexController {

	@GetMapping("/login")
	public ModelAndView login(ModelAndView mv) {
		mv.addObject("user", "Marjorie");
		// Customer path under directory
		mv.setViewName("login/login");
		return mv;
	}

	// @RequestMapping(value = "/index",method = RequestMethod.GET)
	@GetMapping({ "/index", "/", "/home" })
	public String index(Model model) {
		model.addAttribute("name", "Luis Pava");
		return "index";
	}

	// Mapping to route for load the views
	@GetMapping("/products")
	public String products(Map<String, Object> map) {
		map.put("product", "Apple");
		map.put("title", "Products");

		return "products";
	}

	@GetMapping({ "/customers", "/clientes" })
	public ModelAndView customers(ModelAndView mv) {
		mv.addObject("customer", "Carlos Manuel Pava");
		mv.addObject("title", "customers");
		mv.setViewName("customers");
		return mv;
	}

	@GetMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Luis");
		usuario.setApellido("Pava");
		usuario.setEmail("lpava@gmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo",
				"El perfil cargado es: ".concat(usuario.getNombre() + " " + usuario.getApellido()));

		return "perfil";

	}

	@GetMapping("/listar")
	private String listar(Model model) {

		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Andres", "Polo", "ad@gmail.com"));
		usuarios.add(new Usuario("John", "Polo", "ad@gmail.com"));
		usuarios.add(new Usuario("Carolina", "Polo", "ad@gmail.com"));

		model.addAttribute("titulo", "Listado de Usuarios");
		model.addAttribute("usuarios", usuarios);

		return "listar";
	}

	@GetMapping("/listarProductos")
	private ModelAndView listarProductos(ModelAndView model, Model mv) {
		List<Producto> productos = Arrays.asList(new Producto("2525", "Mouse", "15000"),
												 new Producto("2526", "Keyboard", "25000"), 
												 new Producto("2527", "Speakers", "56000"),
												 new Producto("2529", "Board", "560000"));

		mv.addAttribute("titulo", "Products");
		model.addObject("productos", productos);
		model.setViewName("listarProductos");

		return model;

	}

	@ModelAttribute("productos")
	public List<Producto> poblarProductos(){
		List<Producto> productos = Arrays.asList(new Producto("2525", "Mouse", "15000"),
				 new Producto("2526", "Keyboard", "25000"), 
				 new Producto("2527", "Speakers", "56000"),
				 new Producto("2529", "Board", "560000"));
		return productos;
		
	}
}
