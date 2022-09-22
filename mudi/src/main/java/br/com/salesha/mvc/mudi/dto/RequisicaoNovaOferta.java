package br.com.salesha.mvc.mudi.dto;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.salesha.mvc.mudi.model.Oferta;

public class RequisicaoNovaOferta {
	
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private int pedidoId;
	
	@Pattern (regexp = "^\\d+(\\.\\d+{2})?$", message = "Não deve ser nulo") //adicionando um padrão para validação 
	@NotNull(message = "Não deve ser nulo")
	private String valor;
	
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Não deve ser nulo")
	@NotNull(message = "Não deve ser nulo")
	private String dataDaEntrega;
	private String comentario;
	
	
	public int getPedidoId() {
		return pedidoId;
	}
	public void setPedidoId(int pedidoId) {
		this.pedidoId = pedidoId;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getDataDaEntrega() {
		return dataDaEntrega;
	}
	public void setDataDaEntrega(String dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Oferta toOferta() {
		Oferta oferta = new Oferta();
		oferta.setId(this.pedidoId);
		oferta.setComentario(this.comentario);
		oferta.setDataDaEntrega(LocalDate.parse(this.dataDaEntrega, dtf));
		oferta.setValor(new BigDecimal(this.valor));
		
		return oferta;
	}

	
}
