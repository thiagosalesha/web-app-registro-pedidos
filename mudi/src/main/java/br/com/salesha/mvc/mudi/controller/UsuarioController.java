package br.com.salesha.mvc.mudi.controller;

import java.security.Principal;
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
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	
	// A classe Principal fornece dados do usuário atualmente logado
	// Funcionamento dessa classe: Acredito que deve buscar atributos da session
	// O spring instacia a classe Prinpal, assim como Model
	@GetMapping("pedido")
	public String home(Model model, Principal principal) {
		
		//principal.getName() -> método para buscar o nome do usuário atualmente logado	
		List<Pedido> lista = pedidoRepository.findAllbyUsuario(principal.getName());
		model.addAttribute("lista", lista);
		return "usuario/home";
	}
	
	@GetMapping("pedido/{status}")
	public String aguardando(@PathVariable("status") String status, Model model, Principal principal) {

		List<Pedido> lista = pedidoRepository.findByStatusPedidoEUsuario(StatusPedido.valueOf(status.toUpperCase()), principal.getName());
		model.addAttribute("lista", lista);
		return "usuario/home";
	}

}
