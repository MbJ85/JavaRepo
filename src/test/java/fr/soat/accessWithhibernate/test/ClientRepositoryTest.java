package fr.soat.accessWithhibernate.test;

import java.util.List;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import fr.soat.accessWithhibernate.domain.Client;
import fr.soat.accessWithhibernate.domain.Commande;
import fr.soat.accessWithhibernate.repositories.IClientRepository;

public class ClientRepositoryTest extends GenericRespositoryTest {

	@Autowired
	IClientRepository clientRepository;

	@Test
	public void createNewClient() {
		Client client = new Client();
		client.setNomClient("Client nv 3");
		client.setDateNaissanceClient(new DateTime(1970, 4, 17, 23, 14));
		clientRepository.create(client);
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void mettre_a_jour_un_client_existant() {
		Client client = new Client();
		client.setIdClient(1);
		client.setNomClient("Mise a jour Client 1 deuxieme fois");
		client.setAgeClient(36);
		client.setDateNaissanceClient(new DateTime(1980, 5, 17, 23, 14));
		clientRepository.update(client);
	}

	@Test
	public void supprimer_un_client() {
	}

	@Test
	@Transactional
	public void recuperer_un_client_via_son_id() {
		Client client = clientRepository.findOneEntityById(Client.class, 1);
		System.out.println("Client 1 est "  );
		List<Commande> commandes = client.getCommandes();
		System.out.println("***** Client 1 est " + client.toString());
		System.out.println("Commandes " + commandes.size());
	}
	
	
	@Test
	@Transactional
	public void recuperer_tous_les_clients() {
		List<Client> clients= clientRepository.findAllEntities(Client.class);
		System.out.println("***** CLIENTS SIZE ******** " + clients.size());
		for (Client client : clients) {
			System.out.println("***** CLIENT Details ****** " + client.toString());
		}
	}


	@Test
	@Transactional
	public void recuperer_un_client_via_son_prenom() {
		List<Client> clients= clientRepository.findClientsByName("Client nv");
		System.out.println("***** CLIENTS SIZE ******** " + clients.size());
		for (Client client : clients) {
			System.out.println("***** CLIENT Details ****** " + client.toString());
		}

	}

	@Test
	@Transactional
	public void recuperer_un_client_via_son_age() {
		List<Client> clients= clientRepository.findClientsByAge("36");
		System.out.println("***** CLIENTS SIZE ******** " + clients.size());
		for (Client client : clients) {
			System.out.println("***** CLIENT Details ****** " + client.toString());
		}

	}

	@Test
	@Transactional
	public void recuperer_un_client_via_sa_ville() {
		List<Client> clients= clientRepository.findClientsByVille("wonderfull");
		System.out.println("***** CLIENTS SIZE ******** " + clients.size());
		for (Client client : clients) {
			System.out.println("***** CLIENT Details ****** " + client.toString());
		}

	}

	@Test
	@Transactional
	public void recuperer_un_client_via_son_prenom_et_sa_ville() {
		List<Client> clients= clientRepository.findClientsByNameAndVille("hello", "wonderfull");
		System.out.println("***** CLIENTS SIZE ******** " + clients.size());
		for (Client client : clients) {
			System.out.println("***** CLIENT Details ****** " + client.toString());
		}

	}
	
	@Test
	@Transactional
	public void recuperer_un_client_via_son_age_et_le_code_de_sa_commande_en_utilisant_jpql() {
		List<Client> clients= clientRepository.findClientsCommandes1("36", "Commande le 20 Mars");
		System.out.println("***** CLIENTS SIZE ******** " + clients.size());
		for (Client client : clients) {
			System.out.println("***** CLIENT Details ****** " + client.toString());
		}

	}

	@Test
	@Transactional
	public void recuperer_un_client_via_son_age_et_le_code_de_sa_commande_en_utilisant_native_sql() {
		List<Client> clients= clientRepository.findClientsCommandes2("36", "Commande le 20 Mars");
		System.out.println("***** CLIENTS SIZE ******** " + clients.size());
		for (Client client : clients) {
			System.out.println("***** CLIENT Details ****** " + client.toString());
		}

	}

}