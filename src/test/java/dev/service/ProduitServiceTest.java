package dev.service;

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

import dev.dto.ProduitDtoRequete;
import dev.dto.ProduitDtoResponse;
import dev.entity.Produit;
import dev.enumeration.Categorie;
import dev.enumeration.Magasin;
import dev.enumeration.Unite;
import dev.exception.UniteException;
import dev.exception.sqlException;

@ExtendWith(SpringExtension.class)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)

class ProduitServiceTest {

	private ProduitService prServ;
	private ProduitDtoRequete pReq;

	public ProduitServiceTest(ProduitService prServ) {
		this.prServ = prServ;
	}

	@BeforeEach
	public void setDtoRequete() {
		pReq = new ProduitDtoRequete();
		pReq.setCategorie(Categorie.FECULENT);
		pReq.setConditionnementId(1);
		pReq.setLibelle("test1");
		pReq.setPrix(new BigDecimal("10.5"));
		pReq.setMagasin(Magasin.CARREFOUR);
		pReq.setPrixKg(new BigDecimal("10.5"));
		pReq.setQuantiteParPersonne(80);
		pReq.setUnite(Unite.KILOGRAMME);
	}

	@Test
	void testProduitService() {
		Assertions.assertThat(prServ).isInstanceOf(ProduitService.class);
	}

	@Test
	void testGetAll() {
		Assertions.assertThat(prServ.getAll()).asList();
		Assertions.assertThat(prServ.getAll()).hasSize(13);
	}

	@Test
	void testGetBy() {
		Assertions.assertThat(prServ.getBy("libelle", "rdon")).asList();
		Assertions.assertThat(prServ.getBy("libelle", "rdon")).hasSize(2);
	}

	@Test
	void testAddEdit() throws sqlException, UniteException {
		// test d'ajout
		Assertions.assertThat(prServ.addEdit(pReq)).isInstanceOf(ProduitDtoResponse.class);
		Assertions.assertThat(prServ.getAll()).hasSize(14);
		Assertions.assertThat(prServ.getById(14).getLibelle()).isEqualTo("test1");
		// test update
		pReq.setId(14);
		pReq.setLibelle("test2");
		Assertions.assertThat(prServ.addEdit(pReq)).isInstanceOf(ProduitDtoResponse.class);
		Assertions.assertThat(prServ.getAll()).hasSize(14);
		Assertions.assertThat(prServ.getById(14).getLibelle()).isEqualTo("test2");
	}

	@Test
	void testGetById() throws sqlException {
		Assertions.assertThat(prServ.getById(1)).isInstanceOf(Produit.class);
		Assertions.assertThat(prServ.getById(2).getLibelle()).isEqualTo("sauce boloniaise");
		Assertions.assertThat(prServ.getById(2).getCategorie()).isEqualTo(Categorie.PLAT_PREPARE);
		Assertions.assertThatThrownBy(() -> prServ.getById(100)).isInstanceOf(sqlException.class);
		Assertions.assertThatThrownBy(() -> prServ.getById(100)).hasMessage("id produit non trouvée");
	}

	@Test
	void testEntityToDtoResponse() throws sqlException {
		Produit p = prServ.getById(1);
		Assertions.assertThat(prServ.entityToDtoResponse(p)).isInstanceOf(ProduitDtoResponse.class);
		Assertions.assertThat(prServ.entityToDtoResponse(p).getLibelle()).isEqualTo("Spaguetti");
	}

	@Test
	void testDtoQueryToEntity() throws sqlException, UniteException {

		Assertions.assertThat(prServ.DtoQueryToEntity(pReq)).isInstanceOf(Produit.class);

		// test echec sql
		pReq.setConditionnementId(100);
		Assertions.assertThatThrownBy(() -> prServ.addEdit(pReq)).isInstanceOf(sqlException.class);
		Assertions.assertThatThrownBy(() -> prServ.addEdit(pReq)).hasMessage("id du conditionnement non trouvée");

		// test echec unite
		pReq.setConditionnementId(1);
		pReq.setUnite(Unite.CENTILITRE);
		Assertions.assertThatThrownBy(() -> prServ.addEdit(pReq)).isInstanceOf(UniteException.class);
		Assertions.assertThatThrownBy(() -> prServ.addEdit(pReq))
				.hasMessage("l'unité ne correspond pas au conditionement");

	}
	
	@Test
	void testCheckUnite() {
		Assertions.assertThat(prServ.checkUnite(Unite.CENTILITRE, Unite.CENTILITRE)).isTrue();
		Assertions.assertThat(prServ.checkUnite(Unite.LITRE, Unite.CENTILITRE)).isTrue();
		Assertions.assertThat(prServ.checkUnite(Unite.CENTILITRE, Unite.GRAMME)).isFalse();
	}

}
