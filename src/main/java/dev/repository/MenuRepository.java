package dev.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer>{

	List<Menu> findByDate(String value);

	List<Menu> findByDateBetween(LocalDate localDate, LocalDate localDate2);

	Optional<Menu> findByDate(LocalDate day);

}
