package dev.dto;

import com.sun.istack.NotNull;

import dev.enumeration.Emballage;
import dev.enumeration.Unite;

public class ConditionnementDtoRequete {

	
	private Integer id = null;
	@NotNull
	private Emballage emballage;
	@NotNull
	private Integer poids;
	@NotNull
	private Unite unite;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Emballage getEmballage() {
		return emballage;
	}

	public void setEmballage(Emballage emballage) {
		this.emballage = emballage;
	}

	public Integer getPoids() {
		return poids;
	}

	public void setPoids(Integer poids) {
		this.poids = poids;
	}

	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

}
