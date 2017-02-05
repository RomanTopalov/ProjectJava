package ua.com.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ua.com.dao.ProductDao;
import ua.com.entity.Product;
import ua.com.entity.User;

import ua.com.service.ProductService;

@Service
public class  ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;

	public void save(Product product) {
		productDao.save(product);
	}

	public List<Product> findAll() {
		return productDao.findAll();
	}

	public Product findOne(int id) {
		return productDao.findOne(id);
	}

	public void delete(int id) {
		productDao.delete(id);
	}
	
	/*@Transactional
	public void save(Product product, MultipartFile image) {
		productDao.saveAndFlush(product);


		String path = System.getProperty("catalina.home") + "/resources/" + product.getName() + "/"
				+ image.getOriginalFilename();

product.setImage("resources/" + product.getName() + "/" + image.getOriginalFilename());

		File file = new File(path);

		try {
			file.mkdirs();
			try {
				FileUtils.cleanDirectory(
						new File(System.getProperty("catalina.home") + "/resources/" + product.getName() + "/"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			image.transferTo(file);
		} catch (IOException e) {
			System.out.println("error with file");
		}


	}*/
	
	@Override
	public List<Product> liveSearch(String search) {
		return productDao.liveSearch(search);
	}

	@Override
	public List<Product> sortProducts(int price) {
		// TODO Auto-generated method stub
		return productDao.sortProducts(price);
	}


}
