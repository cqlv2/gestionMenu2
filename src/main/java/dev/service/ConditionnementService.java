package dev.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.dto.DtoConditionementRep;
import dev.entity.Conditionnement;
import dev.exception.sqlException;
import dev.repository.ConditionnementRepository;

@Service
public class ConditionnementService {

	private ConditionnementRepository condRepo;

	public ConditionnementService(ConditionnementRepository condRepo) {
		this.condRepo = condRepo;
	}

	protected DtoConditionementRep entityToDto(Conditionnement c) {
		DtoConditionementRep condDtoRep = new DtoConditionementRep();
		condDtoRep.setEmballage(c.getEmballage());
		condDtoRep.setId(c.getId());
		condDtoRep.setNombrePiece(c.getNombrePiece());
		condDtoRep.setPoidsPiece(c.getPoidsPiece());
		condDtoRep.setUnite(c.getUnite());
		return condDtoRep;
	}

	protected Conditionnement getbyId(Integer conditionnementId) throws sqlException {
		Optional<Conditionnement> condOpt = condRepo.findById(conditionnementId);
		if (condOpt.isPresent()) {
			return condOpt.get();
		} else {
			throw new sqlException("id produit non trouvée");
		}
	}

}
