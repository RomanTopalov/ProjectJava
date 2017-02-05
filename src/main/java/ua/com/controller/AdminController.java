package ua.com.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.com.entity.Country;



@Controller
public class AdminController {

	/*@Autowired
	private ImageService imageService;*/
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String newAuthor(Model model) {

		return "views-admin-admin";
	}
	
	
	

/*	@RequestMapping(value = "/image", method = RequestMethod.GET)
	public String image(Model model) {
		return "views-admin-image";
	}
	
	
	@RequestMapping(value = "/image", method = RequestMethod.POST)
    public String saveImage(
                            @RequestParam MultipartFile [] images ) {

        

        return "redirect:/home";
    }*/
}
