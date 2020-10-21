package dev.controlleur;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.service.QuantiteProduitService;

@RestController
@CrossOrigin
@RequestMapping("/quantite-produit")
public class QuantiteProduitCtrl {

	private QuantiteProduitService qtePrServ;

	public QuantiteProduitCtrl(QuantiteProduitService qtePrServ) {
		this.qtePrServ = qtePrServ;
	}

	@GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok().body(qtePrServ.getAll());
	}

}
