package info.inaltostudy.inaltoschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import info.inaltostudy.inaltoschool.dao.UserDAO;
import info.inaltostudy.inaltoschool.domain.User;

@Repository
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO UserDAO;

	@Override
	@Transactional
	public void addUser(User user) {
		// TODO Auto-generated method stub
		UserDAO.addUser(user);
	}

	@Override
	@Transactional
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return UserDAO.listUser();
	}

	@Override
	@Transactional
	public void removeUser(Integer id) {
		// TODO Auto-generated method stub
		UserDAO.removeUser(id);
	}

	@Override
	@Transactional
	public User getUser(Integer id) {
		// TODO Auto-generated method stub
		return UserDAO.getUser(id);
	}

	@Override
	@Transactional
	public void setUser(User user) {
		// TODO Auto-generated method stub
		UserDAO.setUser(user);
	}

	@Override
	@Transactional
	public User getByLoginID(Integer id) {
		// TODO Auto-generated method stub
		return UserDAO.getByLoginID(id);
	}

}
