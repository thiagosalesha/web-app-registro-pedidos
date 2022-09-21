package br.com.salesha.mvc.mudi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	private String username;
	private String password;
	private Boolean enabled;
	
	//Anotação Json para evitar loop por causa dos relacioanmentos (ex.: pedido contém oferta, oferta contém pedido)
	//Anotação de JPA para realizar o relacionamento (@OneToMany)
	//Cascade -> as alterações devem ser replicadas nos relacionamentos;
	//fetch -> Quando "LAZY" evita que o hibernate puxe todos os relacionamentos, a não ser que seja explicitamente pedido

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Pedido> pedido;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	
	
}