package ua.com.service;

import java.util.List;

import ua.com.entity.Category;

public interface CategoryService {

	void save(Category category);
	List<Category> findAll();
	Category findOne(int id);
	void delete(int id);
		
	void deleteProductFromCategory(String idProduct);
	
	List<Category> findCategoryWithProducts();
	
	void saveAndFlush(Category category);
	
}
