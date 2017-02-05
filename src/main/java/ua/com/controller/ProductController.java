package ua.com.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ua.com.dto.DtoUtilMapper;
import ua.com.dto.ProductDTO;
import ua.com.editor.CategoryEditor;
import ua.com.editor.CountryEditor;
import ua.com.entity.Category;
import ua.com.entity.Product;
import ua.com.entity.Country;
import ua.com.entity.User;
import ua.com.service.CategoryService;
import ua.com.service.ProductService;
import ua.com.service.CountryService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private CategoryService categoryService;

	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
	}

	@RequestMapping(value = "/newProduct", method = RequestMethod.GET)
	public String newProduct(Model model) {

		model.addAttribute("products", productService.findAll());
		model.addAttribute("product", new Product());
		model.addAttribute("countriesDTOs", DtoUtilMapper.countriesToCountriesDTOs(countryService.findAll()));
		model.addAttribute("categoriesDTOs", DtoUtilMapper.categoriesToCategoriesDTOs(categoryService.findAll()));
	
		return "views-admin-newProduct";
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute Product product, @RequestParam String count, @RequestParam String price) {

		product.setCount(Integer.parseInt(count));

		product.setPrice(Integer.parseInt(price));

		productService.save(product);

		return "redirect:/newProduct";
	}

	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable int id) {

		productService.delete(id);

		return "redirect:/newProduct";
	}
	
	@RequestMapping(value = "/sortProducts", method = RequestMethod.POST)
	public @ResponseBody List<ProductDTO>	sortProducts(@RequestBody String index){


		List<Product> productList = productService.sortProducts(Integer.parseInt(index));

		return DtoUtilMapper.productsToProductsDTO(productList);


	}
	
	

	/*@RequestMapping(value = "/saveImageProduct", method = RequestMethod.POST)
	public String saveImageProduct(Principal principal, @RequestParam MultipartFile image) {

		productService.saveImageProduct(principal, image);

		return "redirect:/newProduct";
	}*/

}
