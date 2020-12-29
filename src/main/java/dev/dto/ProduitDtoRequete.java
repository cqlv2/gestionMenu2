package dev.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;

import com.sun.istack.NotNull;

import dev.enumeration.Categorie;
import dev.enumeration.PackagingEnum;
import dev.enumeration.Magasin;
import dev.enumeration.UnitEnum;

//JSON A ENVOYER
//{
//	"id":"ID(OPTIONEL)",
//	"emballageCond":"LIBELLE",
//	"poidsCond":"LIBELLE",
//	"uniteCond":"LIBELLE",
//	"libelle":"LIBELLE",
//	"categorie":"CATEGORIE",
//	"prix":"PRIX",
//	"magasin":"MAGASIN",
//	"quantiteParPersonne":"QTEPERSONNE",
//	"unite":"UNITE"
//}

public class ProduitDtoRequete {
	private Integer id = null;
	private Integer idCond=null;

	@NotNull
	private PackagingEnum emballage;
	@NotNull
	private Integer poidsCond;
	@NotNull
	private UnitEnum uniteCond;

	@NotNull
	@NotEmpty
	@Length(max = 255)
	private String libelle;
	@NotNull
	private Categorie categorie;
	@NotNull
	private BigDecimal prix;
	private BigDecimal prixKg=null;
	@NotNull
	private Magasin magasin;
	@NotNull
	private Integer quantiteParPersonne;
	@NotNull
	private UnitEnum unite;

//	getteur setteur	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCond() {
		return idCond;
	}

	public void setIdCond(Integer idCond) {
		this.idCond = idCond;
	}

	public PackagingEnum getEmballage() {
		return emballage;
	}

	public void setEmballage(PackagingEnum emballage) {
		this.emballage = emballage;
	}

	public Integer getPoidsCond() {
		return poidsCond;
	}

	public void setPoidsCond(Integer poidsCond) {
		this.poidsCond = poidsCond;
	}

	public UnitEnum getUniteCond() {
		return uniteCond;
	}

	public void setUniteCond(UnitEnum uniteCond) {
		this.uniteCond = uniteCond;
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

	public UnitEnum getUnite() {
		return unite;
	}

	public void setUnite(UnitEnum unite) {
		this.unite = unite;
	}

}
