package dev.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import dev.enumeration.Categorie;
import dev.enumeration.Magasin;
import dev.enumeration.UnitEnum;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Packaging packaging;
	
	
	
	@Column(length = 1000)
	private String libelle;
	@Enumerated(EnumType.STRING)
	private Categorie categorie;
	@Column(precision = 6, scale = 2)
	private BigDecimal prix;
	@Column(name = "prix_kg", precision = 6, scale = 2)
	private BigDecimal prixKg;
	@Enumerated(EnumType.STRING)
	private Magasin magasin;
	private Integer quantiteParPersonne;
	@Enumerated(EnumType.STRING)
	private UnitEnum unite;

	
	
	

}
