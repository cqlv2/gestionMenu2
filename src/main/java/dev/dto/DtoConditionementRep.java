package dev.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import dev.enumeration.Emballage;
import dev.enumeration.Unite;

public class DtoConditionementRep {

	private Integer id;
	private Emballage emballage;
	private Integer nombrePiece;
	private BigDecimal poidsPiece;

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
	private Unite unite;
}
