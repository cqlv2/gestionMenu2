package dev.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import dev.enumeration.Emballage;
import dev.enumeration.Unite;

@Entity
public class Conditionnement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Enumerated(EnumType.STRING)
	private Emballage emballage;
	private Integer poids;
	@Enumerated(EnumType.STRING)
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
