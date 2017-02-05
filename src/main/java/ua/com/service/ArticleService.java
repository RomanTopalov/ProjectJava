package ua.com.service;

import java.util.List;

import ua.com.entity.Article;





public interface ArticleService {
	void save(Article article);
	List<Article> findAll();
	Article findOne(int id);
	void delete(int id);

}
