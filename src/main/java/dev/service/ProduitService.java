package dev.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.dto.ProduitDtoRequete;
import dev.dto.ProduitDtoResponse;
import dev.entity.Produit;
import dev.enumeration.Categorie;
import dev.enumeration.Emballage;
import dev.enumeration.Magasin;
import dev.enumeration.SearchOperation;
import dev.enumeration.Unite;
import dev.exception.UniteException;
import dev.exception.sqlException;
import dev.interfaces.InterfaceService;
import dev.repository.ProduitRepository;
import dev.spec.ProduitSpecification;
import dev.spec.SearchCriteria;

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

	//TODO remove getBy from interface
	@Override
	public List<ProduitDtoResponse> getBy(String type, String value) {
		return null;
	}

	//TODO add searchByFilter from interface
	public List<ProduitDtoResponse> searchByFilters(String libelle, String categorie, String magasin, String prixmin, String prixmax, String prixkgmin, String prixkgmax, String search) {
		ProduitSpecification prSpec = new ProduitSpecification();		
		if(libelle!=null) prSpec.add(new SearchCriteria("libelle", libelle, SearchOperation.EQUAL));
		if(categorie!=null)prSpec.add(new SearchCriteria("categorie", Categorie.valueOf(categorie), SearchOperation.EQUAL));
		if(magasin!=null) prSpec.add(new SearchCriteria("magasin", Magasin.valueOf(magasin), SearchOperation.EQUAL));
		if(prixmin!=null) prSpec.add(new SearchCriteria("prix", new BigDecimal(prixmin), SearchOperation.GREATER_THAN_EQUAL));
		if(prixmax!=null) prSpec.add(new SearchCriteria("prix", new BigDecimal(prixmax), SearchOperation.LESS_THAN));
		if(prixkgmin!=null) prSpec.add(new SearchCriteria("prixKg", new BigDecimal(prixkgmin), SearchOperation.GREATER_THAN_EQUAL));
		if(prixkgmax!=null) prSpec.add(new SearchCriteria("prixKg", new BigDecimal(prixkgmax), SearchOperation.LESS_THAN));
		if(search!=null) prSpec.add(new SearchCriteria("libelle", search, SearchOperation.MATCH));
		List<ProduitDtoResponse> list = new ArrayList<ProduitDtoResponse>();
		for (Produit produit : prRepo.findAll(prSpec)) {
			list.add(this.entityToDtoResponse(produit));
		}
		return list;
	}

	@Override
	public ProduitDtoResponse addEdit(ProduitDtoRequete dtoReq) throws sqlException, UniteException {
		// verification du conditionnement
		if (dtoReq.getIdCond() == null) {
			dtoReq.setIdCond(condService.findBy(dtoReq.getEmballage(), dtoReq.getPoidsCond(), dtoReq.getUniteCond()));
		}
		// calcul du prix au kilo/litre
		int poids = dtoReq.getPoidsCond();
		if (dtoReq.getUniteCond() == Unite.KILOGRAMME || dtoReq.getUniteCond() == Unite.LITRE)
			poids = poids * 1000;
		BigDecimal prixKg = dtoReq.getPrix().multiply(new BigDecimal("1000"));
		prixKg = prixKg.divide(new BigDecimal(poids));
		dtoReq.setPrixKg(prixKg);
		// enregistrement
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

	public List<ProduitDtoResponse> getByMagCat(Magasin mag, Categorie cat) {
		List<ProduitDtoResponse> list = new ArrayList<ProduitDtoResponse>();
		for (Produit p : prRepo.findByCategorieAndMagasin(cat, mag)) {
			list.add(this.entityToDtoResponse(p));
		}
		return list;
	}

	public List<Categorie> getAllCat() {
		return new ArrayList<Categorie>(Arrays.asList(Categorie.values()));
	}

	public List<Unite> getAllUnit() {
		return new ArrayList<Unite>(Arrays.asList(Unite.values()));
	}

	public List<Magasin> getAllMagasin() {
		return new ArrayList<Magasin>(Arrays.asList(Magasin.values()));
	}

	public ArrayList<Emballage> getAllConditionnement() {
		return new ArrayList<Emballage>(Arrays.asList(Emballage.values()));
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
		prodDtoRep.setQuantiteParPersonne(entity.getQuantiteParPersonne());
		prodDtoRep.setUnite(entity.getUnite());

		return prodDtoRep;
	}

	@Override
	public Produit DtoQueryToEntity(ProduitDtoRequete dtoRequete) throws sqlException, UniteException {
		Produit p = new Produit();
		if (dtoRequete.getId() != null)
			p.setId(dtoRequete.getId());
		p.setCategorie(dtoRequete.getCategorie());
		p.setConditionnement(condService.getById(dtoRequete.getIdCond()));
		p.setLibelle(dtoRequete.getLibelle());
		p.setMagasin(dtoRequete.getMagasin());
		p.setPrix(dtoRequete.getPrix());
		p.setPrixKg(dtoRequete.getPrixKg());
		p.setQuantiteParPersonne(dtoRequete.getQuantiteParPersonne());
		p.setUnite(dtoRequete.getUnite());
		return p;
	}

	// TODO a deplacer a la verif d'un conditionnement
	protected boolean checkUnite(Unite uniteA, Unite uniteB) {
		if ((uniteA.name().contains("GRAMME") && uniteB.name().contains("GRAMME")))
			return true;
		if ((uniteA.name().contains("LITRE") && uniteB.name().contains("LITRE")))
			return true;
		return false;
	}

}
