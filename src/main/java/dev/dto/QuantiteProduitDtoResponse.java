package dev.dto;

import dev.entity.Produit;
import dev.enumeration.Unite;

public class QuantiteProduitDtoResponse {

	private Integer id;
	private ProduitDtoResponse produitDtoRep;
	private Integer quantite;
	private Unite unite;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProduitDtoResponse getProduitDtoRep() {
		return produitDtoRep;
	}

	public void setProduitDtoRep(ProduitDtoResponse produitDtoRep) {
		this.produitDtoRep = produitDtoRep;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

}
