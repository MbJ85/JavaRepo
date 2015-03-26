/**
 * 
 */
package fr.soat.accessWithhibernate.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * @author Formation
 *
 */

@Entity
@Table(schema = "test", name = "client")
@NamedQueries({
		@NamedQuery(name = "getClientsByName", query = "FROM Client client where client.nomClient = :nomClient "),
		@NamedQuery(name = "getClientsCommandesJPQL", query = "SELECT DISTINCT c FROM Client c JOIN c.commandes comm "
				+ "WHERE c.ageClient = :ageClient AND comm.codeCommande = :codeCommande"),
		@NamedQuery(name = "getClientsCommandesByDate", query = "SELECT DISTINCT c FROM Client c JOIN c.commandes comm "
				+ "WHERE c.ageClient = :ageClient AND comm.dateCommande BETWEEN :startDate AND :endDate")

})
@NamedNativeQueries({
		@NamedNativeQuery(name = "getClientsByNameAndVille", query = "SELECT * FROM client client WHERE client.NOM_CLIENT = ? "
				+ "AND client.VILLE_CLIENT = ? ", resultClass = Client.class),
		@NamedNativeQuery(name = "getClientsCommandesNativeSQL", query = "SELECT * FROM client client JOIN commande commande "
				+ "ON client.ID_CLIENT = commande.CLIENT AND client.AGE_CLIENT =  ? "
				+ "AND commande.CODE_COMMANDE = ?", resultClass = Client.class) })
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5724720529802852401L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CLIENT")
	private int idClient;

	@Column(name = "NOM_CLIENT")
	private String nomClient;

	@Column(name = "PRENOM_CLIENT")
	private String prenomClient;

	@Column(name = "VILLE_CLIENT")
	private String villeClient;

	@Column(name = "DATE_NAISSANCE_CLIENT")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dateNaissanceClient;

	@Column(name = "AGE_CLIENT")
	private int ageClient;

	@OneToMany(mappedBy = "aClient", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<Commande> commandes;

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getVilleClient() {
		return villeClient;
	}

	public void setVilleClient(String villeClient) {
		this.villeClient = villeClient;
	}

	public DateTime getDateNaissanceClient() {
		return dateNaissanceClient;
	}

	public void setDateNaissanceClient(DateTime dateNaissanceClient) {
		this.dateNaissanceClient = dateNaissanceClient;
	}

	public int getAgeClient() {
		return ageClient;
	}

	public void setAgeClient(int ageClient) {
		this.ageClient = ageClient;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	@Override
	public String toString() {
		String commandesString = " size " + this.commandes.size();

		for (Commande commande : this.commandes) {
			commandesString = commandesString + " nom Commande "
					+ commande.getCodeComamande() + " id commande "
					+ commande.getIdCommande();
		}

		return "Client [idClient=" + idClient + ", nomClient=" + nomClient
				+ ", prenomClient=" + prenomClient + ", villeClient="
				+ villeClient + ", dateNaissanceClient=" + dateNaissanceClient
				+ ", ageClient=" + ageClient + ", commandes=" + commandesString
				+ "]";
	}
}