package dev.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.controlleur.ProduitCtrl;
import dev.entity.Produit;
import dev.enumeration.Categorie;
import dev.enumeration.Magasin;

public interface ProduitRepository extends JpaRepository<Produit, Integer>{

	List<Produit> findByLibelleContaining(String value);
	List<Produit> findBycategorie(Categorie valueOf);
	List<Produit> findByPrixGreaterThanEqual(BigDecimal bigDecimal);
	List<Produit> findByPrixLessThan(BigDecimal bigDecimal);
	List<Produit> findByPrixKgGreaterThanEqual(BigDecimal bigDecimal);
	List<Produit> findByPrixKgLessThan(BigDecimal bigDecimal);
	List<Produit> findByMagasin(Magasin valueOf);

}
