package dev.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.dto.ConditionnementDtoRequete;
import dev.dto.ConditionnementDtoResponse;
import dev.dto.ProduitDtoRequete;
import dev.dto.ProduitDtoResponse;
import dev.entity.Conditionnement;
import dev.entity.Produit;
import dev.enumeration.Categorie;
import dev.enumeration.Emballage;
import dev.enumeration.Magasin;
import dev.enumeration.Unite;
import dev.exception.EnumException;
import dev.exception.sqlException;

@ExtendWith(SpringExtension.class)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class ConditionnementServiceTest {

	private ConditionnementService condServ;

	public ConditionnementServiceTest(ConditionnementService condServ) {
		this.condServ = condServ;
	}

	@Test
	void testConditionnementService() {
		Assertions.assertThat(condServ).isInstanceOf(ConditionnementService.class);
	}

	@Test
	void testGetAll() {
		Assertions.assertThat(condServ.getAll()).asList();
		Assertions.assertThat(condServ.getAll()).hasSize(7);
		Assertions.assertThat(condServ.getAll().get(0).getEmballage()).isEqualTo(Emballage.PAQUET);
		Assertions.assertThat(condServ.getAll().get(5).getNombrePiece()).isEqualTo(1);
	}

	@Test
	void testGetBy() throws EnumException {
		Assertions.assertThat(condServ.getBy("emballage", "BOUTEILLE")).asList();
		Assertions.assertThat(condServ.getBy("emballage", "BOUTEILLE")).hasSize(1);
		Assertions.assertThatThrownBy(() -> condServ.getBy("emballage", "aze")).isInstanceOf(EnumException.class);
		Assertions.assertThatThrownBy(() -> condServ.getBy("emballage", "aze"))
				.hasMessage("enumeration Emballage non trouvée");
	}

	@Test
	void testAddEdit() throws sqlException, EnumException {
		// test d'ajout
		ConditionnementDtoRequete cReqAdd = new ConditionnementDtoRequete();
		cReqAdd.setEmballage(Emballage.BOUTEILLE);
		cReqAdd.setNombrePiece(1);
		cReqAdd.setPoidsPiece(1);
		cReqAdd.setUnite(Unite.KILOGRAME);
		Assertions.assertThat(condServ.addEdit(cReqAdd)).isInstanceOf(ConditionnementDtoResponse.class);
		Assertions.assertThat(condServ.getAll()).hasSize(8);
		Assertions.assertThat(condServ.getById(8).getUnite()).isEqualTo(Unite.KILOGRAME);
		// test edition
		cReqAdd.setId(8);
		cReqAdd.setUnite(Unite.LITRE);
		Assertions.assertThat(condServ.addEdit(cReqAdd)).isInstanceOf(ConditionnementDtoResponse.class);
		Assertions.assertThat(condServ.getAll()).hasSize(8);
		Assertions.assertThat(condServ.getById(8).getUnite()).isEqualTo(Unite.LITRE);
	}

	@Test
	void testGetById() throws sqlException {
		Assertions.assertThat(condServ.getById(1)).isInstanceOf(Conditionnement.class);
		Assertions.assertThat(condServ.getById(1).getEmballage()).isEqualTo(Emballage.PAQUET);
		Assertions.assertThatThrownBy(() -> condServ.getById(10)).isInstanceOf(sqlException.class);
		Assertions.assertThatThrownBy(() -> condServ.getById(10)).hasMessage("id du conditionnement non trouvée");
	}

	@Test
	void testEntityToDtoResponse() throws sqlException {
		Conditionnement c = condServ.getById(1);
		Assertions.assertThat(condServ.entityToDtoResponse(c)).isInstanceOf(ConditionnementDtoResponse.class);
		Assertions.assertThat(condServ.entityToDtoResponse(c).getEmballage()).isEqualTo(Emballage.PAQUET);
	}

	@Test
	void testDtoQueryToEntity() {
		ConditionnementDtoRequete cDtoReq = new ConditionnementDtoRequete();
		cDtoReq.setEmballage(Emballage.BOUTEILLE);
		cDtoReq.setNombrePiece(1);
		cDtoReq.setPoidsPiece(1);
		cDtoReq.setUnite(Unite.LITRE);
		Assertions.assertThat(condServ.DtoQueryToEntity(cDtoReq)).isInstanceOf(Conditionnement.class);
	}

}
