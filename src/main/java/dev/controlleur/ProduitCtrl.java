package dev.controlleur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@GetMapping("/enums")
	public ResponseEntity<?> getAllEnum(){
		@SuppressWarnings("rawtypes")
		Map<String, List> mapEnum=new HashMap<String,List>();
		mapEnum.put("categories",prodServ.getAllCat());
		mapEnum.put("Magasins",prodServ.getAllMagasin());
		mapEnum.put("unites",prodServ.getAllUnit());
		mapEnum.put("conditionnements",prodServ.getAllConditionnement());
		return ResponseEntity.ok().body(mapEnum);
	}
	
	
}
