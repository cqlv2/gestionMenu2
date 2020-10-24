package dev.controlleur;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.exception.sqlException;
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
	@GetMapping(params = "id")
	public ResponseEntity<?> getById(@RequestParam int id){
		try {
			return ResponseEntity.ok().body(prodServ.getById(id));
		} catch (sqlException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
}
