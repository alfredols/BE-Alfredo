package br.com.api.user.data.model;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{ 
	
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false, length = 11)
	private String cpf;
	
	@Column(nullable = true, length = 100)
	private String email;
	
	@Column(nullable = true)
	private String phone_number;
	
	@Column(nullable = true)
	private Date  created_at;

	@Column(nullable = true)
	private Date updated_at;	

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Date  getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date  created_at) {
		this.created_at = created_at;
	}

	public Date  getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date date) {
		this.updated_at = date;
	}
	
}





