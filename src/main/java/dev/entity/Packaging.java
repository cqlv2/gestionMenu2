package dev.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import dev.enumeration.PackagingEnum;
import dev.enumeration.UnitEnum;

/**
 * entity for the management of product packaging. The units are managed from
 * the "unitEnnum" enumeration. The packages are managed from the
 * "packagingEnnum" enumeration. Created the "packaging" table in the database
 * with a 1n relationship with the "Product" table
 * 
 * @author cql-v2
 * @version 1.0
 */
@Entity
public class Packaging extends SuperEntity {

	@Enumerated(EnumType.STRING)
	private PackagingEnum packaging;

	private Float weight;

	@Enumerated(EnumType.STRING)
	private UnitEnum unit;

	@OneToMany(targetEntity = Product.class, mappedBy = "packaging")
	private List<Product> products;

	// getteur setteur

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
