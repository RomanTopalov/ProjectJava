package ua.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.com.dto.DtoUtilMapper;
import ua.com.dto.ProductDTO;
import ua.com.editor.ProductEditor;
import ua.com.entity.Product;
import ua.com.service.ProductService;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Product.class, new ProductEditor(productService));
	}

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Model model, Principal principal) {
		model.addAttribute("products", productService.findAll());
		return "views-base-home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String loginprocesing() {
		return "redirect:/home";
	}

	@RequestMapping("/loginpage")
	public String login() {
		return "views-base-loginpage";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout() {

		return "redirect:/";
	}

	@RequestMapping(value = "/some", method = RequestMethod.GET)
	public String some() {

		return "redirect:/HTMLpages/some.html";
	}
	
	
	
	
	
	@RequestMapping(value = "/liveSearchProducts", method = RequestMethod.POST)
	public @ResponseBody List<ProductDTO> liveSearchProducts(@RequestBody String search){

		System.out.println(search);

		System.out.println(productService.liveSearch(search));
		for (Product product: productService.liveSearch(search)) {
			System.out.println(product);
		}

		List<Product> productList = productService.liveSearch(search);

		return DtoUtilMapper.productsToProductsDTO(productList);
	}

}
