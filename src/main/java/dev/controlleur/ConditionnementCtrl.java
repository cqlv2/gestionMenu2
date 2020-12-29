package dev.controlleur;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.exception.repositoryException;
import dev.service.ConditionnementService;
import dev.spec.ConditionnementParameters;

@RestController
@CrossOrigin
@RequestMapping("/packaging")

public class ConditionnementCtrl {

	private ConditionnementService condServ;

	public ConditionnementCtrl(ConditionnementService condServ) {
		this.condServ = condServ;
	}



}
