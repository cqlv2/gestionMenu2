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
import dev.repository.ProduitRepository;

@Service
public class ProduitService {

	private ProduitRepository prRepo;
	private ConditionnementService condService;

	/**
	 * Construit un objet de type ProduitService
	 * 
	 * @param prRepo      un objet de type ProduitRepository
	 * @param condService un objet de type ConditionnementService
	 */
	public ProduitService(ProduitRepository prRepo, ConditionnementService condService) {
		this.prRepo = prRepo;
		this.condService = condService;
	}

	/**
	 * créé une liste d'objet produitDtoReponse depuis toutes les entité Produit
	 * enregistrée en base de donnée
	 * 
	 * @return une liste d'objet produitDtoReponse
	 */
	public List<ProduitDtoResponse> getAll() {
		List<ProduitDtoResponse> list = new ArrayList<ProduitDtoResponse>();
		for (Produit p : prRepo.findAll()) {
			list.add(this.entityToDtoResponse(p));
		}
		return list;
	}

	/**
	 * créer une liste d'objet produitDtoReponse depuis les entités Produit
	 * enregistrées en base de donnée répondant aux filtres
	 * 
	 * @param [String] type type de filtre
	 * @param value    [String] valeur du filtre
	 * @return une liste d'objet produitDtoReponse
	 */
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

	/**
	 * Ajoute ou edite une entite de type Produit dans la base de donnée
	 * 
	 * @param prDtoReq un objet de type ProduitDtoRequete
	 * @return un onjet de type ProduitDtoResponse
	 * @throws sqlException exception levée en cas d'erreur sql
	 */
	public ProduitDtoResponse addEdit(ProduitDtoRequete prDtoReq) throws sqlException {
		Produit p = this.DtoQueryToEntity(prDtoReq);
		return this.entityToDtoResponse(prRepo.save(p));
	}

	/**
	 * recherche en base de données une entité de type produit correspondant à une
	 * id
	 * 
	 * @param id de l'objet à chercher
	 * @return une entité de type produit
	 * @throws sqlException exception levée en cas d'erreur sql
	 */
	protected Produit getById(int id) throws sqlException {
		Optional<Produit> prodOpt = prRepo.findById(id);
		if (prodOpt.isPresent()) {
			return prodOpt.get();
		} else {
			throw new sqlException("id produit non trouvée");
		}
	}

	/**
	 * Transforme une entité de type Produit en objet DtoResponse
	 * 
	 * @param p entité produit a transformer en objet Dto
	 * @return retourne un objet Dto de l'entité produit
	 */
	protected ProduitDtoResponse entityToDtoResponse(Produit p) {
		ProduitDtoResponse prodDtoRep = new ProduitDtoResponse();
		prodDtoRep.setId(p.getId());
		prodDtoRep.setCategorie(p.getCategorie());
		prodDtoRep.setConditionnement(condService.entityToDto(p.getConditionnement()));
		prodDtoRep.setLibelle(p.getLibelle());
		prodDtoRep.setMagasin(p.getMagasin());
		prodDtoRep.setPrix(p.getPrix());
		prodDtoRep.setPrixKg(p.getPrixKg());
		return prodDtoRep;
	}

	/**
	 * transforme un objet de type Dto requête en entité Produit
	 * 
	 * @param prodDtoRequete objet de type Dto requête
	 * @return une entité de type produit
	 * @throws sqlException exception levée en cas d'erreur sql
	 */
	protected Produit DtoQueryToEntity(ProduitDtoRequete prodDtoRequete) throws sqlException {
		Produit p = new Produit();
		if (prodDtoRequete.getId() != null)
			p.setId(prodDtoRequete.getId());
		p.setCategorie(prodDtoRequete.getCategorie());
		p.setConditionnement(condService.getbyId(prodDtoRequete.getConditionnementId()));
		p.setLibelle(prodDtoRequete.getLibelle());
		p.setMagasin(prodDtoRequete.getMagasin());
		p.setPrix(prodDtoRequete.getPrix());
		p.setPrixKg(prodDtoRequete.getPrixKg());

		return p;
	}

}
