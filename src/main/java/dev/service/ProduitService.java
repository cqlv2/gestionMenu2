package dev.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.dto.ProduitDtoRequete;
import dev.dto.ProduitDtoResponse;
import dev.entity.Produit;
import dev.enumeration.Categorie;
import dev.enumeration.Magasin;
import dev.exception.sqlException;
import dev.interfaces.InterfaceService;
import dev.repository.ProduitRepository;

@Service

public class ProduitService implements InterfaceService<Produit, ProduitDtoResponse, ProduitDtoRequete> {

	private ProduitRepository prRepo;
	private ConditionnementService condService;

	public ProduitService(ProduitRepository prRepo, ConditionnementService condService) {
		this.prRepo = prRepo;
		this.condService = condService;
	}

	@Override
	public List<ProduitDtoResponse> getAll() {
		List<ProduitDtoResponse> list = new ArrayList<ProduitDtoResponse>();
		for (Produit p : prRepo.findAll()) {
			list.add(this.entityToDtoResponse(p));
		}
		return list;
	}

	@Override
	public List<ProduitDtoResponse> getBy(String type, String value) {
		List<ProduitDtoResponse> list = new ArrayList<ProduitDtoResponse>();
		List<Produit> lp = null;
		switch (type) {
		case "libelle":
			lp = prRepo.findByLibelleContaining(value);
			break;
		case "categorie":
			lp = prRepo.findBycategorie(Categorie.valueOf(value));
			break;
		case "prixSup":
			lp = prRepo.findByPrixGreaterThanEqual(new BigDecimal(value));
			break;
		case "prixInf":
			lp = prRepo.findByPrixLessThan(new BigDecimal(value));
			break;
		case "prixKgSup":
			lp = prRepo.findByPrixKgGreaterThanEqual(new BigDecimal(value));
			break;
		case "prixKgInf":
			lp = prRepo.findByPrixKgLessThan(new BigDecimal(value));
			break;
		case "magasin":
			lp = prRepo.findByMagasin(Magasin.valueOf(value));
			break;
		}
		for (Produit p : lp) {
			list.add(this.entityToDtoResponse(p));
		}
		return list;
	}

	@Override
	public ProduitDtoResponse addEdit(ProduitDtoRequete dtoReq) throws sqlException {
		Produit p = this.DtoQueryToEntity(dtoReq);
		return this.entityToDtoResponse(prRepo.save(p));
	}

	@Override
	public Produit getById(int id) throws sqlException {
		Optional<Produit> prodOpt = prRepo.findById(id);
		if (prodOpt.isPresent()) {
			return prodOpt.get();
		} else {
			throw new sqlException("id produit non trouvée");
		}
	}

	@Override
	public ProduitDtoResponse entityToDtoResponse(Produit entity) {
		ProduitDtoResponse prodDtoRep = new ProduitDtoResponse();
		prodDtoRep.setId(entity.getId());
		prodDtoRep.setCategorie(entity.getCategorie());
		prodDtoRep.setConditionnement(condService.entityToDtoResponse(entity.getConditionnement()));
		prodDtoRep.setLibelle(entity.getLibelle());
		prodDtoRep.setMagasin(entity.getMagasin());
		prodDtoRep.setPrix(entity.getPrix());
		prodDtoRep.setPrixKg(entity.getPrixKg());
		return prodDtoRep;
	}

	@Override
	public Produit DtoQueryToEntity(ProduitDtoRequete dtoRequete) throws sqlException {
		Produit p = new Produit();
		if (dtoRequete.getId() != null)
			p.setId(dtoRequete.getId());
		p.setCategorie(dtoRequete.getCategorie());
		p.setConditionnement(condService.getById(dtoRequete.getConditionnementId()));
		p.setLibelle(dtoRequete.getLibelle());
		p.setMagasin(dtoRequete.getMagasin());
		p.setPrix(dtoRequete.getPrix());
		p.setPrixKg(dtoRequete.getPrixKg());

		return p;
	}
}
