package fr.soat.accessWithhibernate.test;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import fr.soat.accessWithhibernate.domain.Client;
import fr.soat.accessWithhibernate.domain.Commande;
import fr.soat.accessWithhibernate.repositories.IClientRepository;
import fr.soat.accessWithhibernate.repositories.ICommandeRepository;

public class CommandeRepositoryTest extends GenericRespositoryTest {

	@Autowired
	private ICommandeRepository commandeRepository;

	@Autowired
	private IClientRepository clientRepository;

	@Test
	public void creer_une_nouvelle_commande_avec_un_nouveau_client() {
		Commande commande = new Commande();
		Client client = new Client();
		client.setNomClient("NomClient");
		commande.setCodeComamande("code commande 2");
		commande.setDateCommande(new DateTime());
		commande.setaClient(client);
		commandeRepository.create(commande);

	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void creer_une_nouvelle_commande_avec_client_deja_existant() {
		Client client = clientRepository.findOneEntityById(Client.class, 1);
		Commande commande = new Commande();
		commande.setCodeComamande("Commande le 20 Mars");
		commande.setDateCommande(new DateTime());
		commande.setaClient(client);
		commandeRepository.create(commande);
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void mettre_a_jour_une_commande_avec_un_client_existant() {
		Client client = clientRepository.findOneEntityById(Client.class, 2);
		Commande commande = commandeRepository.findOneEntityById(
				Commande.class, 2);
		commande.setaClient(client);
		commande.setCodeComamande("code commande mise a jour");
		commandeRepository.update(commande);
	}

	@Test
	public void supprimer_une_commande() {
	}

	@Test
	public void supprimer_une_commande_et_son_client() {
	}

	@Test
	public void recuperer_une_commande_via_son_id() {
	}

	@Test
	public void recuperer_une_commande_via_son_id_client() {
	}

	@Test
	public void recuperer_une_commande_via_son_code() {
	}

}