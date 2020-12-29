package dev.dto;

import java.math.BigDecimal;

import dev.entity.Packaging;
import dev.enumeration.Categorie;
import dev.enumeration.Magasin;
import dev.enumeration.UnitEnum;

public class ProduitDtoResponse {

	private Integer id;
	private PackagingDtoResponse packaging;
	private String libelle;
	private Categorie categorie;
	private BigDecimal prix;
	private BigDecimal prixKg;
	private Magasin magasin;
	private Integer quantiteParPersonne;
	private UnitEnum unite;


}
