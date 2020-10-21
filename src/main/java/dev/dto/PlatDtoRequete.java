package dev.dto;

import java.util.ArrayList;
import java.util.List;

public class PlatDtoRequete {
	private Integer id =null;
	private String nom;
	private Integer note=0;
	private List<Integer> produitsId=new ArrayList<Integer>();

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

	public List<Integer> getProduitsId() {
		return produitsId;
	}

	public void setProduitsId(List<Integer> produitsId) {
		this.produitsId = produitsId;
	}

}
