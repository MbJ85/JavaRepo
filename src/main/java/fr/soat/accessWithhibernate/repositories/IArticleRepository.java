/**
 * 
 */
package fr.soat.accessWithhibernate.repositories;

import fr.soat.accessWithhibernate.domain.Article;

/**
 * @author Formation
 *
 */

public interface IArticleRepository extends
		IGenericRepository<Article, Integer> {

	Article findArticleByCode(String code);

}
