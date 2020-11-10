package dev.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.dto.MenuDtoRequeteUpdate;
import dev.dto.MenuDtoResponse;
import dev.entity.Menu;
import dev.exception.EnumException;
import dev.exception.UniteException;
import dev.exception.sqlException;
import dev.interfaces.InterfaceService;
import dev.repository.MenuRepository;

@Service
public class MenuService implements InterfaceService<Menu, MenuDtoResponse, MenuDtoRequeteUpdate> {

	private MenuRepository menuRepo;
	private PlatService platServ;

	public MenuService(MenuRepository menuRepo, PlatService platServ) {
		this.menuRepo = menuRepo;
		this.platServ = platServ;
	}

	@Override
	public List<MenuDtoResponse> getAll() {
		List<MenuDtoResponse> list = new ArrayList<MenuDtoResponse>();
		for (Menu menu : menuRepo.findAll()) {

			list.add(this.entityToDtoResponse(menu));
		}

		return list;
	}

	@Override
	public List<MenuDtoResponse> getBy(String type, String value) {
		List<MenuDtoResponse> list = new ArrayList<MenuDtoResponse>();
		for (Menu menu : menuRepo.findByDate(value)) {
			list.add(this.entityToDtoResponse(menu));
		}

		return list;
	}

	public List<MenuDtoResponse> getBetween(String value, String value2) {
		List<MenuDtoResponse> list = new ArrayList<MenuDtoResponse>();
		for (Menu menu : menuRepo.findByDateBetween(LocalDate.parse(value), LocalDate.parse(value2))) {
			list.add(this.entityToDtoResponse(menu));
		}
		return list;
	}

	public MenuDtoResponse getByDate(String day) {
		Optional<Menu> menuOpt = menuRepo.findByDate(LocalDate.parse(day));
		if (menuOpt.isPresent())
			return this.entityToDtoResponse(menuOpt.get());
		else
			return null;
	}

	@Override
	public MenuDtoResponse addEdit(MenuDtoRequeteUpdate dtoReq) throws sqlException, EnumException, UniteException {
		return this.entityToDtoResponse(menuRepo.save(this.DtoQueryToEntity(dtoReq)));
	}

	@Override
	public Menu getById(int id) throws sqlException {
		Optional<Menu> optMenu = menuRepo.findById(id);
		if (optMenu.isPresent()) {
			return optMenu.get();
		} else
			throw new sqlException("id menu non trouvée");
	}

	@Transactional
	@Override
	public MenuDtoResponse entityToDtoResponse(Menu entity) {
		MenuDtoResponse menuDtoRep = new MenuDtoResponse();
		menuDtoRep.setId(entity.getId());
		if (entity.getCouvertMidi1() != null)
			menuDtoRep.setCouvertMidi1(entity.getCouvertMidi1());
		if (entity.getCouvertMidi2() != null)
			menuDtoRep.setCouvertMidi2(entity.getCouvertMidi2());
		if (entity.getCouvertSoir1() != null)
			menuDtoRep.setCouvertSoir1(entity.getCouvertSoir1());
		if (entity.getCouvertSoir2() != null)
			menuDtoRep.setCouvertSoir2(entity.getCouvertSoir2());
		if (entity.getMidi1() != null)
			menuDtoRep.setMidi1(platServ.entityToDtoResponse(entity.getMidi1()));
		if (entity.getMidi2() != null)
			menuDtoRep.setMidi2(platServ.entityToDtoResponse(entity.getMidi2()));
		if (entity.getSoir1() != null)
			menuDtoRep.setSoir1(platServ.entityToDtoResponse(entity.getSoir1()));
		if (entity.getSoir2() != null)
			menuDtoRep.setSoir2(platServ.entityToDtoResponse(entity.getSoir2()));

		System.err.println("azze");

		menuDtoRep.setDate(entity.getDate());
		return menuDtoRep;
	}

	@Override
	public Menu DtoQueryToEntity(MenuDtoRequeteUpdate dtoRequete) throws sqlException, UniteException {
		Menu menu = new Menu();
		if (dtoRequete.getId() != null)
			menu.setId(dtoRequete.getId());
		menu.setDate(dtoRequete.getDate());
		menu.setMidi1(platServ.getById(dtoRequete.getMidi1Id()));
		menu.setMidi2(platServ.getById(dtoRequete.getMidi2Id()));
		menu.setSoir1(platServ.getById(dtoRequete.getSoir1Id()));
		menu.setSoir2(platServ.getById(dtoRequete.getSoir2Id()));
		menu.setCouvertMidi1(dtoRequete.getCouvertMidi1());
		menu.setCouvertMidi2(dtoRequete.getCouvertMidi2());
		menu.setCouvertSoir1(dtoRequete.getCouvertSoir1());
		menu.setCouvertSoir2(dtoRequete.getCouvertSoir2());
		return menu;
	}

}
