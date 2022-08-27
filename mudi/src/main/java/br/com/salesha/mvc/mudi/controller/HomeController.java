package br.com.salesha.mvc.mudi.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.salesha.mvc.mudi.model.Pedido;
import br.com.salesha.mvc.mudi.repository.PedidoRepository;

@Controller
public class HomeController {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@GetMapping("/home")
	public String home(Model model) {
		
		
		List<Pedido> lista = pedidoRepository.findAll();
		model.addAttribute("lista", lista);
		return "home";
	}
}
