package dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import dev.dto.PackagingDtoQuery;
import dev.dto.PackagingDtoResponse;
import dev.entity.Packaging;
import dev.exceptions.repositoryException;
import dev.repository.PackagingRepository;
import dev.spec.ConditionnementFilters;
import dev.spec.ConditionnementSpecs;
import dev.utils.transformer.PackagingTransformer;

@Service
public class PackagingService
		extends SuperService<Packaging, PackagingRepository, PackagingDtoResponse, PackagingDtoQuery> {

	/**
	 * find a list of entry from the database corresponding a list of filters
	 * 
	 * @param params instance of the Packaging Filter class. each non-null attribute
	 *               of the class will be added to the filter list
	 * @return 0 to n value formatted in DTO corresponding to the filter list
	 */

	public List<PackagingDtoResponse> getBy(ConditionnementFilters params) {
		Specification<Packaging> spec1 = ConditionnementSpecs.packagingEquals(params.getPackaging());
		Specification<Packaging> spec2 = ConditionnementSpecs.weightGreaterThanEquals(params.getMinWeight());
		Specification<Packaging> spec3 = ConditionnementSpecs.weightLessThanEquals(params.getMaxWeight());
		Specification<Packaging> spec4 = ConditionnementSpecs.unitEquals(params.getUnit());
		Specification<Packaging> spec = Specification.where(spec1).and(spec2).and(spec3).and(spec4);
		List<PackagingDtoResponse> list = new ArrayList<PackagingDtoResponse>();
		for (Packaging cond : repository.findAll(spec)) {
			list.add(PackagingTransformer.entityToDtoResponse(cond));
		}
		return list;
	}

}
