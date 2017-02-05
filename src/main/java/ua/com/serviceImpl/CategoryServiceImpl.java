package ua.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.dao.CategoryDao;
import ua.com.dao.ProductDao;
import ua.com.entity.Category;
import ua.com.entity.Product;
import ua.com.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProductDao productDao;

	public void save(Category category) {
		categoryDao.save(category);
	}

	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	public Category findOne(int id) {
		return categoryDao.findOne(id);
	}
	public List<Category> findCategoryWithProducts() {
		return categoryDao.findCategoryWithProduct();
	}

	@Transactional
	public void delete(int id) {
		Category category = categoryDao.findCategoryWithProduct(id);
		
		for(Product product : category.getProducts()){
			product.setCategory(null);
			productDao.save(product);
		}
		
		categoryDao.delete(category);
		
	}

	
	
	public void saveAndFlush(Category author) {
		categoryDao.saveAndFlush(author);
	}

	
	
	@Transactional
	public void deleteProductFromCategory(String idProduct) {
		
		Product product = productDao.findOne(Integer.parseInt(idProduct));
		
		product.setCategory(null);
		
		productDao.save(product);
	}



}
