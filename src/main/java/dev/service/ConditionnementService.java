package dev.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.dto.ConditionnementDtoRequete;
import dev.dto.ConditionnementDtoResponse;
import dev.dto.ProduitDtoResponse;
import dev.entity.Conditionnement;
import dev.entity.Produit;
import dev.enumeration.Categorie;
import dev.enumeration.Emballage;
import dev.enumeration.Magasin;
import dev.enumeration.Unite;
import dev.exception.EnumException;
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
		List<ConditionnementDtoResponse> list = new ArrayList<ConditionnementDtoResponse>();
		for (Conditionnement c : condRepo.findAll()) {
			list.add(this.entityToDtoResponse(c));
		}
		return list;
	}

	@Override
	public List<ConditionnementDtoResponse> getBy(String type, String value) throws EnumException {
		List<ConditionnementDtoResponse> list = new ArrayList<ConditionnementDtoResponse>();
		List<Conditionnement> lc = null;
		switch (type) {
		case "emballage":
			lc = condRepo.findByEmballage(Emballage.valueOf(value));
			break;
		}
		for (Conditionnement c : lc) {
			list.add(this.entityToDtoResponse(c));
		}
		return list;
	}

	public int findBy(Emballage emballage, Integer poidsCond, Unite uniteCond) {
		Optional<Conditionnement> optCond = condRepo.findByEmballageAndPoidsAndUnite(emballage, poidsCond, uniteCond);
		if (optCond.isPresent()) {
			System.out.println("conditionnement trouvé");
			return optCond.get().getId();
		} else {
			System.out.println("conditionnement créé");
			Conditionnement newCond = new Conditionnement();
			newCond.setEmballage(emballage);
			newCond.setPoids(poidsCond);
			newCond.setUnite(uniteCond);
			return condRepo.save(newCond).getId();
		}
	}

	@Override
	public ConditionnementDtoResponse addEdit(ConditionnementDtoRequete dtoReq) {
		return this.entityToDtoResponse(condRepo.save(this.DtoQueryToEntity(dtoReq)));
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
		condDtoRep.setPoids(entity.getPoids());
		condDtoRep.setUnite(entity.getUnite());
		return condDtoRep;
	}

	@Override
	public Conditionnement DtoQueryToEntity(ConditionnementDtoRequete dtoRequete) {
		Conditionnement c = new Conditionnement();
		if (dtoRequete.getId() != null)
			c.setId(dtoRequete.getId());
		c.setEmballage(dtoRequete.getEmballage());
		c.setPoids(dtoRequete.getPoids());
		c.setUnite(dtoRequete.getUnite());
		return c;
	}

}
