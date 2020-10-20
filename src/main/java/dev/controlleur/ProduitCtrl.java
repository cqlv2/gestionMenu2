package dev.controlleur;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok().body(prodServ.getAll());
	}
	
	
}
