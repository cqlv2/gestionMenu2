package dev.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.dto.PackagingDtoQuery;
import dev.dto.PackagingDtoResponse;
import dev.entity.SuperEntity;
import dev.exceptions.repositoryException;
import dev.service.SuperService;
import dev.spec.ConditionnementFilters;

/**
 * super controller containing the API basic methods
 * 
 * @author cql-v2
 * @version 1.0
 * @param <T> entity to control
 * @param <S> entity service
 */
@RestController
@RequestMapping("")
public abstract class SuperController<T extends SuperEntity, S extends SuperService<T, ? extends JpaRepository<T, Long>, PackagingDtoResponse, PackagingDtoQuery>> {

	@Autowired
	protected S service;

	/**
	 * find all the entries in the database corresponding to the entity
	 * 
	 * @return a response entity(ok) from 0 to n value formatted in DTO
	 */
	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok().body(service.getAll());
	}

	/**
	 * 
	 * @param id id to search
	 * @return a response entity(ok) from 1 value formatted in DTO or a response
	 *         entity(badRequest) with repositoryException message
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok().body(service.getById(id));
		} catch (repositoryException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	/**
	 * add a new entry to the database
	 * 
	 * @param dtoQuery an instance of a dto Object parser with jackson
	 * @return a response entity(ok) with 1 value formatted in DTO
	 */
	@PostMapping
	public ResponseEntity<?> add(@RequestBody PackagingDtoQuery dtoQuery) {
		return ResponseEntity.ok().body(service.addUpdate(dtoQuery));

	}

	/**
	 * edit an entry to the database
	 * 
	 * @param dtoQuery an instance of a dto Object parser with jackson
	 * @return a response entity(ok) with 1 value formatted in DTO
	 */
	@PutMapping
	public ResponseEntity<?> edit(@RequestBody PackagingDtoQuery dtoQuery) {
		return ResponseEntity.ok().body(service.addUpdate(dtoQuery));
	}

	/**
	 * removes an entry from the database from an id or throws an exception if the id does not exist
	 * @param id id to remove
	 * @return a response entity(ok) with 'OK' or a response
	 *         entity(badRequest) with repositoryException message
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		try {
			service.delete(id);
			return ResponseEntity.ok().body("OK");
		} catch (repositoryException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
