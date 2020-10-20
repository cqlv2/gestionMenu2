package dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.dto.ConditionnementDtoRequete;
import dev.dto.ConditionnementDtoResponse;
import dev.entity.Conditionnement;
import dev.exception.sqlException;
import dev.interfaces.InterfaceService;
import dev.repository.ConditionnementRepository;

@Service
public class ConditionnementService
		implements InterfaceService<Conditionnement, ConditionnementDtoResponse, ConditionnementDtoRequete> {

	private ConditionnementRepository condRepo;

	public ConditionnementService(ConditionnementRepository condRepo) {
		this.condRepo = condRepo;
	}

	@Override
	public List<ConditionnementDtoResponse> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConditionnementDtoResponse> getBy(String type, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConditionnementDtoResponse addEdit(ConditionnementDtoRequete dtoReq) throws sqlException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conditionnement getById(int id) throws sqlException {
		Optional<Conditionnement> condOpt = condRepo.findById(id);
		if (condOpt.isPresent()) {
			return condOpt.get();
		} else {
			throw new sqlException("id du conditionnement non trouvée");
		}
	}

	@Override
	public ConditionnementDtoResponse entityToDtoResponse(Conditionnement entity) {
		ConditionnementDtoResponse condDtoRep = new ConditionnementDtoResponse();
		condDtoRep.setEmballage(entity.getEmballage());
		condDtoRep.setId(entity.getId());
		condDtoRep.setNombrePiece(entity.getNombrePiece());
		condDtoRep.setPoidsPiece(entity.getPoidsPiece());
		condDtoRep.setUnite(entity.getUnite());
		return condDtoRep;
	}

	@Override
	public Conditionnement DtoQueryToEntity(ConditionnementDtoRequete dtoRequete) throws sqlException {
		// TODO Auto-generated method stub
		return null;
	}

}
