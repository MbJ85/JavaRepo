/**
 * 
 */
package fr.soat.accessWithhibernate.repositories;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import fr.soat.accessWithhibernate.domain.Client;

/**
 * @author Formation
 *
 */

@Repository
public class ClientRepository extends GenericRepository<Client, Integer>
		implements IClientRepository {

	private static final String GET_CLIENTS_BY_VILLE = "SELECT * FROM client client WHERE client.VILLE_CLIENT = ?";

	private static final String GET_CLIENTS_BY_AGE = "SELECT client FROM Client client WHERE client.ageClient = :ageClient";

	// Utilisation du SQL Native
	@SuppressWarnings("unchecked")
	public List<Client> findClientsByVille(String clientVille) {
		Query query = entityManager.createNativeQuery(GET_CLIENTS_BY_VILLE,
				Client.class);
		query.setParameter(1, clientVille);
		return (List<Client>) query.getResultList();
	}

	// Utilisation de SQL JPA (JPAQL)
	public List<Client> findClientsByAge(String clientAge) {
		TypedQuery<Client> query = entityManager.createQuery(
				GET_CLIENTS_BY_AGE, Client.class);
		query.setParameter("ageClient", Integer.parseInt(clientAge));
		return query.getResultList();
	}

	// Utilisation des named JPAQL Query
	public List<Client> findClientsByName(String clientName) {
		TypedQuery<Client> query = entityManager.createNamedQuery(
				"getClientsByName", Client.class);
		query.setParameter("nomClient", clientName);
		return query.getResultList();
	}

	// Utilisation des named Native Query
	public List<Client> findClientsByNameAndVille(String clientName,
			String clientVille) {
		TypedQuery<Client> query = entityManager.createNamedQuery(
				"getClientsByNameAndVille", Client.class);
		query.setParameter(1, clientName);
		query.setParameter(2, clientVille);
		return query.getResultList();
	}

	// Utilisation des named Query avec Jointure sur la table des commandes
	public List<Client> findClientsCommandes1(String ageClient,
			String codeCommande) {
		TypedQuery<Client> query = entityManager.createNamedQuery(
				"getClientsCommandesJPQL", Client.class);
		query.setParameter("ageClient", Integer.parseInt(ageClient));
		query.setParameter("codeCommande", codeCommande);
		return query.getResultList();
	}


	// Utilisation des named Native Query avec Jointure sur la table des commandes
	public List<Client> findClientsCommandes2(String ageClient,
			String codeCommande) {
		TypedQuery<Client> query = entityManager.createNamedQuery(
				"getClientsCommandesNativeSQL", Client.class);
		query.setParameter(1, ageClient);
		query.setParameter(2, codeCommande);
		return query.getResultList();
	}

	@Override
	public List<Client> findClientsCommandesByDate(String ageClient,
			DateTime startDate, DateTime endDate) {
		TypedQuery<Client> query = entityManager.createNamedQuery(
				"getClientsCommandesByDate", Client.class);
		query.setParameter("ageClient", Integer.parseInt(ageClient));
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		return query.getResultList();
	}

	
	
}