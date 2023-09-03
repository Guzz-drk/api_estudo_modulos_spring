package com.gupan.estudo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gupan.estudo.dto.ClassDTO;

public interface ClassRepository extends JpaRepository<ClassDTO, Long>{

	@Query(nativeQuery = true, value = "select cd_class, ds_num_class, "
			+ "ds_recommended_quarter, edited_at "
			+ "from class "
			+ "order by ds_recommended_quarter asc, ds_num_class asc")
	public Page<List<ClassDTO>> getListClasses(Pageable page);
}
