package br.com.salesha.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.salesha.mvc.mudi.dto.CadastroNovoProd;
import br.com.salesha.mvc.mudi.model.Pedido;
import br.com.salesha.mvc.mudi.repository.PedidoRepository;
import br.com.salesha.mvc.mudi.repository.UserRepository;

@Controller
public class PedidoController {

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	@GetMapping("pedido/formulario")
	public String novo(CadastroNovoProd cadastro) {
		return "pedido/formulario";
	}
	
	@PostMapping("pedido/cadastrar")
	public String cadastrar(@Valid CadastroNovoProd cadastro, BindingResult result) {
		if(result.hasErrors()) {
			return "pedido/formulario";
		}

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		
		Pedido pedido = cadastro.toPedido();
		pedido.setUser(userRepository.findByUsername(username));
		
		pedidoRepository.save(pedido);
		System.out.println("Entramos em cadastrar");
		return "redirect:/home";
	}
}
