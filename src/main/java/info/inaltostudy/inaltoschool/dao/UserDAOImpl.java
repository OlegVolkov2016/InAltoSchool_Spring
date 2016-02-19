package info.inaltostudy.inaltoschool.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import info.inaltostudy.inaltoschool.domain.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public void removeUser(Integer id) {
		// TODO Auto-generated method stub
		User user = (User) sessionFactory.getCurrentSession().load(User.class,id);
		if (user != null)
			sessionFactory.getCurrentSession().delete(user);
	}

	@Override
	public User getUser(Integer id) {
		// TODO Auto-generated method stub
		return (User) sessionFactory.getCurrentSession().get(User.class,id);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(user,user.getUser_id());
	}

	@Override
	public User getByLoginID(Integer id) {
		// TODO Auto-generated method stub
		return (User) sessionFactory.getCurrentSession().createQuery("from User where User.login_id = "+id).list().get(0);
	}

}
