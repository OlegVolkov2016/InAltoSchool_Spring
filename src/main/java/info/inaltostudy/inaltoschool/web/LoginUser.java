package info.inaltostudy.inaltoschool.web;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import info.inaltostudy.inaltoschool.domain.Login;
import info.inaltostudy.inaltoschool.domain.User;

public class LoginUser{
	private String role_name;
	private String login_name;
	private String login_password;
	private String login_password_repeat;
	private String login_question;
	private String login_answer;
	private String user_firstname;
	private String user_lastname;
	private String user_birthday;
	private String user_address;
	private String user_phone;
	private String user_email;
	private String user_skype;
	private String user_details;
	
	public void setLoginUser(User user, Login login, String role_name) {
		this.role_name = role_name;
		this.login_name = login.getLogin_name();
		this.login_question = login.getLogin_question();
		this.user_firstname = user.getUser_firstname();
		this.user_lastname = user.getUser_lastname();
		if (user.getUser_birthday() != null)
			this.user_birthday = new SimpleDateFormat("dd.MM.yyyy").format(user.getUser_birthday());
		this.user_address = user.getUser_address();
		this.user_phone = user.getUser_phone();
		this.user_email = user.getUser_email();
		this.user_skype = user.getUser_skype();
		this.user_details = user.getUser_details();
	}
	
	public void getLoginUser(User user, Login login, Integer role_id) {
		login.setRole_id(role_id);
		login.setLogin_name(login_name);
		if (!((user.getUser_id() != null) && (user.getUser_id() > 0) && login_password.equals("") &&
				login_password_repeat.equals("")))
			login.setLogin_password(login_password.hashCode());
		login.setLogin_question(login_question);
		if (!login_answer.equals(""))
			login.setLogin_answer(login_answer.hashCode());
		user.setUser_firstname(user_firstname);
		user.setUser_lastname(user_lastname);
		try {
			if (user_birthday.equals(""))
				user.setUser_birthday(null);
			else
				user.setUser_birthday(new Date(new SimpleDateFormat("dd.MM.yyyy").parse(user_birthday).getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		user.setUser_address(user_address);
		user.setUser_phone(user_phone);
		user.setUser_email(user_email);
		user.setUser_skype(user_skype);
		user.setUser_details(user_details);
	}
	
	// Getters and setters
	public String getRole_name() {
		return role_name;
	}
	
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	public String getLogin_name() {
		return login_name;
	}
	
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	
	public String getLogin_password() {
		return login_password;
	}
	
	public void setLogin_password(String login_password) {
		this.login_password = login_password;
	}
	
	public String getLogin_password_repeat() {
		return login_password_repeat;
	}
	
	public void setLogin_password_repeat(String login_password_repeat) {
		this.login_password_repeat = login_password_repeat;
	}
	
	public String getLogin_question() {
		return login_question;
	}
	
	public void setLogin_question(String login_question) {
		this.login_question = login_question;
	}
	
	public String getLogin_answer() {
		return login_answer;
	}
	
	public void setLogin_answer(String login_answer) {
		this.login_answer = login_answer;
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
	
	public String getUser_birthday() {
		return user_birthday;
	}
	
	public void setUser_birthday(String user_birthday) {
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
