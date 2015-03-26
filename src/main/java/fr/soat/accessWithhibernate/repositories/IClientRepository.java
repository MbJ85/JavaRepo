/**
 * 
 */
package fr.soat.accessWithhibernate.repositories;

import java.util.List;

import org.joda.time.DateTime;

import fr.soat.accessWithhibernate.domain.Client;

/**
 * @author Formation
 *
 */
public interface IClientRepository extends IGenericRepository<Client, Integer> {

	List<Client> findClientsByName(String clientName);

	List<Client> findClientsByVille(String clientVille);

	List<Client> findClientsByAge(String clientAge);

	List<Client> findClientsByNameAndVille(String clientName, String clientVille);

	List<Client> findClientsCommandes1(String ageClient, String codeCommande);

	List<Client> findClientsCommandes2(String ageClient, String codeCommande);
	
	List<Client> findClientsCommandesByDate(String ageClient, DateTime startDate, DateTime endDate);
}
