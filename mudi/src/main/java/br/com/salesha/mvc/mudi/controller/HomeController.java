package br.com.salesha.mvc.mudi.controller;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.salesha.mvc.mudi.model.Pedido;
import br.com.salesha.mvc.mudi.model.StatusPedido;
import br.com.salesha.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	
	// A classe Principal fornece dados do usuário atualmente logado
	// Funcionamento dessa classe: Acredito que deve buscar atributos da session
	// O spring instacia a classe Prinpal, assim como Model
	@GetMapping
	public String home(Model model, Principal principal) {
		
		//principal.getName() -> método para buscar o nome do usuário atualmente logado	
		List<Pedido> lista = pedidoRepository.findAllbyUsuario(principal.getName());
		model.addAttribute("lista", lista);
		return "home";
	}
	
	@GetMapping("/{status}")
	public String aguardando(@PathVariable("status") String status, Model model) {

		List<Pedido> lista = pedidoRepository.findByStatusPedido(StatusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("lista", lista);
		return "home";
	}
}
