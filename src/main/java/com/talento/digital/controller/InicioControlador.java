package com.talento.digital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioControlador {
	
	
	@GetMapping("/")
	public String mostrarInicio() {
		return "index";
	}

	@GetMapping("/login")
	public String mostrarLogin() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String mostrarLogout() {
		return "logout";
	}
	
	@GetMapping("/serviciopremium")
	public String mostrarServicioPremiun() {
		return "serviciopremium";
	}
	
	@GetMapping("/servicioturismo")
	public String mostrarServicioTurismo() {
		return "servicioturismo";
	}

	@GetMapping("/accesodenegado")
	public String mostrarAccesoDenegado() {
		return "accesodenegado";
	}
	
	
	
}
