package ua.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.entity.Country;
import ua.com.service.CountryService;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	
	@RequestMapping(value = "/newCountry", method = RequestMethod.GET)
	public String saveCountry(Model model) {
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("country", new Country());
		return "views-admin-newCountry";
	}
	
	@RequestMapping(value = "/newCountry", method = RequestMethod.POST)
	public String saveCountry(@ModelAttribute Country country) {
		
		countryService.save(country);
		
		return "redirect:/newCountry";
	}
	
}
