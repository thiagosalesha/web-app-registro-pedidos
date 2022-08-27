package br.com.salesha.mvc.mudi.dto;

import br.com.salesha.mvc.mudi.model.Pedido;

public class CadastroNovoProd {
	private String nmProd;
	private String urlProd;
	private String imgProd;
	private String dscProd;
	
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNomeProd(this.nmProd);
		pedido.setUrlProd(this.urlProd);
		pedido.setUrlImg(this.imgProd);
		pedido.setDescProd(this.dscProd);
	
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
