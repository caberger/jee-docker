package at.aberger.tutorial.jee.dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import at.aberger.tutorial.jee.model.Department;

@Named
public class DepartmentDao {
	@PersistenceContext 
	EntityManager em;
	
	public List<Department> findAll() {
		return em.createQuery("select d from Department d", Department.class).getResultList();
	}
}
