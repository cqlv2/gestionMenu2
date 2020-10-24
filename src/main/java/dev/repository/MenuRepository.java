package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer>{

	List<Menu> findByDate(String value);

	List<Menu> findByDateBetween(String value, String value2);

}
