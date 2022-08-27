package br.com.salesha.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PedidoController {

	@GetMapping("pedido/formulario")
	public String novo() {
		return "pedido/formulario";
	}
	
	@PostMapping("pedido/cadastrar")
	public String cadastrar() {
		System.out.println("Entramos em cadastrar");
		return "redirect:/home";
	}
}
