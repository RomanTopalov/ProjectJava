package ua.com.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.entity.Article;
import ua.com.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = "/newArticle", method = RequestMethod.GET)
	public String newArticle(Model model) {
model.addAttribute("articles", articleService.findAll());
model.addAttribute("article", new Article());

		return "views-admin-newArticle";
	}
	@Transactional
	@RequestMapping(value = "/createArticle", method = RequestMethod.POST)
	public String createArticle(/*@RequestParam String articleName, @RequestParam String articleData*/
			@ModelAttribute Article article, 
			@RequestParam String date) {

		//Article article =new Article(articleName, articleData);
      
		LocalDate localDate = LocalDate.parse(date);
		article.setDateofPublic(localDate);

		articleService.save(article);

		return "redirect:/newArticle";
	}
	@RequestMapping(value = "/deleteArticle/{id}", method = RequestMethod.GET)
	public String newAuthor(@PathVariable String id) {
		articleService.delete(Integer.parseInt(id));
		return "redirect:/newArticle";
	}

}
