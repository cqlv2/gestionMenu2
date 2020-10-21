package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.QuantiteProduit;

public interface QuantiteProduitRepository extends JpaRepository<QuantiteProduit, Integer>{

}
