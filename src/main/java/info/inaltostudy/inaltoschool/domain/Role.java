package info.inaltostudy.inaltoschool.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class Role {
	
	@Id
	@Column(name = "ROLE_ID")
	@GeneratedValue
	private Integer role_id;
	
	@Column(name = "ROLE_NAME")
	private String role_name;
	
	@Column(name = "ROLE_DETAILS")
	private String role_details;
	
	// Getters and setters
	public Integer getRole_id() {
		return role_id;
	}
	
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	
	public String getRole_name() {
		return role_name;
	}
	
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	public String getRole_details() {
		return role_details;
	}
	
	public void setRole_details(String role_details) {
		this.role_details = role_details;
	}

}
