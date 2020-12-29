package dev.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import dev.enumeration.PackagingEnum;
import dev.enumeration.UnitEnum;

/**
 * entity for the management of product packaging indexed on the auto-generate
 * id of type integer the units are managed from the "UNITE" enumeration the
 * packages are managed from the "EMBALLAGE" enumeration created the
 * "CONDITIONNEMENT" table in the database with a 1n relationship with the
 * "PRODUIT" table
 * 
 * 
 * @author cql-v2
 * @version 0.1
 */
@Entity
public class Packaging {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private PackagingEnum packaging;

	private Float weight;

	@Enumerated(EnumType.STRING)
	private UnitEnum unit;

	@OneToMany(targetEntity = Product.class, mappedBy = "packaging")
	private List<Product> products;

	// getteur setteur

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PackagingEnum getPackaging() {
		return packaging;
	}

	public void setPackaging(PackagingEnum packaging) {
		this.packaging = packaging;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public UnitEnum getUnit() {
		return unit;
	}

	public void setUnit(UnitEnum unit) {
		this.unit = unit;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
