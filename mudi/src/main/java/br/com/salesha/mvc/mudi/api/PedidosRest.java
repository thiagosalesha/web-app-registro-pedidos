package br.com.salesha.mvc.mudi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.salesha.mvc.mudi.model.Pedido;
import br.com.salesha.mvc.mudi.model.StatusPedido;
import br.com.salesha.mvc.mudi.repository.PedidoRepository;


@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {
	
	@Autowired
	private PedidoRepository pedidoRepo;
	
	@GetMapping("id")
	public List<Pedido> getPedidosPorId() {
		
		Sort sort =  Sort.by("valor").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		return pedidoRepo.findAllByStatusPedido(StatusPedido.AGUARDANDO, paginacao);
	}

}
