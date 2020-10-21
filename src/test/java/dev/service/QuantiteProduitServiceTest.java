package dev.service;

import static org.junit.jupiter.api.Assertions.*;

import java.security.Provider.Service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.dto.ProduitDtoResponse;
import dev.dto.QuantiteProduitDtoRequete;
import dev.dto.QuantiteProduitDtoResponse;
import dev.entity.Produit;
import dev.entity.QuantiteProduit;
import dev.enumeration.Categorie;
import dev.enumeration.Magasin;
import dev.enumeration.Unite;
import dev.exception.EnumException;
import dev.exception.sqlException;

@ExtendWith(SpringExtension.class)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class QuantiteProduitServiceTest {

	private QuantiteProduitService qtePrServ;
	private ProduitService prServ;

	public QuantiteProduitServiceTest(QuantiteProduitService qtePrServ, ProduitService prServ) {
		this.qtePrServ = qtePrServ;
		this.prServ = prServ;
	}

	@Test
	void testQuantiteProduitService() {
		Assertions.assertThat(qtePrServ).isInstanceOf(QuantiteProduitService.class);

	}

	@Test
	void testGetAll() {
		Assertions.assertThat(qtePrServ.getAll()).asList();
		Assertions.assertThat(qtePrServ.getAll()).hasSize(5);
		Assertions.assertThat(qtePrServ.getAll().get(0).getUnite()).isEqualTo(Unite.GRAMME);
		Assertions.assertThat(qtePrServ.getAll().get(4).getQuantite()).isEqualTo(100);
	}

//	@Test
//	void testGetBy() {
//		fail("Not yet implemented");
//	}

	@Test
	void testAddEdit() throws sqlException, EnumException {
		QuantiteProduitDtoRequete qtePrReq=new QuantiteProduitDtoRequete();
		qtePrReq.setProduitId(1);
		qtePrReq.setQuantite(150);
		qtePrReq.setUnite(Unite.LITRE);
		//test Ajout
		Assertions.assertThat(qtePrServ.addEdit(qtePrReq)).isInstanceOf(QuantiteProduitDtoResponse.class);
		Assertions.assertThat(qtePrServ.getAll()).hasSize(6);
		Assertions.assertThat(qtePrServ.getById(6).getUnite()).isEqualTo(Unite.LITRE);
		//test Edit
		qtePrReq.setId(6);
		qtePrReq.setUnite(Unite.GRAMME);
		Assertions.assertThat(qtePrServ.addEdit(qtePrReq)).isInstanceOf(QuantiteProduitDtoResponse.class);
		Assertions.assertThat(qtePrServ.getAll()).hasSize(6);
		Assertions.assertThat(qtePrServ.getById(6).getUnite()).isEqualTo(Unite.GRAMME);
		//test echec
		qtePrReq.setProduitId(200);
		Assertions.assertThatThrownBy(() -> qtePrServ.addEdit(qtePrReq)).isInstanceOf(sqlException.class);
		Assertions.assertThatThrownBy(() -> qtePrServ.addEdit(qtePrReq)).hasMessage("id produit non trouvée");
		
		
	}

	@Test
	void testGetById() throws sqlException {
		Assertions.assertThat(qtePrServ.getById(1)).isInstanceOf(QuantiteProduit.class);
		Assertions.assertThat(qtePrServ.getById(2).getUnite()).isEqualTo(Unite.CENTILITRE);
		Assertions.assertThatThrownBy(() -> qtePrServ.getById(10)).isInstanceOf(sqlException.class);
		Assertions.assertThatThrownBy(() -> qtePrServ.getById(10)).hasMessage("id QuantiteProduit non trouvée");
	}

	@Test
	void testEntityToDtoResponse() throws sqlException {
		QuantiteProduit qtePr =qtePrServ.getById(1);
		Assertions.assertThat(qtePrServ.entityToDtoResponse(qtePr)).isInstanceOf(QuantiteProduitDtoResponse.class);
		Assertions.assertThat(qtePrServ.entityToDtoResponse(qtePr).getProduitDtoRep()).isInstanceOf(ProduitDtoResponse.class);

	}

	@Test
	void testDtoQueryToEntity() throws sqlException {
		QuantiteProduitDtoRequete qtePrDtoReq=new QuantiteProduitDtoRequete();
		qtePrDtoReq.setProduitId(1);
		qtePrDtoReq.setQuantite(100);
		qtePrDtoReq.setUnite(Unite.GRAMME);
		
		Assertions.assertThat(qtePrServ.DtoQueryToEntity(qtePrDtoReq)).isInstanceOf(QuantiteProduit.class);

		qtePrDtoReq.setProduitId(100);
		Assertions.assertThatThrownBy(() -> qtePrServ.DtoQueryToEntity(qtePrDtoReq)).isInstanceOf(sqlException.class);
		Assertions.assertThatThrownBy(() -> qtePrServ.DtoQueryToEntity(qtePrDtoReq)).hasMessage("id produit non trouvée");

	}

}
