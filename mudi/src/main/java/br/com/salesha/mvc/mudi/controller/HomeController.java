package br.com.salesha.mvc.mudi.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.salesha.mvc.mudi.model.Pedido;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();
		pedido.setNomeProd("Smartphone Asus Zenfone 3");
		pedido.setDescProd("Dual Chip Android 6.0 Tela 5.2\" Snapdragon 16GB 4G Câmera 16MP - Preto Safira");
		pedido.setUrlProd("https://www.americanas.com.br/produto/131017515");
		pedido.setUrlImg("https://images-americanas.b2w.io/produtos/01/00/item/131017/5/131017515SZ.jpg");
		pedido.setValor(new BigDecimal(1190));
		
		List<Pedido> lista = Arrays.asList(pedido, pedido, pedido);
		model.addAttribute("lista", lista);
		return "home";
	}
}
