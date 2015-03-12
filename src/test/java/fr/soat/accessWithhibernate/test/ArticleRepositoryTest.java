package fr.soat.accessWithhibernate.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.soat.accessWithhibernate.domain.Article;
import fr.soat.accessWithhibernate.repositories.IArticleRepository;

public class ArticleRepositoryTest extends GenericRespositoryTest {

	@Autowired
	IArticleRepository articleRepository;

	@Test
	public void createNewArticle() {
		Article article = new Article();
		article.setCodeArticle("code Article 2015");
		articleRepository.create(article);

	}

}
