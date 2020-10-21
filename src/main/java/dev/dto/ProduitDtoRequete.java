package dev.dto;

import java.math.BigDecimal;

import dev.entity.Conditionnement;
import dev.enumeration.Categorie;
import dev.enumeration.Magasin;
import dev.enumeration.Unite;

public class ProduitDtoRequete {
	private Integer id = null;
	private Integer conditionnementId;
	private String libelle;
	private Categorie categorie;
	private BigDecimal prix;
	private BigDecimal prixKg;
	private Magasin magasin;
	private Integer quantiteParPersonne;
	private Unite unite;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getConditionnementId() {
		return conditionnementId;
	}

	public void setConditionnementId(Integer conditionnementId) {
		this.conditionnementId = conditionnementId;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public BigDecimal getPrixKg() {
		return prixKg;
	}

	public void setPrixKg(BigDecimal prixKg) {
		this.prixKg = prixKg;
	}

	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	public Integer getQuantiteParPersonne() {
		return quantiteParPersonne;
	}

	public void setQuantiteParPersonne(Integer quantiteParPersonne) {
		this.quantiteParPersonne = quantiteParPersonne;
	}

	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

}
