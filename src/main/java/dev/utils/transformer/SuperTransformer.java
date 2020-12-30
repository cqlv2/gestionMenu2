package dev.utils.transformer;

import dev.entity.SuperEntity;
import dev.dto.PackagingDtoQuery;
import dev.entity.Packaging;

/**
 * referral tool for the use of the transformer corresponding to the entity's
 * class
 * 
 * @author cql-v2
 * @version 1.0
 */
public class SuperTransformer {

	/**
	 * 
	 * @param entity entity to be referred
	 * @return an entity transform into DTO response
	 */
	public static Object entityToDtoResponse(SuperEntity entity) {
		switch (entity.getClass().getSimpleName()) {
		case "Packaging":
			return PackagingTransformer.entityToDtoResponse((Packaging) entity);

		default:
			// TODO Auto-generated method stub
			return null;
		}

	}

	public static Object dtoToEntity(Object dtoQuery) {
		switch (dtoQuery.getClass().getSimpleName()) {
		case "PackagingDtoQuery":
			return PackagingTransformer.dtoToEntity((PackagingDtoQuery) dtoQuery);

		default:
			return null;
		}
	}

}
