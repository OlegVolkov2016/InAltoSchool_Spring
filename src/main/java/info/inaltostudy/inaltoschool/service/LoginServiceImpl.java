package info.inaltostudy.inaltoschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import info.inaltostudy.inaltoschool.dao.LoginDAO;
import info.inaltostudy.inaltoschool.domain.Login;

@Repository
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO LoginDAO;

	@Override
	@Transactional
	public void addLogin(Login login) {
		// TODO Auto-generated method stub
		LoginDAO.addLogin(login);
	}

	@Override
	@Transactional
	public List<Login> listLogin() {
		// TODO Auto-generated method stub
		return LoginDAO.listLogin();
	}

	@Override
	@Transactional
	public void removeLogin(Integer id) {
		// TODO Auto-generated method stub
		LoginDAO.removeLogin(id);
	}

	@Override
	@Transactional
	public Login getLogin(Integer id) {
		// TODO Auto-generated method stub
		return LoginDAO.getLogin(id);
	}

	@Override
	@Transactional
	public void setLogin(Login login) {
		// TODO Auto-generated method stub
		LoginDAO.setLogin(login);
	}

	@Override
	@Transactional
	public Login getByName(String name) {
		// TODO Auto-generated method stub
		return LoginDAO.getByName(name);
	}

}
