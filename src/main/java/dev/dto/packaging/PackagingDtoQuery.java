package dev.dto.packaging;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import dev.dto.SuperDto;
import dev.enumeration.PackagingEnum;
import dev.enumeration.UnitEnum;

//**json**
//	{ 
//		"id":1,
//		"packaging":"PAQUET",
//		"weight":"1230",
//		"unit":"GRAMME",
//		"productsId":[1,2,3],
//	}

/**
 * data transfer object between the service layer and the persistence layer.
 * adds a layer of security by validating values with
 * "javax.validation.constraints"
 * 
 * @author cql-v2
 * @version 0.1
 *
 */
public class PackagingDtoQuery extends SuperDto {

	@NotNull
	private PackagingEnum packaging;
	@NotNull
	private Float weight;
	@NotNull
	private UnitEnum unit;
	private List<Long> productsId = new ArrayList<>();

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

	public List<Long> getProductsId() {
		return productsId;
	}

	public void setProductsId(List<Long> productsId) {
		this.productsId = productsId;
	}

}
