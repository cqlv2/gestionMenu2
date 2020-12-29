package dev.spec;

import org.springframework.data.jpa.domain.Specification;

import dev.entity.Packaging;
import dev.enumeration.PackagingEnum;
import dev.enumeration.UnitEnum;

public class ConditionnementSpecs {
	// filter by packaging
	public static Specification<Packaging> packagingEquals(PackagingEnum packagingEnum) {
		return (root, query, builder) -> packagingEnum == null ? builder.conjunction()
				: builder.equal(root.get("packaging"), packagingEnum);
	}

	// filter by max weight
	public static Specification<Packaging> weightLessThanEquals(Float maxWeight) {
		return (root, query, builder) -> maxWeight == null ? builder.conjunction()
				: builder.lessThanOrEqualTo(root.get("weight"), maxWeight);
	}

	// filter by min weight
	public static Specification<Packaging> weightGreaterThanEquals(Float minWeight) {
		return (root, query, builder) -> minWeight == null ? builder.conjunction()
				: builder.greaterThanOrEqualTo(root.get("weight"), minWeight);
	}

	// filter by unit
	public static Specification<Packaging> unitEquals(UnitEnum unitEnum) {
		return (root, query, builder) -> unitEnum == null ? builder.conjunction()
				: builder.equal(root.get("unit"), unitEnum);
	}

}
