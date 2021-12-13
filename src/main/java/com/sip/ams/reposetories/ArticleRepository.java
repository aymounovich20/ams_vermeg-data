package com.sip.ams.reposetories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.ams.entities.Article;
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	Article findArticleByPicture(String picture);
}