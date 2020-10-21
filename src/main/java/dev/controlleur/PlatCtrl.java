package dev.controlleur;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
