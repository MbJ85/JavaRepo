package fr.soat.accessWithhibernate.test;

import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.soat.accessWithhibernate.domain.Client;
import fr.soat.accessWithhibernate.domain.Commande;
import fr.soat.accessWithhibernate.repositories.ICommandeRepository;

public class CommandeRepositoryTest extends GenericRespositoryTest {

	@Autowired
	private ICommandeRepository commandeRepository;

	@Test
	public void creer_une_nouvelle_commande_avec_client_deja_existant() {
		Commande commande = new Commande();
		Client client = new Client();
		commande.setCodeComamande("code commande 3");
		commande.setDateCommande(new DateTime());
		commande.setaClient(client);
		commandeRepository.create(commande);
	}

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
	public void mettre_a_jour_une_commande_avec_un_client_existant() {
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