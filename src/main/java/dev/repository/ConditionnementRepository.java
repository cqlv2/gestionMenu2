package dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Conditionnement;
import dev.enumeration.Emballage;
import dev.enumeration.Unite;

public interface ConditionnementRepository extends JpaRepository<Conditionnement, Integer>{

	List<Conditionnement> findByEmballage(Emballage valueOf);

	Optional<Conditionnement> findByEmballageAndPoidsAndUnite(Emballage emballage, Integer poidsCond, Unite uniteCond);

}
