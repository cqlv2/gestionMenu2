package dev.controlleur;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.dto.ProduitDtoRequete;
import dev.enumeration.Categorie;
import dev.enumeration.Magasin;
import dev.exception.UniteException;
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
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok().body(prodServ.getAll());
	}

	@GetMapping(params = "id")
			public ResponseEntity<?> getById(@RequestParam int id) {
		try {
			return ResponseEntity.ok().body(prodServ.getById(id));
		} catch (sqlException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/filter")
	public ResponseEntity<?> getByFiltres(@RequestParam(name = "libelle", required = false) String libelle,
			@RequestParam(name = "categorie", required = false) String categorie,
			@RequestParam(name = "magasin", required = false) String magasin,
			@RequestParam(name = "prixmin", required = false) String prixmin,
			@RequestParam(name = "prixmax", required = false) String prixmax,
			@RequestParam(name = "prixkgmin", required = false) String prixkgmin,
			@RequestParam(name = "prixkgmax", required = false) String prixkgmax,
			@RequestParam(name = "search", required = false) String search) {

		return ResponseEntity.ok().body(
				prodServ.searchByFilters(libelle, categorie, magasin, prixmin, prixmax, prixkgmin, prixkgmax, search));
	}

	@GetMapping("/enums")
	public ResponseEntity<?> getAllEnum() {
		@SuppressWarnings("rawtypes")
		Map<String, List> mapEnum = new HashMap<String, List>();
		mapEnum.put("categories", prodServ.getAllCat());
		mapEnum.put("Magasins", prodServ.getAllMagasin());
		mapEnum.put("unites", prodServ.getAllUnit());
		mapEnum.put("conditionnements", prodServ.getAllConditionnement());
		return ResponseEntity.ok().body(mapEnum);
	}

	@PostMapping
	public ResponseEntity<?> addNew(@Valid @RequestBody ProduitDtoRequete prReq, BindingResult res) {
		if (!res.hasErrors()) {
			try {
				return ResponseEntity.ok().body(prodServ.addEdit(prReq));
			} catch (sqlException | UniteException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}

		} else {
			return ResponseEntity.badRequest().body(res.getAllErrors());
		}
	}

	@PutMapping
	public ResponseEntity<?> edit(@Valid @RequestBody ProduitDtoRequete prReq, BindingResult res) {
		if (!res.hasErrors()) {
			try {
				return ResponseEntity.ok().body(prodServ.addEdit(prReq));
			} catch (sqlException | UniteException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}

		} else {
			return ResponseEntity.badRequest().body(res.getAllErrors());
		}
	}

}
