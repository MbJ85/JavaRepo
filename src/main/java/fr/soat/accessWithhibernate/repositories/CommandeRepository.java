/**
 * 
 */
package fr.soat.accessWithhibernate.repositories;

import org.springframework.stereotype.Repository;

import fr.soat.accessWithhibernate.domain.Commande;

/**
 * @author Formation
 *
 */

@Repository
public class CommandeRepository extends GenericRepository<Commande, Integer>
		implements ICommandeRepository {

}
