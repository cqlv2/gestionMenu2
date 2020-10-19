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
	@Column(name = "nombre_piece")
	private Integer nombrePiece;
	@Column(name = "poids_piece", precision = 6, scale = 2)
	private BigDecimal poidsPiece;
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

	public Integer getNombrePiece() {
		return nombrePiece;
	}

	public void setNombrePiece(Integer nombrePiece) {
		this.nombrePiece = nombrePiece;
	}

	public BigDecimal getPoidsPiece() {
		return poidsPiece;
	}

	public void setPoidsPiece(BigDecimal poidsPiece) {
		this.poidsPiece = poidsPiece;
	}

	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

}
