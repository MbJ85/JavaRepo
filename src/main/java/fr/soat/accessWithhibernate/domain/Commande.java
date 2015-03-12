package fr.soat.accessWithhibernate.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(schema = "test", name = "commande")
public class Commande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7064826575850239952L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_COMMANDE")
	private Integer idCommande;

	@Column(name = "CODE_COMMANDE")
	private String codeComamande;

	@Column(name = "DATE_COMMANDE")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dateCommande;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CLIENT")
	private Client aClient;

	public Integer getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Integer idCommande) {
		this.idCommande = idCommande;
	}

	public String getCodeComamande() {
		return codeComamande;
	}

	public void setCodeComamande(String codeComamande) {
		this.codeComamande = codeComamande;
	}

	public DateTime getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(DateTime dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Client getaClient() {
		return aClient;
	}

	public void setaClient(Client aClient) {
		this.aClient = aClient;
	}

}