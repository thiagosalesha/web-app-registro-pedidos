package br.com.salesha.mvc.mudi.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.salesha.mvc.mudi.dto.RequisicaoNovaOferta;
import br.com.salesha.mvc.mudi.model.Oferta;
import br.com.salesha.mvc.mudi.model.Pedido;
import br.com.salesha.mvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {
	
	@Autowired
	private PedidoRepository repository;
	
	public Oferta criaOferta (RequisicaoNovaOferta requisicao) {
		Optional<Pedido> pedidoBuscado = repository.findById(requisicao.getPedidoId());
		if(!pedidoBuscado.isPresent()) {
			return null;
		}
		
		Pedido pedido = pedidoBuscado.get();
		Oferta nova = requisicao.toOferta();
		nova.setPedido(pedido);
		pedido.getOferta().add(nova);		
		repository.save(pedido);
		return nova;
		
	}
}
