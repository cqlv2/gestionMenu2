package dev.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import dev.enumeration.Emballage;
import dev.enumeration.Unite;

public class ConditionnementDtoResponse {

	private Integer id;
	private Emballage emballage;
	private Integer poids;
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
