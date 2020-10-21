package dev.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.dto.ProduitDtoRequete;
import dev.dto.ProduitDtoResponse;
import dev.entity.Produit;
import dev.exception.EnumException;
import dev.exception.UniteException;
import dev.exception.sqlException;

/**
 * service de gestion des entite <T>. liste les entité <T> sous forme d'objet
 * <TDtoRep> ajoute ou edite une entité <T> a partir d'un objet <TDtoRequete>
 * transforme un objet <TDtoRequete> en entité <T> transforme une entité <T> en
 * objet <TDtoRep>
 * 
 * @author cql-v2
 *
 * @param <T>           Entite
 * @param <TDtoRep>     objet representant l'entite
 * @param <TDtoRequete> objet representant un objet futur
 */
public interface InterfaceService<T, TDtoRep, TDtoRequete> {

	/**
	 *
	 * créé une liste d'objet <TDtoRep> depuis toutes les entité <T> enregistrée en
	 * base de donnée
	 * 
	 * @return une liste d'objet <TDtoRep>
	 */
	public List<TDtoRep> getAll();

	/**
	 * créer une liste d'objet <TDtoRep> depuis les entités <T> enregistrées en base
	 * de donnée répondant aux filtres
	 * 
	 * @param type  [String] type type de filtre
	 * @param value [String] valeur du filtre
	 * @return une liste d'objet <TDtoRep>
	 * @throws EnumException 
	 */
	public List<TDtoRep> getBy(String type, String value) throws EnumException;

	/**
	 * Ajoute ou edite une entite de type <T> dans la base de donnée
	 * 
	 * @param dtoReq un objet de type <TDtoRequete>
	 * @return un objet de type <TDtoRep>
	 * @throws sqlException exception levée en cas d'erreur sql
	 * @throws EnumException 
	 * @throws UniteException 
	 */
	public TDtoRep addEdit(TDtoRequete dtoReq) throws sqlException, EnumException, UniteException;

	/**
	 * recherche en base de données une entité de type <T> correspondant à une id
	 * 
	 * @param id de l'objet <T> à rechercher
	 * @return une entité de type <T>
	 * @throws sqlException exception levée en cas d'erreur sql
	 */
	public T getById(int id) throws sqlException;

	/**
	 * Transforme une entité de type <T> en objet <TDtoRep>
	 * 
	 * @param entity entité <T> a transformer en objet <TDtoRep>
	 * @return retourne un objet <TDtoRep> a partir de l'entité <T>
	 */
	public TDtoRep entityToDtoResponse(T entity);

	/**
	 * transforme un objet de type <TDtoRequete> en entité Entite <T>
	 * 
	 * @param dtoRequete objet de type <TDtoRequete>
	 * @return une entité de type <T>
	 * @throws sqlException exception levée en cas d'erreur sql
	 * @throws UniteException exception levée en cas d'erreur d'unite
	 */
	public T DtoQueryToEntity(TDtoRequete dtoRequete) throws sqlException, UniteException;

}
