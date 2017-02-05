package ua.com.service;

import java.security.Principal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.com.entity.Product;

public interface ProductService {

	 void save(Product product);
	 
	/*void save(Product product,MultipartFile imge);*/
	List<Product> findAll();
	Product findOne(int id);
	void delete(int id);
	
	/* public void saveImageProduct(Principal principal, MultipartFile multipartFile);*/
	 
	 List<Product> sortProducts(int price);
	 List<Product> liveSearch(String search);
	 
	
	/* List<Product>images();*/
}
