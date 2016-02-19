package info.inaltostudy.inaltoschool.service;

import java.util.List;

import info.inaltostudy.inaltoschool.domain.Login;

public interface LoginService {
	public void addLogin(Login login);
	public List<Login> listLogin();
	public void removeLogin(Integer id);
	public Login getLogin(Integer id);
	public void setLogin(Login login);
	
	public Login getByName(String name);
}
