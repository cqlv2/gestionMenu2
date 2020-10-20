package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Conditionnement;
import dev.enumeration.Emballage;

public interface ConditionnementRepository extends JpaRepository<Conditionnement, Integer>{

	List<Conditionnement> findByEmballage(Emballage valueOf);

}
