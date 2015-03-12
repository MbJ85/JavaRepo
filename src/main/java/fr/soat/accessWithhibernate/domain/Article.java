package fr.soat.accessWithhibernate.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "test", name = "article")
public class Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6183188001037172679L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_ARTICLE")
	private Integer idArticle;

	@Column(name = "LIBELLE_ARTICLE")
	private String codeArticle;

	@Column(name = "PRIX_ARTICLE")
	private double prixArticle;

	public Integer getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public double getPrixArticle() {
		return prixArticle;
	}

	public void setPrixArticle(double prixArticle) {
		this.prixArticle = prixArticle;
	}

}
