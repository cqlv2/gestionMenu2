package dev.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
	private ConditionnementDtoRequete cReq;

	public ConditionnementServiceTest(ConditionnementService condServ) {
		this.condServ = condServ;
	}

	@BeforeEach
	public void setDtoRequete() {
		cReq = new ConditionnementDtoRequete();
		cReq.setEmballage(Emballage.BOUTEILLE);
		cReq.setNombrePiece(1);
		cReq.setPoidsPiece(1);
		cReq.setUnite(Unite.GRAMME);
	}

	@Test
	void testConditionnementService() {
		Assertions.assertThat(condServ).isInstanceOf(ConditionnementService.class);
	}

	@Test
	void testGetAll() {
		Assertions.assertThat(condServ.getAll()).asList();
		Assertions.assertThat(condServ.getAll()).hasSize(12);
		Assertions.assertThat(condServ.getAll().get(0).getEmballage()).isEqualTo(Emballage.PAQUET);
	}

	@Test
	void testGetBy() throws EnumException {
		Assertions.assertThat(condServ.getBy("emballage", "PAQUET")).asList();
		Assertions.assertThat(condServ.getBy("emballage", "PAQUET")).hasSize(5);

	}

	@Test
	void testAddEdit() throws sqlException, EnumException {
		// test d'ajout

		Assertions.assertThat(condServ.addEdit(cReq)).isInstanceOf(ConditionnementDtoResponse.class);
		Assertions.assertThat(condServ.getAll()).hasSize(13);
		Assertions.assertThat(condServ.getById(13).getUnite()).isEqualTo(Unite.GRAMME);
		// test edition
		cReq.setId(13);
		cReq.setUnite(Unite.LITRE);
		Assertions.assertThat(condServ.addEdit(cReq)).isInstanceOf(ConditionnementDtoResponse.class);
		Assertions.assertThat(condServ.getAll()).hasSize(13);
		Assertions.assertThat(condServ.getById(13).getUnite()).isEqualTo(Unite.LITRE);
	}

	@Test
	void testGetById() throws sqlException {
		Assertions.assertThat(condServ.getById(1)).isInstanceOf(Conditionnement.class);
		Assertions.assertThat(condServ.getById(1).getEmballage()).isEqualTo(Emballage.PAQUET);
		Assertions.assertThatThrownBy(() -> condServ.getById(100)).isInstanceOf(sqlException.class);
		Assertions.assertThatThrownBy(() -> condServ.getById(100)).hasMessage("id du conditionnement non trouvée");
	}

	@Test
	void testEntityToDtoResponse() throws sqlException {
		Conditionnement c = condServ.getById(1);
		Assertions.assertThat(condServ.entityToDtoResponse(c)).isInstanceOf(ConditionnementDtoResponse.class);
		Assertions.assertThat(condServ.entityToDtoResponse(c).getEmballage()).isEqualTo(Emballage.PAQUET);
	}

	@Test
	void testDtoQueryToEntity() {

		Assertions.assertThat(condServ.DtoQueryToEntity(cReq)).isInstanceOf(Conditionnement.class);

	}

}
