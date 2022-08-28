package br.com.salesha.mvc.mudi.dto;

import javax.validation.constraints.NotBlank;

import br.com.salesha.mvc.mudi.model.Pedido;
import br.com.salesha.mvc.mudi.model.StatusPedido;

public class CadastroNovoProd {
	
	@NotBlank(message = "Campo Obrigatório!") 
	private String nmProd;
	
	@NotBlank(message = "Campo Obrigatório!")
	private String urlProd;

	@NotBlank(message = "Campo Obrigatório!") 
	private String imgProd;
	private String dscProd;
	
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNomeProd(this.nmProd);
		pedido.setUrlProd(this.urlProd);
		pedido.setUrlImg(this.imgProd);
		pedido.setDescProd(this.dscProd);
		pedido.setStatusPedido(StatusPedido.APROVADO);
	
		return pedido;
		
	}
		
	public String getNmProd() {
		return nmProd;
	}
	public void setNmProd(String nmProd) {
		this.nmProd = nmProd;
	}
	public String getUrlProd() {
		return urlProd;
	}
	public void setUrlProd(String urlProd) {
		this.urlProd = urlProd;
	}
	public String getImgProd() {
		return imgProd;
	}
	public void setImgProd(String imgProd) {
		this.imgProd = imgProd;
	}
	public String getDscProd() {
		return dscProd;
	}
	public void setDscProd(String dscProd) {
		this.dscProd = dscProd;
	}
	
	
}
