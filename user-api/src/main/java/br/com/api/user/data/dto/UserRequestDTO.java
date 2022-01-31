package br.com.api.user.data.dto;
import java.io.Serializable;

public class UserRequestDTO implements Serializable {
	
	private String name;
	private String cpf;
	private String email;
	private String phone_number;

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
//	public LocalDateTime getCreated_at() {
//		return created_at;
//	}
//	public void setCreated_at(LocalDateTime created_at) {
//		this.created_at = created_at;
//	}
//	
//	public LocalDateTime getUpdated_at() {
//		return updated_at;
//	}
//	public void setUpdated_at(LocalDateTime updated_at) {
//		this.updated_at = updated_at;
//	}

		
	
}
