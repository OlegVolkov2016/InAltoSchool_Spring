package info.inaltostudy.inaltoschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import info.inaltostudy.inaltoschool.dao.RoleDAO;
import info.inaltostudy.inaltoschool.domain.Role;

@Repository
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDAO roleDAO;

	@Override
	@Transactional
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		roleDAO.addRole(role);
	}

	@Override
	@Transactional
	public List<Role> listRole() {
		// TODO Auto-generated method stub
		return roleDAO.listRole();
	}

	@Override
	@Transactional
	public void removeRole(Integer id) {
		// TODO Auto-generated method stub
		roleDAO.removeRole(id);
	}

	@Override
	@Transactional
	public Role getRole(Integer id) {
		// TODO Auto-generated method stub
		return roleDAO.getRole(id);
	}

	@Override
	@Transactional
	public void setRole(Role role) {
		// TODO Auto-generated method stub
		roleDAO.setRole(role);
	}

	@Override
	@Transactional
	public Role getByName(String name) {
		// TODO Auto-generated method stub
		return roleDAO.getByName(name);
	}

}
