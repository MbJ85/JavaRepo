package fr.soat.accessWithhibernate.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@Column(name = "ID_COMMANDE")
	private Integer idCommande;

	@Column(name = "CODE_COMMANDE")
	private String codeCommande;

	@Column(name = "DATE_COMMANDE")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dateCommande;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CLIENT")
	private Client aClient;

	@ManyToMany
	@JoinTable(name = "commande_details", joinColumns = @JoinColumn(name = "ID_COMMANDE", referencedColumnName = "ID_COMMANDE"), inverseJoinColumns = @JoinColumn(name = "ID_ARTICLE", referencedColumnName = "ID_ARTICLE"))
	private List<Article> articles;

	public Integer getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Integer idCommande) {
		this.idCommande = idCommande;
	}

	public String getCodeComamande() {
		return codeCommande;
	}

	public void setCodeComamande(String codeComamande) {
		this.codeCommande = codeComamande;
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

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}