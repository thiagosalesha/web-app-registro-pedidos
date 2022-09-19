package br.com.salesha.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.salesha.mvc.mudi.model.Pedido;
import br.com.salesha.mvc.mudi.model.StatusPedido;
import br.com.salesha.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/oferta")
public class OfertaController {
	
	@Autowired
	PedidoRepository pedidoRepository;

	@GetMapping
	public String getFormularioOferta (Model model) {
		
	/*	List<Pedido> lista = pedidoRepository.findAll();
		model.addAttribute("pedidos", lista); */
		return "oferta/home";
	}
}
