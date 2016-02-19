package info.inaltostudy.inaltoschool.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOGINS")
public class Login {
	
	@Id
	@Column(name = "LOGIN_ID")
	@GeneratedValue
	private Integer login_id;
	
	@Column(name = "ROLE_ID")
	private Integer role_id;
	
	@Column(name = "LOGIN_NAME")
	private String login_name;
	
	@Column(name = "LOGIN_PASSWORD")
	private Integer login_password;
	
	@Column(name = "LOGIN_QUESTION")
	private String login_question;
	
	@Column(name = "LOGIN_ANSWER")
	private Integer login_answer;
	
	// Getters and setters
	public Integer getLogin_id() {
		return login_id;
	}
	
	public void setLogin_id(Integer login_id) {
		this.login_id = login_id;
	}
	
	public String getLogin_name() {
		return login_name;
	}
	
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	
	public Integer getRole_id() {
		return role_id;
	}
	
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	
	public Integer getLogin_password() {
		return login_password;
	}
	
	public void setLogin_password(Integer login_password) {
		this.login_password = login_password;
	}
	
	public String getLogin_question() {
		return login_question;
	}
	
	public void setLogin_question(String login_question) {
		this.login_question = login_question;
	}
	
	public Integer getLogin_answer() {
		return login_answer;
	}
	
	public void setLogin_answer(Integer login_answer) {
		this.login_answer = login_answer;
	}

}
