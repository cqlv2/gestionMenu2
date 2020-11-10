package dev.controlleur;

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

import dev.dto.PlatDtoRequete;
import dev.exception.sqlException;
import dev.service.PlatService;

@RestController
@CrossOrigin
@RequestMapping("/plat")
public class PlatCtrl {
	private PlatService platServ;

	public PlatCtrl(PlatService platServ) {
		this.platServ = platServ;
	}

	@GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok().body(platServ.getAll());
	}

	@GetMapping(params = "id")
	public ResponseEntity<?> getById(@RequestParam Integer id) {
		try {
			return ResponseEntity.ok().body(platServ.getById(id));
		} catch (sqlException e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		}
	}

	@PostMapping
	public ResponseEntity<?> addPlat(@Valid @RequestBody PlatDtoRequete dtoReq, BindingResult res) {
		if (!res.hasErrors())
			try {
				return ResponseEntity.ok().body(platServ.addEdit(dtoReq));
			} catch (sqlException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
		else
			return ResponseEntity.badRequest().body(res.getAllErrors());
	}
	
	@PutMapping
	public ResponseEntity<?> editPlat(@Valid @RequestBody PlatDtoRequete dtoReq, BindingResult res) {
		if (!res.hasErrors())
			try {
				return ResponseEntity.ok().body(platServ.addEdit(dtoReq));
			} catch (sqlException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
		else
			return ResponseEntity.badRequest().body(res.getAllErrors());
	}

}
