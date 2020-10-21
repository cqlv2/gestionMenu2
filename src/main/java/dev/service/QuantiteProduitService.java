package dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.dto.QuantiteProduitDtoRequete;
import dev.dto.QuantiteProduitDtoResponse;
import dev.entity.QuantiteProduit;
import dev.exception.EnumException;
import dev.exception.sqlException;
import dev.interfaces.InterfaceService;
import dev.repository.QuantiteProduitRepository;

@Service
public class QuantiteProduitService
		implements InterfaceService<QuantiteProduit, QuantiteProduitDtoResponse, QuantiteProduitDtoRequete> {

	private QuantiteProduitRepository qtePrRepo;
	private ProduitService prServ;

	public QuantiteProduitService(QuantiteProduitRepository qtePrRepo, ProduitService prServ) {
		this.qtePrRepo = qtePrRepo;
		this.prServ = prServ;
	}

	@Override
	public List<QuantiteProduitDtoResponse> getAll() {
		List<QuantiteProduitDtoResponse> list = new ArrayList<QuantiteProduitDtoResponse>();
		for (QuantiteProduit qtePr : qtePrRepo.findAll()) {
			list.add(this.entityToDtoResponse(qtePr));
		}
		return list;
	}

	@Override
	public List<QuantiteProduitDtoResponse> getBy(String type, String value) throws EnumException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuantiteProduitDtoResponse addEdit(QuantiteProduitDtoRequete dtoReq) throws sqlException, EnumException {
		return this.entityToDtoResponse(qtePrRepo.save(this.DtoQueryToEntity(dtoReq)));
	}

	@Override
	public QuantiteProduit getById(int id) throws sqlException {
		Optional<QuantiteProduit> optQtePr = qtePrRepo.findById(id);
		if (optQtePr.isPresent()) {
			return optQtePr.get();
		} else {
			throw new sqlException("id QuantiteProduit non trouvée");
		}

	}

	@Override
	public QuantiteProduitDtoResponse entityToDtoResponse(QuantiteProduit entity) {
		QuantiteProduitDtoResponse qtePrDtoRep = new QuantiteProduitDtoResponse();
		qtePrDtoRep.setId(entity.getId());
		qtePrDtoRep.setProduitDtoRep(prServ.entityToDtoResponse(entity.getProduit()));
		qtePrDtoRep.setQuantite(entity.getQuantite());
		qtePrDtoRep.setUnite(entity.getUnite());
		return qtePrDtoRep;
	}

	@Override
	public QuantiteProduit DtoQueryToEntity(QuantiteProduitDtoRequete dtoRequete) throws sqlException {

		QuantiteProduit qtePr = new QuantiteProduit();
		if (dtoRequete.getId() != null)
			qtePr.setId(dtoRequete.getId());
		qtePr.setProduit(prServ.getById(dtoRequete.getProduitId()));
		qtePr.setQuantite(dtoRequete.getQuantite());
		qtePr.setUnite(dtoRequete.getUnite());
		return qtePr;
	}

}
