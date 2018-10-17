package at.aberger.tutorial.jee.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import at.aberger.tutorial.jee.database.Database;
import at.aberger.tutorial.jee.model.Department;

@Named
public class DepartmentDao {
	@Inject @Database 
	private EntityManager em;
	
	public List<Department> findAll() {
		return em.createQuery("select d from Department d", Department.class).getResultList();
	}
}
