package dev.controlleur;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.service.ProduitService;

@RestController
@CrossOrigin
@RequestMapping("/produit")
public class ProduitCtrl {

	private ProduitService prodServ;

	public ProduitCtrl(ProduitService prodServ) {
		this.prodServ = prodServ;
	}
	
	
}
