/**
 * 
 */
package fr.soat.accessWithhibernate.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * @author Formation
 *
 */

@Entity
@Table(schema = "test", name = "client")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5724720529802852401L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_CLIENT")
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

}
