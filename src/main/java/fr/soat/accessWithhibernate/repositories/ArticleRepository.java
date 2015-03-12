/**
 * 
 */
package fr.soat.accessWithhibernate.repositories;

import org.springframework.stereotype.Repository;

import fr.soat.accessWithhibernate.domain.Article;

/**
 * @author Formation
 *
 */
@Repository
public class ArticleRepository extends GenericRepository<Article, Integer>
		implements IArticleRepository {


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.soat.accessWithhibernate.repositories.IArticleRepository#findArticleByCode
	 * (java.lang.String)
	 */
	@Override
	public Article findArticleByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
