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

import dev.dto.ProduitDtoRequete;
import dev.dto.ProduitDtoResponse;
import dev.entity.Produit;
import dev.enumeration.Categorie;
import dev.enumeration.Magasin;
import dev.exception.sqlException;

@ExtendWith(SpringExtension.class)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)

class ProduitServiceTest {

	private ProduitService prServ;

	public ProduitServiceTest(ProduitService prServ) {
		this.prServ = prServ;
	}

	@Test
	void testProduitService() {
		Assertions.assertThat(prServ).isInstanceOf(ProduitService.class);
	}

	@Test
	void testGetAll() {
		Assertions.assertThat(prServ.getAll()).asList();
		Assertions.assertThat(prServ.getAll()).hasSize(8);
		Assertions.assertThat(prServ.getAll().get(0).getLibelle()).isEqualTo("boite haricot marque repere");
		Assertions.assertThat(prServ.getAll().get(5).getMagasin()).isEqualTo(Magasin.LIDL);
	}

	@Test
	void testGetBy() {
		Assertions.assertThat(prServ.getBy("libelle", "ha")).asList();
		Assertions.assertThat(prServ.getBy("libelle", "ha")).hasSize(2);
		Assertions.assertThat(prServ.getBy("categorie", "VIANDE")).asList();
		Assertions.assertThat(prServ.getBy("categorie", "VIANDE")).hasSize(2);
		Assertions.assertThat(prServ.getBy("prixSup", "1")).asList();
		Assertions.assertThat(prServ.getBy("prixSup", "1")).hasSize(5);
		Assertions.assertThat(prServ.getBy("prixInf", "1")).asList();
		Assertions.assertThat(prServ.getBy("prixInf", "1")).hasSize(3);
		Assertions.assertThat(prServ.getBy("prixKgSup", "1")).asList();
		Assertions.assertThat(prServ.getBy("prixKgSup", "1")).hasSize(5);
		Assertions.assertThat(prServ.getBy("prixKgInf", "1")).asList();
		Assertions.assertThat(prServ.getBy("prixKgInf","1")).hasSize(3);
		Assertions.assertThat(prServ.getBy("magasin","CARREFOUR")).asList();
		Assertions.assertThat(prServ.getBy("magasin","CARREFOUR")).hasSize(3);
	}

	@Test
	void testAddEdit() throws sqlException {
		// test d'ajout
		ProduitDtoRequete pReqAdd = new ProduitDtoRequete();
		pReqAdd.setCategorie(Categorie.FECULENT);
		pReqAdd.setConditionnementId(1);
		pReqAdd.setLibelle("test1");
		pReqAdd.setPrix(new BigDecimal("10.5"));
		pReqAdd.setMagasin(Magasin.CARREFOUR);
		pReqAdd.setPrixKg(new BigDecimal("10.5"));
		Assertions.assertThat(prServ.addEdit(pReqAdd)).isInstanceOf(ProduitDtoResponse.class);
		Assertions.assertThat(prServ.getAll()).hasSize(9);
		Assertions.assertThat(prServ.getById(9).getLibelle()).isEqualTo("test1");

		// test update
		ProduitDtoRequete pReqEdit = new ProduitDtoRequete();
		pReqEdit.setId(1);
		pReqEdit.setCategorie(Categorie.LEGUME);
		pReqEdit.setConditionnementId(7);
		pReqEdit.setLibelle("test2");
		pReqEdit.setPrix(new BigDecimal("10.5"));
		pReqEdit.setMagasin(Magasin.CARREFOUR);
		pReqEdit.setPrixKg(new BigDecimal("10.5"));
		Assertions.assertThat(prServ.addEdit(pReqEdit)).isInstanceOf(ProduitDtoResponse.class);
		Assertions.assertThat(prServ.getAll()).hasSize(9);
		Assertions.assertThat(prServ.getById(1).getLibelle()).isEqualTo("test2");
		Assertions.assertThat(prServ.getById(1).getMagasin()).isEqualTo(Magasin.CARREFOUR);

		// test echec
		ProduitDtoRequete pReqEchec = new ProduitDtoRequete();
		pReqEchec.setId(2);
		pReqEchec.setCategorie(Categorie.LEGUME);
		pReqEchec.setConditionnementId(20);
		pReqEchec.setLibelle("test3");
		pReqEchec.setPrix(new BigDecimal("10.5"));
		pReqEchec.setMagasin(Magasin.CARREFOUR);
		pReqEchec.setPrixKg(new BigDecimal("10.5"));
		Assertions.assertThatThrownBy(() -> prServ.addEdit(pReqEchec)).isInstanceOf(sqlException.class);
		Assertions.assertThatThrownBy(() -> prServ.addEdit(pReqEchec)).hasMessage("id du conditionnement non trouvée");
		Assertions.assertThat(prServ.getAll()).hasSize(9);
		Assertions.assertThat(prServ.getById(2).getLibelle()).isEqualTo("huile de tournesol");
		

		
		
	}

	@Test
	void testGetById() throws sqlException {
		Assertions.assertThat(prServ.getById(1)).isInstanceOf(Produit.class);
		Assertions.assertThat(prServ.getById(2).getLibelle()).isEqualTo("huile de tournesol");
		Assertions.assertThat(prServ.getById(2).getCategorie()).isEqualTo(Categorie.MATIERE_GRASSE);
		Assertions.assertThatThrownBy(() -> prServ.getById(10)).isInstanceOf(sqlException.class);
		Assertions.assertThatThrownBy(() -> prServ.getById(10)).hasMessage("id produit non trouvée");
	}

	@Test
	void testEntityToDtoResponse() throws sqlException {
		Produit p =prServ.getById(1);
		Assertions.assertThat(prServ.entityToDtoResponse(p)).isInstanceOf(ProduitDtoResponse.class);
		Assertions.assertThat(prServ.entityToDtoResponse(p).getLibelle()).isEqualTo("boite haricot marque repere");
	}

	@Test
	void testDtoQueryToEntity() throws sqlException {
		ProduitDtoRequete pReq = new ProduitDtoRequete();
		pReq.setCategorie(Categorie.FECULENT);
		pReq.setConditionnementId(1);
		pReq.setLibelle("test");
		pReq.setPrix(new BigDecimal("10.5"));
		pReq.setMagasin(Magasin.CARREFOUR);
		pReq.setPrixKg(new BigDecimal("10.5"));
		Assertions.assertThat(prServ.DtoQueryToEntity(pReq)).isInstanceOf(Produit.class);
		pReq.setConditionnementId(20);
		Assertions.assertThatThrownBy(() -> prServ.DtoQueryToEntity(pReq)).isInstanceOf(sqlException.class);
		Assertions.assertThatThrownBy(() -> prServ.DtoQueryToEntity(pReq)).hasMessage("id du conditionnement non trouvée");
		
	}

}
