package dev.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import dev.dto.PlatDtoRequete;
import dev.dto.platDtoResponse;
import dev.entity.Plat;
import dev.exception.EnumException;
import dev.exception.sqlException;

@ExtendWith(SpringExtension.class)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class PlatServiceTest {

	private PlatService platServ;
	private PlatDtoRequete PlatReq;
	
	
	public PlatServiceTest(PlatService platServ) {
		
		this.platServ = platServ;
	}

	@BeforeEach
	public void setDtoRequete() {
		PlatReq = new PlatDtoRequete();
		PlatReq.setNom("test1");
		PlatReq.setNote(0);
		PlatReq.getProduitsId().add(1);
		PlatReq.getProduitsId().add(2);
		PlatReq.getProduitsId().add(3);
	}

	@Test
	void testPlatService() {
		Assertions.assertThat(platServ).isInstanceOf(PlatService.class);
	}

	@Test
	@Transactional 
	void testGetAll() {
		Assertions.assertThat(platServ.getAll()).asList();
		Assertions.assertThat(platServ.getAll()).hasSize(4);
		Assertions.assertThat(platServ.getAll().get(0).getNom()).isEqualTo("Spaguetti bolognaise boulette");
	}

	@Test
	@Transactional 
	void testGetBy() throws EnumException {
		Assertions.assertThat(platServ.getBy("nom", "Spa")).asList();
		Assertions.assertThat(platServ.getBy("nom", "Spa")).hasSize(1);
	}

	@Test
	@Transactional 
	void testAddEdit() throws sqlException {
		// test d'ajout
				Assertions.assertThat(platServ.addEdit(PlatReq)).isInstanceOf(platDtoResponse.class);
				Assertions.assertThat(platServ.getAll()).hasSize(5);
				Assertions.assertThat(platServ.getById(5).getNom()).isEqualTo("test1");
				// test edition
				PlatReq.setId(5);
				PlatReq.setNom("test2");
				Assertions.assertThat(platServ.addEdit(PlatReq)).isInstanceOf(platDtoResponse.class);
				Assertions.assertThat(platServ.getAll()).hasSize(5);
				Assertions.assertThat(platServ.getById(5).getNom()).isEqualTo("test2");
	}

	@Test
	@Transactional 
	void testGetById() throws sqlException {
		Assertions.assertThat(platServ.getById(1)).isInstanceOf(Plat.class);
		Assertions.assertThat(platServ.getById(1).getNom()).isEqualTo("Spaguetti bolognaise boulette");
		Assertions.assertThatThrownBy(() -> platServ.getById(100)).isInstanceOf(sqlException.class);
		Assertions.assertThatThrownBy(() -> platServ.getById(100)).hasMessage("id du plat non trouvée");
	}

	@Test
	@Transactional 
	void testEntityToDtoResponse() throws sqlException {
		Plat plat = platServ.getById(1);
		Assertions.assertThat(platServ.entityToDtoResponse(plat)).isInstanceOf(platDtoResponse.class);
		Assertions.assertThat(platServ.entityToDtoResponse(plat).getNom()).isEqualTo("Spaguetti bolognaise boulette");

	}

	@Test
	@Transactional 
	void testDtoQueryToEntity() throws sqlException {
		Assertions.assertThat(platServ.DtoQueryToEntity(PlatReq)).isInstanceOf(Plat.class);
	}

}
