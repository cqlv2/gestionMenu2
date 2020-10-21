package dev.dto;

import java.util.ArrayList;
import java.util.List;

public class platDtoResponse {
	private Integer id;
	private String nom;
	private Integer note;
	private List<ProduitDtoResponse> ProduitsDtoResponse=new ArrayList<ProduitDtoResponse>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public List<ProduitDtoResponse> getProduitsDtoResponse() {
		return ProduitsDtoResponse;
	}

	public void setProduitsDtoResponse(List<ProduitDtoResponse> produitsDtoResponse) {
		ProduitsDtoResponse = produitsDtoResponse;
	}

}
