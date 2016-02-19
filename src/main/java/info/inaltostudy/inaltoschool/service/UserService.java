package info.inaltostudy.inaltoschool.service;

import java.util.List;

import info.inaltostudy.inaltoschool.domain.User;

public interface UserService {
	public void addUser(User user);
	public List<User> listUser();
	public void removeUser(Integer id);
	public User getUser(Integer id);
	public void setUser(User user);
	
	public User getByLoginID(Integer id);
}
