package dev.spec;

import dev.enumeration.PackagingEnum;
import dev.enumeration.UnitEnum;

public class ConditionnementParameters {

	private PackagingEnum packaging;
	private Float maxWeight;
	private Float minWeight;
	private UnitEnum unit;

	// getteur setteur

	public PackagingEnum getPackaging() {
		return packaging;
	}

	public void setPackaging(PackagingEnum packaging) {
		this.packaging = packaging;
	}

	public Float getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(Float maxWeight) {
		this.maxWeight = maxWeight;
	}

	public Float getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(Float minWeight) {
		this.minWeight = minWeight;
	}

	public UnitEnum getUnit() {
		return unit;
	}

	public void setUnit(UnitEnum unit) {
		this.unit = unit;
	}

}
