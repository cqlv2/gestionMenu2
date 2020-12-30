package dev.controlleur;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entity.Packaging;
import dev.service.PackagingService;
import dev.spec.ConditionnementFilters;

@RestController
@RequestMapping("/api/packaging")

public class PackagingCtrl extends SuperController<Packaging, PackagingService> {

	/**
	 * find a list of entry from the database corresponding a list of filters sent in json format
	 * @param filters an instance of the Packaging Filter class parssed with jackson
	 * @return a response entity(ok) from 0 to n value formatted in DTO
	 */
	@GetMapping("/filters")
	public ResponseEntity<?> findByFilters(@RequestBody ConditionnementFilters filters) {
			return ResponseEntity.ok().body(service.getBy(filters));
	}

}
