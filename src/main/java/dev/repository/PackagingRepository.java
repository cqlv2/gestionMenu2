package dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import dev.entity.Packaging;
import dev.enumeration.PackagingEnum;
import dev.enumeration.UnitEnum;

@Repository
public interface PackagingRepository
		extends JpaRepository<Packaging, Long>, JpaSpecificationExecutor<Packaging> {

}
