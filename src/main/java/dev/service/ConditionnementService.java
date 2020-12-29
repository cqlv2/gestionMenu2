package dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import dev.dto.PackagingDtoResponse;
import dev.entity.Packaging;
import dev.exception.repositoryException;
import dev.repository.ConditionnementRepository;
import dev.spec.ConditionnementParameters;
import dev.spec.ConditionnementSpecs;
import dev.utils.transformer.PackagingTransformer;

@Service
public class ConditionnementService {

	private ConditionnementRepository condRepo;

	// constructor

	public ConditionnementService(ConditionnementRepository condRepo) {
		this.condRepo = condRepo;
	}

	// lire tout

	public List<PackagingDtoResponse> getAll() {
		List<PackagingDtoResponse> list = new ArrayList<PackagingDtoResponse>();
		for (Packaging c : condRepo.findAll()) {
			list.add(PackagingTransformer.entityToDtoResponse(c));
		}
		return list;
	}

	// lire par filtre depuis un json

	public List<PackagingDtoResponse> getBy(ConditionnementParameters params) {
		Specification<Packaging> spec1 = ConditionnementSpecs.packagingEquals(params.getPackaging());
		Specification<Packaging> spec2 = ConditionnementSpecs.weightGreaterThanEquals(params.getMinWeight());
		Specification<Packaging> spec3 = ConditionnementSpecs.weightLessThanEquals(params.getMaxWeight());
		Specification<Packaging> spec4 = ConditionnementSpecs.unitEquals(params.getUnit());
		Specification<Packaging> spec = Specification.where(spec1).and(spec2).and(spec3).and(spec4);
		List<PackagingDtoResponse> list = new ArrayList<PackagingDtoResponse>();
		for (Packaging cond : condRepo.findAll(spec)) {
			list.add(PackagingTransformer.entityToDtoResponse(cond));
		}
		return list;
	}

	// lire par id
	public PackagingDtoResponse getById(Integer id) throws repositoryException {
		Optional<Packaging> opt = condRepo.findById(id);
		if (opt.isPresent()) 
			return PackagingTransformer.entityToDtoResponse(opt.get());
		 else
			throw new repositoryException("id non trouvée");

	}

}
