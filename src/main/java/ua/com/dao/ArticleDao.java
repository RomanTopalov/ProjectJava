package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.entity.Article;


public interface ArticleDao  extends JpaRepository<Article, Integer>{

}
