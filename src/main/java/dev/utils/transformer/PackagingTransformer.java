package dev.utils.transformer;

import dev.dto.PackagingDtoRequete;
import dev.dto.PackagingDtoResponse;
import dev.entity.Packaging;
import dev.entity.Product;

/**
 * [EN] transformation between a packaging entity and a data transfer object -
 * [FR] transformation entre une entité conditionnement et un objet de transfert
 * de données
 *
 * @author cql-v2
 * @version 0.1
 *
 */
public class PackagingTransformer {

	/**
	 * transforms an entity into a data transfer object
	 * 
	 * @param entity entity to transform
	 * @return a data transfer object
	 */
	public static PackagingDtoResponse entityToDtoResponse(Packaging entity) {
		PackagingDtoResponse condDtoRep = new PackagingDtoResponse(entity);
		return condDtoRep;
	}

	/**
	 * transforms a data transfer object into an entity
	 * 
	 * @param dtoRequete data transfer object to be transformed
	 * @return a packaging entity
	 */
//	public static Packaging DtoQueryToEntity(PackagingDtoRequete dtoRequete) {
//		Packaging c = new Packaging();
//		if (dtoRequete.getId() != null)
//			c.setId(dtoRequete.getId());
//		c.setEmballage(dtoRequete.getEmballage());
//		c.setPoids(dtoRequete.getPoids());
//		c.setUnite(dtoRequete.getUnite());
//
//		for (Integer idProd : dtoRequete.getProduitsId()) {
//			Product p = new Product();
//			p.setId(idProd);
//			c.getProduits().add(p);
//		}
//
//		return c;
//	}

}
