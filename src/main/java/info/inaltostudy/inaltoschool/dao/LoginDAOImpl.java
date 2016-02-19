package info.inaltostudy.inaltoschool.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import info.inaltostudy.inaltoschool.domain.Login;

@Repository
public class LoginDAOImpl implements LoginDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addLogin(Login login) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(login);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Login> listLogin() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Login").list();
	}

	@Override
	public void removeLogin(Integer id) {
		// TODO Auto-generated method stub
		Login login = (Login) sessionFactory.getCurrentSession().load(Login.class,id);
		if (login != null)
			sessionFactory.getCurrentSession().delete(login);
	}

	@Override
	public Login getLogin(Integer id) {
		// TODO Auto-generated method stub
		return (Login) sessionFactory.getCurrentSession().get(Login.class,id);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setLogin(Login login) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(login, login.getLogin_id());
	}

	@Override
	public Login getByName(String name) {
		// TODO Auto-generated method stub
		return (Login) sessionFactory.getCurrentSession().createQuery("from Login where login_name = \'"+name+"\'").list().get(0);
	}

}
