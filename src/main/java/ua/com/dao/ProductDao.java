package ua.com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.entity.Product;


public interface ProductDao extends JpaRepository<Product, Integer> {

	
	 @Query("select p from Product p where p.name LIKE CONCAT('%',:search,'%')")
	    List<Product> liveSearch(@Param("search") String search);

	 @Query("select p from Product p where p.price > :price")
	    List<Product> sortProducts(@Param("price") int price);
/*	 
	 @Query("select p from Product p left join fetch p.images where p.id > :id")
	   Product productWithImage(@Param("id") int id);
	  @Query("select p from Product p left join fetch p.images")
	    List<Product> images();*/
}
