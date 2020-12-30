package dev.utils.transformer;

import dev.dto.packaging.PackagingDtoQuery;
import dev.dto.packaging.PackagingDtoResponse;
import dev.entity.Packaging;
import dev.entity.Product;

/**
 * transformation between a packaging entity and a data transfer object 
 *
 * @author cql-v2
 * @version 1.0
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
	public static Packaging dtoToEntity(PackagingDtoQuery dtoRequete) {
		Packaging c = new Packaging();
		if (dtoRequete.getId() != null)
			c.setId(dtoRequete.getId());
		c.setPackaging(dtoRequete.getPackaging());
		c.setWeight(dtoRequete.getWeight());
		c.setUnit(dtoRequete.getUnit());

		for (Long idProd : dtoRequete.getProductsId()) {
			Product p = new Product();
			p.setId(idProd);
			c.getProducts().add(p);
		}
		return c;
	}

}
