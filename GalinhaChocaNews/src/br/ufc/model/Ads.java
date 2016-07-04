package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Length;

@Entity(name = "classificados")
public class Ads {

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private Long id;

	@Length(min = 5, max = 50)
	@Column(name = "titulo", nullable = false)
	private String title;

	@Length(min = 20, max = 250)
	@Column(name = "texto", nullable = false)
	private String text;

	@Column(name = "preco", nullable = false)
	private Float price;

	@Length(min = 8, max = 20)
	@Column(name = "telefone", nullable = false)
	private String tellephone;

	@ManyToOne
	@JoinColumn(name = "id_autor", nullable = false) 
	private User user;

	public Ads() {

	}

	/* Get´s and Set´s */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getTellephone() {
		return tellephone;
	}

	public void setTellephone(String tellephone) {
		this.tellephone = tellephone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/* Hash and Equals */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ads other = (Ads) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
