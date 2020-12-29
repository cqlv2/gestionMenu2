package dev.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.entity.Product;
import dev.enumeration.Categorie;
import dev.enumeration.Magasin;

public interface ProduitRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product>{

	List<Product> findByLibelleContaining(String value);
	List<Product> findBycategorie(Categorie valueOf);
	List<Product> findByPrixGreaterThanEqual(BigDecimal bigDecimal);
	List<Product> findByPrixLessThan(BigDecimal bigDecimal);
	List<Product> findByPrixKgGreaterThanEqual(BigDecimal bigDecimal);
	List<Product> findByPrixKgLessThan(BigDecimal bigDecimal);
	List<Product> findByMagasin(Magasin valueOf);
	List<Product> findByCategorieAndMagasin(Categorie cat, Magasin mag);
	List<Product> findByMagasinAndCategorieAndLibelleContaining(Magasin magasin, Categorie categorie, String recherche);

	
	
	
}
