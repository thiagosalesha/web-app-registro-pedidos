package br.com.salesha.mvc.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.salesha.mvc.mudi.model.Pedido;
import br.com.salesha.mvc.mudi.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	List<Pedido> findByStatusPedido(StatusPedido aguardando);

	@Query("select p from Pedido p join p.user u where u.username = :usuario")
	List<Pedido> findAllbyUsuario(@Param("usuario") String usuario);


}
