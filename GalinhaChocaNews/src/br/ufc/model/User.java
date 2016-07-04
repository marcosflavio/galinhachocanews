package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Length;

@Entity(name = "usuario")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private Long id;

	@Length(min = 5, max = 20)
	@Column(name = "login", nullable = false)
	private String login;

	@Length(min = 5, max = 20)
	@Column(name = "senha", nullable = false)
	private String password;

	@Length(min = 5, max = 50)
	@Column(name = "nome", nullable = false)
	private String name;

	@Length(min = 5, max = 50)
	@Column(name = "email", nullable = false)
	private String email;

	@Transient
	private Long roleAux;

	@ManyToOne
	@JoinColumn(name = "id_papel", nullable = false)
	private Role role;

	public User() {
	}

	/* Get´s and Set´s */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role_id) {
		this.role = role_id;
	}

	/* Hash and Equals */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRoleAux() {
		return roleAux;
	}

	public void setRoleAux(Long roleAux) {
		this.roleAux = roleAux;
	}

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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}


}
