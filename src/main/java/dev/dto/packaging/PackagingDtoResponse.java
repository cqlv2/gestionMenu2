package dev.dto.packaging;

import dev.dto.SuperDto;
import dev.entity.Packaging;
import dev.enumeration.PackagingEnum;
import dev.enumeration.UnitEnum;

/**
 * data transfer object between the persistence layer and the service layer.
 * Ignore the product list to avoid redundancies
 * 
 * @author cql-v2
 * @version 1.0
 */
public class PackagingDtoResponse extends SuperDto {

	private PackagingEnum packaging;
	private Float weight;
	private UnitEnum unit;

	// constructors

	public PackagingDtoResponse() {

	}

	public PackagingDtoResponse(Packaging packaging) {
		this.id = packaging.getId();
		this.packaging = packaging.getPackaging();
		this.weight = packaging.getWeight();
		this.unit = packaging.getUnit();
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

}
