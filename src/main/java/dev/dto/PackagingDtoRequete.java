package dev.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import dev.enumeration.PackagingEnum;
import dev.enumeration.UnitEnum;

/**
 * data transfer object between the service layer and the persistence layer.
 * adds a layer of security by validating values with
 * "javax.validation.constraints"
 * 
 * @author cql-v2
 * @version 0.1
 *
 */
public class PackagingDtoRequete {

	private Integer id = null;
	@NotNull
	private PackagingEnum packaging;
	@NotNull
	private Integer weight;
	@NotNull
	private UnitEnum unit;
	private List<Integer> productsId = new ArrayList<Integer>();

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

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public UnitEnum getUnit() {
		return unit;
	}

	public void setUnit(UnitEnum unit) {
		this.unit = unit;
	}

	public List<Integer> getProductsId() {
		return productsId;
	}

	public void setProductsId(List<Integer> productsId) {
		this.productsId = productsId;
	}

}
