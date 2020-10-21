package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Plat;

public interface PlatRepository extends JpaRepository<Plat, Integer>{

	List<Plat> findByNomContaining(String value);
	List<Plat> findByNote(int note);
	List<Plat> findByNoteGreaterThanEqual(int note);
	List<Plat> findByNoteLessThanEqual(int note);

}
