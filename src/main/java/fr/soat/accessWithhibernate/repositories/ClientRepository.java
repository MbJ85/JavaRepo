/**
 * 
 */
package fr.soat.accessWithhibernate.repositories;

import org.springframework.stereotype.Repository;

import fr.soat.accessWithhibernate.domain.Client;



/**
 * @author Formation
 *
 */

@Repository
public class ClientRepository extends GenericRepository<Client, Integer> implements IClientRepository {

}
