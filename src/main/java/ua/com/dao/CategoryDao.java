package ua.com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{
	
	@Query("select distinct a from Category a left join fetch a.products")
	List<Category> findCategoryWithProduct();
	
	@Query("select distinct a from Category a left join fetch a.products where a.id =:id")
	Category findCategoryWithProduct(@Param("id") int id);

	
	
	
}
	 