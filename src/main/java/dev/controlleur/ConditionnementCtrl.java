package dev.controlleur;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.service.ConditionnementService;

@RestController
@CrossOrigin
@RequestMapping("/conditionnement")

public class ConditionnementCtrl {

	private ConditionnementService condServ;

	public ConditionnementCtrl(ConditionnementService condServ) {
		this.condServ = condServ;
	}

	@GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok().body(condServ.getAll());
	}

}
