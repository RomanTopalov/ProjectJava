package ua.com.controller;

import java.security.Principal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.entity.User;
import ua.com.service.ProductService;
import ua.com.service.UserService;

@Controller
public class CookieController {

	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/buyProduct/{id}", method = RequestMethod.GET)
	public String buyProduct(@PathVariable String id, HttpServletRequest request,
			HttpServletResponse response) {

		userService.intoBasket(Integer.parseInt(id), request, response);

		// userService.buyBook(principal, id);

		return "redirect:/";
	}
	
	
	
	

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(HttpServletRequest request, Principal principal, Model model) {

		User user = userService.findOne(Integer.parseInt(principal.getName()));

		model.addAttribute("user", user);
		model.addAttribute("products", userService.userProductsCookie(request));

		return "views-user-profile";
	}
	
	
	
	
	
	

	@RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET)
	public String getOrder(Principal principal, @PathVariable String id, HttpServletRequest request,
			HttpServletResponse response ,Model model) {
		

		userService.getOrder(principal, id, request.getCookies(), response);
		
		for (Cookie c : request.getCookies()) {
            if (c.getName().equals("JSESSIONID"))
            	System.out.println(c.getValue());
            }
        

		return "redirect:/basket";
	}


	@RequestMapping(value = "/deleteFromOrder/{id}", method = RequestMethod.GET)
    public String deleteCookie(@PathVariable String id, HttpServletRequest request,
                               HttpServletResponse response) {

        userService.deleteCookieFromOrder(id, request, response);

        return "redirect:/basket";
    }
	
	  @RequestMapping(value = "/basket", method = RequestMethod.GET)
		public String basket(HttpServletRequest request, Model model){

			model.addAttribute("products", userService.userProductsCookie(request));

			return "views-base-basket";
		}



}
