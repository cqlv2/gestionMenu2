package dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.dto.PlatDtoRequete;
import dev.dto.platDtoResponse;
import dev.entity.Plat;
import dev.entity.Produit;
import dev.exception.EnumException;
import dev.exception.sqlException;
import dev.interfaces.InterfaceService;
import dev.repository.PlatRepository;

@Service
public class PlatService implements InterfaceService<Plat, platDtoResponse, PlatDtoRequete> {

	private PlatRepository platRepo;
	private ProduitService prServ;

	public PlatService(PlatRepository platRepo, ProduitService prServ) {
		this.platRepo = platRepo;
		this.prServ = prServ;
	}

	@Override
	public List<platDtoResponse> getAll() {
		List<platDtoResponse> list = new ArrayList<platDtoResponse>();
		for (Plat plat : platRepo.findAll()) {
			list.add(this.entityToDtoResponse(plat));
		}

		return list;
	}

	@Override
	public List<platDtoResponse> getBy(String type, String value) throws EnumException {
		List<Plat> listPlat = null;
		List<platDtoResponse> list = new ArrayList<platDtoResponse>();
		switch (type) {
		case "nom":
			listPlat = platRepo.findByNomContaining(value);
			break;
		case "rate":
			listPlat = platRepo.findByNote(Integer.parseInt(value));
			break;
		case "rate-min":
			listPlat = platRepo.findByNoteGreaterThanEqual(Integer.parseInt(value));
			break;
		case "rate-max":
			listPlat = platRepo.findByNoteLessThanEqual(Integer.parseInt(value));
			break;
		}
		for (Plat plat : listPlat) {
			list.add(this.entityToDtoResponse(plat));
		}
		return list;
	}

	@Override
	@Transactional
	public platDtoResponse addEdit(PlatDtoRequete dtoReq) throws sqlException {
		return this.entityToDtoResponse(platRepo.save(this.DtoQueryToEntity(dtoReq)));
	}

	@Override
	public Plat getById(int id) throws sqlException {
		Optional<Plat> optPlat = platRepo.findById(id);
		if (optPlat.isPresent()) {
			return optPlat.get();
		} else {
			throw new sqlException("id du plat non trouvée");
		}
	}

	@Override
	public platDtoResponse entityToDtoResponse(Plat entity) {
		platDtoResponse platDtoRep = new platDtoResponse();
		platDtoRep.setId(entity.getId());
		platDtoRep.setNom(entity.getNom());
		platDtoRep.setNote(entity.getNote());

		for (Produit produit : entity.getProduits()) {

			platDtoRep.getProduitsDtoResponse().add(prServ.entityToDtoResponse(produit));
		}

		return platDtoRep;
	}

	@Override
	public Plat DtoQueryToEntity(PlatDtoRequete dtoRequete) throws sqlException {
		Plat plat = new Plat();
		if (dtoRequete.getId() != null)
			plat.setId(dtoRequete.getId());

		plat.setNom(dtoRequete.getNom());
		plat.setNote(dtoRequete.getNote());
		for (Integer idProduit : dtoRequete.getProduitsId()) {
			plat.getProduits().add(prServ.getById(idProduit));
		}
System.err.println("test -> "+plat);
		return plat;
	}

}
