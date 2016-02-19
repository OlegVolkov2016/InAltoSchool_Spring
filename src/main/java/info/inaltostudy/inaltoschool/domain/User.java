package info.inaltostudy.inaltoschool.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {
	
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue
	private Integer user_id;
	
	@Column(name = "LOGIN_ID")
	private Integer login_id;
	
	@Column(name = "USER_FIRSTNAME")
	private String user_firstname;
	
	@Column(name = "USER_LASTNAME")
	private String user_lastname;
	
	@Column(name = "USER_BIRTHDAY")
	private Date user_birthday;
	
	@Column(name = "USER_ADDRESS")
	private String user_address;
	
	@Column(name = "USER_PHONE")
	private String user_phone;
	
	@Column(name = "USER_EMAIL")
	private String user_email;
	
	@Column(name = "USER_SKYPE")
	private String user_skype;
	
	@Column(name = "USER_DETAILS")
	private String user_details;
	
	// Getters and setters
	public Integer getUser_id() {
		return user_id;
	}
	
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	public Integer getLogin_id() {
		return login_id;
	}
	
	public void setLogin_id(Integer login_id) {
		this.login_id = login_id;
	}
	
	public String getUser_firstname() {
		return user_firstname;
	}
	
	public void setUser_firstname(String user_firstname) {
		this.user_firstname = user_firstname;
	}
	
	public String getUser_lastname() {
		return user_lastname;
	}
	
	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}
	
	public Date getUser_birthday() {
		return user_birthday;
	}
	
	public void setUser_birthday(Date user_birthday) {
		this.user_birthday = user_birthday;
	}
	
	public String getUser_address() {
		return user_address;
	}
	
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	
	public String getUser_phone() {
		return user_phone;
	}
	
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	
	public String getUser_email() {
		return user_email;
	}
	
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	public String getUser_skype() {
		return user_skype;
	}
	
	public void setUser_skype(String user_skype) {
		this.user_skype = user_skype;
	}
	
	public String getUser_details() {
		return user_details;
	}
	
	public void setUser_details(String user_details) {
		this.user_details = user_details;
	}

}
