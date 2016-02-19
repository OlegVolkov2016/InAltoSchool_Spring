package info.inaltostudy.inaltoschool.service;

import java.util.List;

import info.inaltostudy.inaltoschool.domain.Role;

public interface RoleService {
	public void addRole(Role role);
	public List<Role> listRole();
	public void removeRole(Integer id);
	public Role getRole(Integer id);
	public void setRole(Role role);
	
	public Role getByName(String name);
}
