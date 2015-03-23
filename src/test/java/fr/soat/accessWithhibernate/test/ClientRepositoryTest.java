package fr.soat.accessWithhibernate.test;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import fr.soat.accessWithhibernate.domain.Client;
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
	public void recuperer_un_client_via_son_id() {
		Client client = clientRepository.findOneEntityById(Client.class, 1);
		System.out.println("Client 1 est " + client.toString());
	}

	@Test
	public void recuperer_un_client_via_son_prenom() {
	}

}