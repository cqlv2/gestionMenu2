package dev.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dev.enumeration.Categorie;
import dev.enumeration.Magasin;
import dev.enumeration.Unite;

@Entity
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "conditionnement_id")
	private Conditionnement conditionnement;
	@Column(length = 1000)
	private String libelle;
	@Enumerated(EnumType.STRING)
	private Categorie categorie;
	@Column(precision = 6, scale = 2)
	private BigDecimal prix;
	@Column(name = "prix_kg", precision = 6, scale = 2)
	private BigDecimal prixKg;
	@Enumerated(EnumType.STRING)
	private Magasin magasin;
	private Integer quantiteParPersonne;
	@Enumerated(EnumType.STRING)
	private Unite unite;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Conditionnement getConditionnement() {
		return conditionnement;
	}

	public void setConditionnement(Conditionnement conditionnement) {
		this.conditionnement = conditionnement;
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
