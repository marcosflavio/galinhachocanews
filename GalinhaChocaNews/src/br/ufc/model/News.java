package br.ufc.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Length;

@Entity(name = "noticia")
public class News {

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private Long id;

	@Length(min = 5, max = 50)
	@Column(name = "titulo", nullable = false)
	private String title;

	@Length(min = 5, max = 150)
	@Column(name = "sub_titulo", nullable = false)
	private String subTitle;

	@Length(min = 5, max = 500)
	@Column(name = "texto", nullable = false)
	private String text;

	@Column(name = "data_noticia", nullable = false)
	private Date newsDate;

	@ManyToOne
	@JoinColumn(name = "id_autor", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "id_secao", nullable = false)
	private Section section;

	@Transient
	private String date;
	
	@Transient
	private Long idSection;
	
	public News() {
	}

	/* Get´s and Set´s */

	public String getTitle() {
		return title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User idAuthor) {
		this.user = idAuthor;
	}

	public Date getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(Date newsDate) {

		this.newsDate = newsDate;
	}


	public void setIdSection(Section idSection) {
		this.section = idSection;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public String getDate() {
		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		 Date date = this.getNewsDate();
		 
		 this.date = dateFormat.format(date);
		 return this.date;
	}

//	public void setDate(String date) {
//		
//		this.date = date;
//	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setIdSection(Long IdSection) {
		idSection = IdSection;
	}

	public Long getIdSection() {
		return idSection;
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
		News other = (News) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
