package info.inaltostudy.inaltoschool.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import info.inaltostudy.inaltoschool.domain.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(role);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> listRole() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Role").list();
	}

	@Override
	public void removeRole(Integer id) {
		// TODO Auto-generated method stub
		Role role = (Role) sessionFactory.getCurrentSession().load(Role.class,id);
		if (role != null)
			sessionFactory.getCurrentSession().delete(role);
	}

	@Override
	public Role getRole(Integer id) {
		// TODO Auto-generated method stub
		return (Role) sessionFactory.getCurrentSession().get(Role.class,id);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setRole(Role role) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(role,role.getRole_id());
		
	}

	@Override
	public Role getByName(String name) {
		// TODO Auto-generated method stub
		return (Role) sessionFactory.getCurrentSession().createQuery("from Role where role_name = \'"+name+"\'").list().get(0);
	}

}
